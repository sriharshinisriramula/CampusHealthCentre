package com.healthcentre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = System.getenv().getOrDefault(
            "DB_URL", "jdbc:oracle:thin:@localhost:1521/FREE");
    private static final String USERNAME = System.getenv().getOrDefault(
            "DB_USERNAME", "SYSTEM");
    private static final String PASSWORD = System.getenv().getOrDefault(
            "DB_PASSWORD", "NewPassword123");

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public static boolean isAvailable() {
        try (Connection connection = getConnection()) {
            return connection != null;
        } catch (SQLException e) {
            return false;
        }
    }
}
