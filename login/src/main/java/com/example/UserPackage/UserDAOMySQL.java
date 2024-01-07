package com.example.UserPackage;

import com.example.database.MySQLConnection;

import java.sql.*;

/**
 * 
 */
public class UserDAOMySQL extends UserDA0 {

    /**
     * Default constructor
     */
    public UserDAOMySQL() {
    }

    /**
     *
     */
    public User getUserByCredentials(String username, String mdp) {
        Connection conn = MySQLConnection.getConnection(); // Méthode pour obtenir la connexion depuis MySQLConnection

        PreparedStatement stmt = null;
        ResultSet rs = null;
        User user = null;

        try {
            String query = "SELECT id, username, password, name, first_name, email, statut FROM users WHERE username = ? AND password = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, mdp);
            rs = stmt.executeQuery();

            if (rs.next()) {
                int userId = rs.getInt("id");
                String retrievedUsername = rs.getString("username");
                String retrievedPassword = rs.getString("password");
                String retrievedName = rs.getString("name");
                String retrievedFirstName = rs.getString("first_name");
                String retrievedEmail = rs.getString("email");
                String retrievedStatut = rs.getString("statut");


                user = new User(userId, retrievedPassword, retrievedUsername, retrievedName, retrievedFirstName, retrievedEmail, retrievedStatut);
                System.out.println(user.getName());
                System.out.println(user.getUsername());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public User CreateUser(String name, String first_name, String username, String mdp, String email, String statut) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet generatedKeys = null;
        User newUser = null;

        try {
            conn = MySQLConnection.getConnection();
            String sql = "INSERT INTO users (name, first_name, username, password, email, statut) VALUES (?, ?, ?, ?, ?, ?)";

            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, name);
            stmt.setString(2, first_name);
            stmt.setString(3, username);
            stmt.setString(4, mdp); // hasher le mot de passe ici si jamais on veut développer plus le logiciel plus tard
            stmt.setString(5, email);
            stmt.setString(6, statut);

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

            generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int userId = generatedKeys.getInt(1);
                newUser = new User(userId, mdp, username, name, first_name, email, statut);
            } else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (generatedKeys != null) try { generatedKeys.close(); } catch (SQLException logOrIgnore) {}
            if (stmt != null) try { stmt.close(); } catch (SQLException logOrIgnore) {}
            if (conn != null) try { conn.close(); } catch (SQLException logOrIgnore) {}
        }

        return newUser;
    }


    //Méthode pour vérifier si l'utilisateur existe déjà dans la BD ou pas (au moment de l'inscription
    /*
    public boolean userExists(String username, String email) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = MySQLConnection.getConnection();
            String sql = "SELECT COUNT(*) FROM users WHERE username = ? OR email = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, email);

            rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fermer les ressources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    */


}
