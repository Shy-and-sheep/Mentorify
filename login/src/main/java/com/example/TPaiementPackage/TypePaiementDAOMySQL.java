package com.example.TPaiementPackage;

import com.example.database.MySQLConnection;

import java.sql.*;
import java.util.*;

/**
 * 
 */
public class TypePaiementDAOMySQL extends TypePaiementDAO {

    /**
     * Default constructor
     */
    public TypePaiementDAOMySQL() {
    }

    /**
     *
     *
     */
    public TypePaiement getTypePaiementByIdDAO(int id) {
        Connection conn = MySQLConnection.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        TypePaiement typePaiement = null;

        try {
            String query = "select id, nom, description FROM TypePaiement WHERE id = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                int TypePaiementId = rs.getInt("id");
                String TypePaiementNom = rs.getString("nom");
                String TypePaiementDescription = rs.getString("description");

                typePaiement = new TypePaiement(TypePaiementId, TypePaiementNom, TypePaiementDescription);
                System.out.println(typePaiement.getNom());
                System.out.println(typePaiement.getDescription());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return typePaiement;
    }

    /**
     * Retourne une liste contenant tous les types paiement.
     * Retourne une liste vide si il n'y en a aucune.
     */
    public List<TypePaiement> getAllTypePaiement() {
        Connection conn = MySQLConnection.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<TypePaiement> typePaiementList = null;

        try {
            String query = "select id, nom, description FROM TypePaiement";
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int TypePaiementId = rs.getInt("id");
                String TypePaiementNom = rs.getString("nom");
                String TypePaiementDescription = rs.getString("description");

                TypePaiement typePaiement = new TypePaiement(TypePaiementId, TypePaiementNom, TypePaiementDescription);

                typePaiementList.add(typePaiement);

                System.out.println(typePaiement.getNom());
                System.out.println(typePaiement.getDescription());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return typePaiementList;
    }

    /**
     *
     *
     */
    public TypePaiement setTypePaiementDAO(int id, String nom, String description) {
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement stmt = null;
        TypePaiement typePaiement = null;

        try {
            String query = "UPDATE TypePaiement SET nom = ?, description = ? WHERE id = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, nom);
            stmt.setString(2, description);
            stmt.setInt(3, id);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                // Si la mise à jour a réussi, récupérer le type de paiement mis à jour
                typePaiement = new TypePaiement(id, nom, description);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typePaiement;
    }

    /**
     *
     *
     *
     */
    public TypePaiement addTypePaiementDAO(String nom, String description) {
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet generatedKeys = null;
        TypePaiement newTypePaiement = null;

        try {
            String query = "INSERT INTO TypePaiement (nom, description) VALUES (?, ?)";
            stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, nom);
            stmt.setString(2, description);
            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("La création du type de paiement a échoué, aucune ligne n'a été modifiée.");
            }

            generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                newTypePaiement = new TypePaiement(id, nom, description);
                System.out.println("Type paiement ajoutée avec l'ID : " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newTypePaiement;
    }

    /**
     *
     */
    public void removeTypePaiementDAO(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = MySQLConnection.getConnection();
            String query = "DELETE FROM TypePaiement WHERE id = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.executeUpdate();

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Le type de paiement avec l'ID " + id + " a été supprimé avec succès.");
            }
            else {
                System.out.println("Le type de paiement avec l'ID " + id + " n'a PAS été supprimé.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}