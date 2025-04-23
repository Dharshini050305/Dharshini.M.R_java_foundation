package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DBPropertyUtil {
	public static String getPropertyString() {
        // Hardcode database connection details here
        String host = "localhost";
        String port = "3306";
        String dbName = "hmbank";
        String user = "root";
        String password = "Dharsh@2003";
        
        // Return the connection string
        return String.format("jdbc:mysql://%s:%s/%s?user=%s&password=%s", 
                host, port, dbName, user, password);
    }
}