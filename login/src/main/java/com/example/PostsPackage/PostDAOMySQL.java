package com.example.PostsPackage;

import com.example.database.MySQLConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostDAOMySQL extends PostDA0 {
    Post post;

    public PostDAOMySQL() {
    }

    public Post getPostById(int id) {
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement statement = null;
        try {
            String query = "SELECT * FROM Posts WHERE id = ?";
            statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int auteurId = resultSet.getInt("autheurId");
                int typePostId = resultSet.getInt("typePostId");
                int nbLike = resultSet.getInt("nbLike");
                int sessionId = resultSet.getInt("sessionId");
                String contenu = resultSet.getString("contenu");

                return new Post(id, typePostId, sessionId, auteurId, contenu, nbLike);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void removePost(int id) {
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement statement = null;
        try {
            String query = "DELETE FROM Posts WHERE id = ?";
            statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //TODO méthode getPostByPostId

    public List<Post> getPost() {
        System.out.println("je suis appelée ");
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement statement = null;
        List<Post> posts = new ArrayList<>();
        try {
            String query = "SELECT id,autheurId,typePostId,contenu, sessionId, nbLike FROM Posts";
            statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            System.out.println("**********************");
            System.out.println(resultSet);
            System.out.println("**********************");
            while (resultSet.next()) {
                int postId = resultSet.getInt("id");
                int auteurId = resultSet.getInt("autheurId");
                int typePostId = resultSet.getInt("typePostId");
                String contenu = resultSet.getString("contenu");
                int sessionId = resultSet.getInt("sessionId");
                int nbLike = resultSet.getInt("nbLike");

                System.out.println("**********************");
                Post post = new Post(postId, typePostId, sessionId, auteurId, contenu, nbLike);
                posts.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }

    public Post addPost(int auteurId, String contenu, int typePostId, int nbLike, int sessionId) {
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet generatedKeys = null;
        Post createdPost = null;

        try {
            String query = "INSERT INTO Posts (autheurId, contenu, typePostId, nbLike, sessionId) VALUES (?, ?, ?, ?, ?)";
            statement = conn.prepareStatement(query,  Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, auteurId);
            statement.setString(2, contenu);
            statement.setInt(3, typePostId);
            statement.setInt(4, nbLike);
            statement.setInt(5, sessionId);

            int rowsAffected = statement.executeUpdate();
            System.out.println("... rows" + rowsAffected);
            if (rowsAffected == 1) {
                System.out.println("zoirgjoaeijrgpo ******************");
                generatedKeys = statement.getGeneratedKeys();
                System.out.println("zoirgjoaeijrgpo ******************");
                if (generatedKeys.next()) {
                    System.out.println(generatedKeys.getInt(1));
                    int postId = generatedKeys.getInt(1); // Récupérer l'ID du post inséré

                    // Créer un objet Post avec les valeurs récupérées de la base de données
                    createdPost = new Post(postId, typePostId, sessionId, auteurId, contenu, nbLike);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fermer les ressources (statement, resultset, connexion)
            if (generatedKeys != null) {
                try {
                    generatedKeys.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(createdPost);
        return createdPost; // Renvoyer le post créé ou null en cas d'échec
    }



    public Post setPost(int postId, int auteurId, String contenu, int typePostId, int nbLike, int sessionId) {
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement statement = null;
        try {
            String query = "UPDATE Posts SET autheurId=?, contenu=?, typePostId=?, nbLike=?, sessionId=? WHERE id=?";
            statement = conn.prepareStatement(query);
            statement.setInt(1, auteurId);
            statement.setString(2, contenu);
            statement.setInt(3, typePostId);
            statement.setInt(4, nbLike);
            statement.setInt(5, sessionId);
            statement.setInt(6, postId);
            statement.executeUpdate();

            // Créer un nouvel objet Post avec les valeurs mises à jour et le renvoyer
            Post updatedPost = new Post(postId, typePostId, sessionId, auteurId, contenu, nbLike);
            return updatedPost;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Post> getPostByTPId(int tpId) {
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement statement = null;
        List<Post> posts = new ArrayList<>();
        try {
            String query = "SELECT id, autheurId, typePostId, contenu, sessionId, nbLike FROM Posts WHERE typePostId = ?";
            statement = conn.prepareStatement(query);
            statement.setInt(1, tpId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int postId = resultSet.getInt("id");
                int auteurId = resultSet.getInt("autheurId");
                int typePostId = resultSet.getInt("typePostId");
                String contenu = resultSet.getString("contenu");
                int sessionId = resultSet.getInt("sessionId");
                int nbLike = resultSet.getInt("nbLike");

                Post post = new Post(postId, typePostId, sessionId, auteurId, contenu, nbLike);
                posts.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }

}
