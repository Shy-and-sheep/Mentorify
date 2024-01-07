package com.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/projet_se";
    private static final String USER = "projet";
    private static final String PASSWORD = "Romaissa213**";
    private static Connection conn;

    private MySQLConnection() {
    }

    public static Connection getConnection() {
        try {
            if (conn != null && conn.isClosed()){
                conn = null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (conn == null) {
            try {
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Connexion à la base de données réussie !");
            } catch (SQLException e) {
                System.err.println("Erreur lors de la connexion à la base de données : " + e.getMessage());
            }
        }
        return conn;
    }
}
