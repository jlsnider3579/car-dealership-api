package com.pluralsight.dealership;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConfig {
    private static BasicDataSource dataSource;

    public static BasicDataSource getDataSource(String url, String userName, String password) {

        // If the dataSource has not been initialized, create a new one
        if (dataSource == null) {
            dataSource = new BasicDataSource(); // Initialize the data source
            dataSource.setUrl(url); // Set the URL for the database
            dataSource.setUsername(userName);    // Set the username for the database
            dataSource.setPassword(password);    // Set the password for the database
        }

        // Return the singleton data source
        return dataSource;
    }

    public static Connection getConnection(String url, String userName, String password) throws SQLException {
        // Retrieve the data source and return a connection from it
        return getDataSource(url, userName, password).getConnection();
    }
}
