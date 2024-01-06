package com.example.TFPackage;

import com.example.TFPackage.TypeFormation;
import com.example.TFPackage.TypeFormationDA0;
import com.example.database.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.sql.Statement;

public class TypeFormationDAOMySQL extends TypeFormationDA0 {

    /**
     * Default constructor
     */
    public TypeFormationDAOMySQL() {
    }

    public TypeFormation getTypeFormationById(int id) {
        Connection conn = MySQLConnection.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        TypeFormation typeFormation = null;

        try {
            String query = "SELECT id, nom, description FROM typeformations WHERE id = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                int typeformationId = rs.getInt("id");
                String typeformationNom = rs.getString("nom");
                String typeformationDescription = rs.getString("description");

                typeFormation = new TypeFormation(typeformationId, typeformationNom, typeformationDescription);
                System.out.println(typeFormation.getNom());
                System.out.println(typeFormation.getDescription());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typeFormation;
    }

    public void removeTypeFormation(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = MySQLConnection.getConnection();
            String query = "DELETE FROM typeformations WHERE id = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("La formation avec l'ID " + id + " a été supprimée avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return La liste des type de formation présents dans la table
     */
    public List<TypeFormation> getAllTypeFormation() {
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<TypeFormation> typeFormations = new ArrayList<>();

        try {
            String query = "SELECT id, nom, description FROM typeformations";
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int typeformationId = rs.getInt("id");
                String typeformationNom = rs.getString("nom");
                String typeformationDescription = rs.getString("description");

                TypeFormation typeFormation = new TypeFormation(typeformationId, typeformationNom, typeformationDescription);
                typeFormations.add(typeFormation);
                System.out.println("Nom : " + typeFormation.getNom() + ", Description : " + typeFormation.getDescription());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typeFormations;
    }

    public TypeFormation addTypeFormation(String nom, String description) {
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet generatedKeys = null;
        TypeFormation newTypeFormation = null;

        try {
            String query = "INSERT INTO typeformations (nom, description) VALUES (?, ?)";
            stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, nom);
            stmt.setString(2, description);
            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("La création de la formation a échoué, aucune ligne n'a été modifiée.");
            }

            generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                newTypeFormation = new TypeFormation(id, nom, description);
                System.out.println("Formation ajoutée avec l'ID : " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newTypeFormation;
    }


    public TypeFormation setTypeFormation(int id, String nom, String description) {
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement stmt = null;
        TypeFormation typeFormation = null;

        try {
            String query = "UPDATE typeformations SET nom = ?, description = ? WHERE id = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, nom);
            stmt.setString(2, description);
            stmt.setInt(3, id);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                // Si la mise à jour a réussi, récupérer le type de formation mis à jour
                typeFormation = new TypeFormation(id, nom, description);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typeFormation;
    }
}