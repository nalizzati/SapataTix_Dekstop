package com.example.sapatatix.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String URL = "jdbc:postgresql://db.mcqhhdeqkuklvxglpycb.supabase.co:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASS = "+k$.$KkY7kLQiP6";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}