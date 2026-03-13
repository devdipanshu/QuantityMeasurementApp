package com.quantity.QuantityMeasurementApp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL =
    "jdbc:mysql://localhost:3306/quantitymeasurement";

    private static final String USER = "root";
    private static final String PASSWORD = "dipanshu@123";

    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    public static void main(String[] args) throws Exception {

        Connection conn = DBConnection.getConnection();

        if(conn != null){
            System.out.println("Database Connected!");
        }
    }
}