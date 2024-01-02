package com.example.TPPackage;

import com.example.database.MySQLConnection;

import java.sql.*;
import java.util.*;


/**
 * 
 */
public class TypePostDAOMySQL extends TypePostDA0 {

    /**
     * Default constructor
     */
    public TypePostDAOMySQL() {
    }

    /**
     * @param int id 
     * @return TypePost
     */
    public TypePost getTypePostById(int id) {
        Connection conn = MySQLConnection.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        TypePost TypePost = null;

        try {
            String query = "SELECT id, nom, description FROM TypePosts WHERE id = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                int TypePostId = rs.getInt("id");
                String TypePostNom = rs.getString("nom");
                String TypePostDescription = rs.getString("description");

                TypePost = new TypePost(TypePostId, TypePostNom, TypePostDescription);
                System.out.println(TypePost.getNom());
                System.out.println(TypePost.getDescription());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return TypePost;
    }


    /**
     * @param int id 
     * @return
     */
    public void removeTypePost(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = MySQLConnection.getConnection();
            String query = "DELETE FROM TypePosts WHERE id = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Le type de post avec l'ID " + id + " a été supprimée avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    /**
     * @return La liste des type de post présents dans la table
     */
    public List<TypePost> getAllTypePost() {
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<TypePost> TypePosts = new ArrayList<>();

        try {
            String query = "SELECT id, nom, description FROM TypePosts";
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int TypePostId = rs.getInt("id");
                String TypePostNom = rs.getString("nom");
                String TypePostDescription = rs.getString("description");

                TypePost TypePost = new TypePost(TypePostId, TypePostNom, TypePostDescription);
                TypePosts.add(TypePost);
                System.out.println("Nom : " + TypePost.getNom() + ", Description : " + TypePost.getDescription());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return TypePosts;
    }


    /**
     * @param String nom 
     * @param String description 
     * @return
     */
    public TypePost addTypePost(String nom, String description) {
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet generatedKeys = null;
        TypePost newTypePost = null;

        try {
            String query = "INSERT INTO TypePosts (nom, description) VALUES (?, ?)";
            stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, nom);
            stmt.setString(2, description);
            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("La création du type de post a échoué, aucune ligne n'a été modifiée.");
            }

            generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                newTypePost = new TypePost(id, nom, description);
                System.out.println("Type post ajoutée avec l'ID : " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newTypePost;
    }


    public TypePost setTypePost(int id, String nom, String description) {
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement stmt = null;
        TypePost TypePost = null;

        try {
            String query = "UPDATE TypePosts SET nom = ?, description = ? WHERE id = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, nom);
            stmt.setString(2, description);
            stmt.setInt(3, id);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                // Si la mise à jour a réussi, récupérer le type de post mis à jour
                TypePost = new TypePost(id, nom, description);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return TypePost;
    }
}