package br.uniopet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/workspace_db";
        Properties props = new Properties();
        props.setProperty("user", "admin");
        props.setProperty("password", "admin");
        try (Connection conn = DriverManager.getConnection(url, props)) {
            if (conn != null) {
                String nome = "Pedro Eckel";
                Integer idade = 25;

                String insertSQL = "INSERT INTO users (name, age) VALUES (?, ?)";
                try (var pstmt = conn.prepareStatement(insertSQL)) {
                    pstmt.setString(1, nome);
                    pstmt.setInt(2, idade);
                    int rowsAffected = pstmt.executeUpdate();
                    System.out.println("Rows inserted: " + rowsAffected);
                }
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }
}