package com.example.RolePackage;

import java.util.*;

import com.example.FormationPackage.Formation;
import com.example.PostsPackage.Post;
import com.example.database.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class RoleDAOMySQL extends RoleDA0 {

    public RoleDAOMySQL() {}

    //Modifier tout pour garder les permissions dans la bd
    public Role setRole(String libelle, String description, Permission[] permissions) {
    	Connection conn = MySQLConnection.getConnection();
        PreparedStatement statement = null;
        try {
            String query = "UPDATE Roles SET libelle=?, description=?, permissions=? WHERE id=?";
            statement = conn.prepareStatement(query);
            statement.setString(1, libelle);
            statement.setString(2, description);
            statement.executeUpdate();

            Role updatedRole = new Role(libelle, description, permissions);
            return updatedRole;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void removeRole(int idR) {
    	Connection conn = MySQLConnection.getConnection();
        PreparedStatement statement = null;
        try {
            String query = "DELETE FROM Roles WHERE id = ?";
            statement = conn.prepareStatement(query);
            statement.setInt(1, idR);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


  //Modifier tout pour garder les permissions dans la bd
    public Role getRoleById(int idR) {
    	Connection conn = MySQLConnection.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Role role = null;

        try {
            String query = "SELECT id, libelle, description, permissions FROM Roles WHERE id = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, idR);
            rs = stmt.executeQuery();

            if (rs.next()) {
                int roleId = rs.getInt("id");
                String libelle = rs.getString("libelle");
                String description = rs.getString("description");
                
                Permission[] permissions = null;

                role = new Role(libelle, description, permissions);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }

}