package br.uniopet;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/workspace_db";
        Properties props = new Properties();
        props.setProperty("user", "admin");
        props.setProperty("password", "admin");
        Connection conn = DriverManager.getConnection(url, props);
    }
}