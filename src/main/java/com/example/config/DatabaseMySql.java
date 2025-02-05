package com.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseMySql {
    private static final String URL = "jdbc:mysql://localhost:3306/company";
    private static final String USER = "mario";
    private static final String PASSWORD = "12345";

    public static Connection getConnection() throws SQLException, SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

