package com.example.UserPackage;

import com.example.database.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        // TODO implement here
        return null;
    }

}
