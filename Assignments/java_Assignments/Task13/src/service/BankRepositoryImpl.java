package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.Account;
import entity.Customer;
import entity.Transactions;
import exception.InsufficientFundException;
import exception.InvalidAccountException;
import exception.OverDraftLimitExceededException;
public class BankRepositoryImpl implements IBankRepository {

	

	Connection con;

    // Constructor to initialize the connection
    public BankRepositoryImpl() throws Exception {
        this.con = util.DBConnUtil.getConnection();
    }

    // Create account method
    @Override
    public void createAccount(Customer customer, long accountid, String accounttype, float balance) {
        try {
            String customerSql = "INSERT INTO Customers (customerid, firstname, lastname, email, phonenumber, address, dob) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = con.prepareStatement(customerSql)) {
                stmt.setInt(1, customer.getCustomerid());
                stmt.setString(2, customer.getFirstname());
                stmt.setString(3, customer.getLastname());
                stmt.setString(4, customer.getEmail());
                stmt.setString(5, customer.getPhonenumber());
                stmt.setString(6, customer.getAddress());
                stmt.setString(7, customer.getDob());
                stmt.executeUpdate();
            }

            String accountSql = "INSERT INTO Accounts (accountid, accounttype, balance, customerid) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = con.prepareStatement(accountSql)) {
                stmt.setLong(1, accountid);
                stmt.setString(2, accounttype.toLowerCase()); // match ENUM
                stmt.setFloat(3, balance);
                stmt.setInt(4, customer.getCustomerid());
                stmt.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Account> listAccounts() {
        List<Account> accounts = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Accounts";
            try (PreparedStatement stmt = con.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    long accountid = rs.getLong("accountid");
                    String accounttype = rs.getString("accounttype");
                    float balance = rs.getFloat("balance");
                    int customerid = rs.getInt("customerid");
                    Customer customer = getCustomerById(customerid);
                    if (customer == null) {
                        throw new NullPointerException("No customer found for account");
                    }
                    Account account = new Account(accounttype, balance, customer);
                    account.setAccountid(accountid);
                    accounts.add(account);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    @Override
    public float getBalance(long accountid) {
        try {
            String sql = "SELECT balance FROM Accounts WHERE accountid = ?";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setLong(1, accountid);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        return rs.getFloat("balance");
                    } else {
                        System.out.println("Account not found: " + accountid);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void deposit(long accountid, float amount) throws Exception {
        try {
            String sql = "UPDATE Accounts SET balance = balance + ? WHERE accountid = ?";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setFloat(1, amount);
                stmt.setLong(2, accountid);
                int rows = stmt.executeUpdate();
                if (rows > 0) {
                    float newBalance = getBalance(accountid);
                    System.out.println("Deposit successful. New Balance: " + newBalance);
                } else {
                    throw new InvalidAccountException("Account not found");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void withdraw(long accountid, float amount)
            throws OverDraftLimitExceededException, InsufficientFundException, InvalidAccountException {
        try {
            String sqlSelect = "SELECT balance, accounttype FROM Accounts WHERE accountid = ?";
            String sqlUpdate = "UPDATE Accounts SET balance = balance - ? WHERE accountid = ?";

            try (PreparedStatement sel = con.prepareStatement(sqlSelect);
                 PreparedStatement upd = con.prepareStatement(sqlUpdate)) {

                sel.setLong(1, accountid);
                try (ResultSet rs = sel.executeQuery()) {
                    if (rs.next()) {
                        float currentBalance = rs.getFloat("balance");
                        String accounttype = rs.getString("accounttype");

                        switch (accounttype.toLowerCase()) {
                            case "savings":
                                if (currentBalance - amount < 500)
                                    throw new InsufficientFundException("Savings account min balance violated");
                                break;
                            case "current":
                                if (currentBalance - amount < -10000)
                                    throw new OverDraftLimitExceededException();
                                break;
                            case "zero_balance":
                                if (currentBalance - amount < 0)
                                    throw new InsufficientFundException("Zero balance account cannot go negative");
                                break;
                        }

                        upd.setFloat(1, amount);
                        upd.setLong(2, accountid);
                        int rows = upd.executeUpdate();

                        if (rows > 0) {
                            float newBalance = getBalance(accountid);
                            System.out.println("Withdrawal successful. New Balance: " + newBalance);
                        }

                    } else {
                        throw new InvalidAccountException("Account not found");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Transactions> getTransactionsBetweenDate(long accountid, String fromDate, String toDate) {
        List<Transactions> transactions = new ArrayList<>();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date start = sdf.parse(fromDate);
            Date end = sdf.parse(toDate);
            String sql = "SELECT * FROM Transactions WHERE accountid = ? AND transactiondate BETWEEN ? AND ?";

            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setLong(1, accountid);
                stmt.setTimestamp(2, new Timestamp(start.getTime()));
                stmt.setTimestamp(3, new Timestamp(end.getTime()));

                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        Transactions t = new Transactions();
                        t.setTransactionid(rs.getInt("transactionid"));
                        t.setAccountid(rs.getLong("accountid"));
                        t.setTransactiontype(rs.getString("transactiontype"));
                        t.setAmount(rs.getDouble("amount"));
                        t.setTransactiondate(rs.getDate("transactiondate"));
                        transactions.add(t);
                    }
                }
            }
        } catch (ParseException | SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }

    private Customer getCustomerById(int customerid) {
        try {
            String sql = "SELECT * FROM Customers WHERE customerid = ?";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, customerid);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        return new Customer(
                                customerid,
                                rs.getString("firstname"),
                                rs.getString("lastname"),
                                rs.getString("email"),
                                rs.getString("phonenumber"),
                                rs.getString("address"),
                                rs.getString("dob")
                        );
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean accountExists(long accountid) throws SQLException {
        String sql = "SELECT 1 FROM Accounts WHERE accountid = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setLong(1, accountid);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        }
    }

    void addTransaction(Transactions transaction) {
        try {
            if (!accountExists(transaction.getAccountid())) {
                System.out.println("Account ID " + transaction.getAccountid() + " not found. Cannot insert transaction.");
                return;
            }

            if (transaction.getTransactiondate() == null) {
                transaction.setTransactiondate(new Date());
            }

            String sql = "INSERT INTO Transactions (accountid, transactionid, transactiondate, transactiontype, amount) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setLong(1, transaction.getAccountid());
                stmt.setFloat(2, transaction.getTransactionid());
                stmt.setTimestamp(3, new Timestamp(transaction.getTransactiondate().getTime()));
                stmt.setString(4, transaction.getTransaction_type().toLowerCase()); // match ENUM
                stmt.setDouble(5, transaction.getAmount());
                int rows = stmt.executeUpdate();
                if (rows > 0) {
                    System.out.println("Transaction added successfully.");
                } else {
                    System.out.println("Transaction insert failed.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}