package com.example.LoginPackage;

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
            String query = "SELECT id, username, password, name FROM users WHERE username = ? AND password = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, mdp);
            rs = stmt.executeQuery();

            if (rs.next()) {
                int userId = rs.getInt("id");
                String retrievedUsername = rs.getString("username");
                String retrievedPassword = rs.getString("password");
                String retrievedName = rs.getString("name");

                user = new User(userId, retrievedPassword, retrievedUsername, retrievedName);
                System.out.println(user.getName());
                System.out.println(user.getUsername());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

}
