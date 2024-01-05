package com.example.CommentairePackage;

import com.example.TFPackage.TypeFormation;
import com.example.database.MySQLConnection;

import java.security.Timestamp;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.lang.*;


public class CommentaireDAOMySQL extends CommentaireDA0 {

    public CommentaireDAOMySQL() {}

    public Commentaire getCommentaireById(int id) {
        Connection conn = MySQLConnection.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Commentaire commentaire = null;

        try {
            String query = "SELECT id, formationId, authorName, contenu, note FROM Commentaires WHERE id = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                int commentaireId = rs.getInt("id");
                int formationId = rs.getInt("formationId");
                String authorName = rs.getString("authorName");
                String contenu = rs.getString("contenu");
                int note = rs.getInt("note");

                commentaire = new Commentaire(commentaireId, formationId, authorName, contenu, note);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commentaire;
    }


    public void removeCommentaire(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = MySQLConnection.getConnection();

            String deleteCommentaireQuery = "DELETE FROM Commentaires WHERE id = ?";
            stmt = conn.prepareStatement(deleteCommentaireQuery);
            stmt.setInt(1, id);
            stmt.executeUpdate();

            System.out.println("Le Commentaire avec l'ID " + id + " a été supprimée avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Commentaire> getAllCommentaire() {
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Commentaire> commentaires = new ArrayList<>();

        try {
            String query = "SELECT id,formationId,authorName,contenu,note FROM Commentaires";
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int commentaireId = rs.getInt("id");
                int formationId = rs.getInt("formationId");
                String authorName = rs.getString("authorName");
                String contenu = rs.getString("contenu");
                int note = rs.getInt("note");


                Commentaire commentaire = new Commentaire(commentaireId, formationId, authorName,contenu,note);
                commentaires.add(commentaire);
                System.out.println("Nom : " + commentaire.getId() + ", Contenu : " + commentaire.getContenu());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commentaires;
    }

    public Commentaire addCommentaire(int formationId, String authorName, String contenu, int note) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Commentaire nouveauCommentaire = null;

        try {
            conn = MySQLConnection.getConnection();

            // Ajout du commentaire avec la date actuelle
            String query = "INSERT INTO Commentaires (formationId, authorName, contenu, note) VALUES (?, ?, ?, ?)";
            stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, formationId);
            stmt.setString(2, authorName);
            stmt.setString(3, contenu);
            stmt.setInt(4, note);
            int rowsInserted = stmt.executeUpdate();

            if (rowsInserted > 0) {
                // Récupération de l'ID du commentaire ajouté
                rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    int nouveauCommentaireId = rs.getInt(1);
                    nouveauCommentaire = new Commentaire(nouveauCommentaireId, formationId, authorName, contenu, note);
                    System.out.println("Commentaire ajoutée avec l'ID : " + nouveauCommentaireId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nouveauCommentaire;
    }

    public Commentaire setCommentaire(int id,int formationId,String authorName,String contenu,int note) {
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement stmt = null;
        Commentaire commentaire = null;

        try {
            String query = "UPDATE Commentaires SET contenu = ?, note = ? WHERE id = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, contenu);
            stmt.setInt(2, note);
            stmt.setInt(3, id);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                commentaire = new Commentaire(id,formationId,authorName,contenu,note);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commentaire;
    }

    public List<Commentaire> getCommentairesByFormationId(int formationId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Commentaire> commentaires = new ArrayList<>();

        try {
            conn = MySQLConnection.getConnection();
            String query = "SELECT id, authorName, contenu, note FROM Commentaires WHERE formationId = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, formationId);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int commentaireId = rs.getInt("id");
                String authorName = rs.getString("authorName");
                String contenu = rs.getString("contenu");
                int note = rs.getInt("note");

                Commentaire commentaire = new Commentaire(commentaireId, formationId, authorName, contenu, note);
                commentaires.add(commentaire);
                System.out.println(commentaire);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commentaires;
    }

}