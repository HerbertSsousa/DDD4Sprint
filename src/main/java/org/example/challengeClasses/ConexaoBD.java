package org.example.challengeClasses;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexaoBD {

    private static final String DB_PROPERTIES_FILE = "database.properties";

    public static Connection getConnection() throws SQLException {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream(DB_PROPERTIES_FILE)) {
            props.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new SQLException("Could not load database properties file.");
        }

        String url = props.getProperty("jdbc.url");
        String user = props.getProperty("jdbc.username");
        String password = props.getProperty("jdbc.password");

        return DriverManager.getConnection(url, user, password);
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
