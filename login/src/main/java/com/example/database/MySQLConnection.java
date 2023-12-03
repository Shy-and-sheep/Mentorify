package com.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnection {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/ projet_se";
        String utilisateur = "projet";
        String motDePasse = "Romaissa213";
        // Requête de création de table
        String createTableQuery = "CREATE TABLE IF NOT EXISTS users ("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "username VARCHAR(50) NOT NULL,"
                + "password VARCHAR(50) NOT NULL)";

        try (Connection conn = DriverManager.getConnection(url, utilisateur, motDePasse);
             Statement stmt = conn.createStatement()) {
            // Exécution de la requête SQL pour créer la table
            stmt.executeUpdate(createTableQuery);
            System.out.println("La table a été créée avec succès !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de la création de la table : " + e.getMessage());
        }
    }
}
