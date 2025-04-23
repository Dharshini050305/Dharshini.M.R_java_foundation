package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class DBConnUtil {
	private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            // Get the connection string from DBPropertyUtil (now hardcoded)
            String connectionString = DBPropertyUtil.getPropertyString();
            
            if (connectionString == null) {
                throw new SQLException(" Connection string is null.");
            }
            connection = DriverManager.getConnection(connectionString);
            System.out.println(" Database connection established.");
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            System.out.println(" Database connection closed.");
        }
    }
}