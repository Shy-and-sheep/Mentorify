package com.example.RolePackage;

import com.example.TPPackage.TypePost;
import com.example.database.MySQLConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PermissionDAOMySQL extends PermissionDA0 {

    public PermissionDAOMySQL() {
    }


    public Permission setPermissionDAO(int idP, String libelle, String description) {
    	Connection conn = MySQLConnection.getConnection();
        PreparedStatement statement = null;
        try {
            String query = "UPDATE Permissions SET libelle=?, description=? WHERE id=?";
            statement = conn.prepareStatement(query);
            statement.setString(1, libelle);
            statement.setString(2, description);
            statement.setInt(3, idP);
            statement.executeUpdate();

            Permission updatedPermission = new Permission(idP, libelle, description);
            return updatedPermission;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Permission> getAllPermission() {
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Permission> Permissions = new ArrayList<>();

        try {
            String query = "SELECT id, libelle, description FROM Permissions";
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int PermissionId = rs.getInt("id");
                String PermissionLibelle = rs.getString("libelle");
                String PermissionDescription = rs.getString("description");

                Permission Permission = new Permission(PermissionId, PermissionLibelle, PermissionDescription);
                Permissions.add(Permission);
                System.out.println("Nom : " + Permission.getLibelle() + ", Description : " + Permission.getDescription());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Permissions;
    }

    public void removePermissionDAO(int idP) {
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement statement = null;
        try {
            String query = "DELETE FROM Permissions WHERE id = ?";
            statement = conn.prepareStatement(query);
            statement.setInt(1, idP);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


	public Permission getPermissionById(int idP) {
		Connection conn = MySQLConnection.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Permission Permission = null;

        try {
            String query = "SELECT id, libelle, description FROM Permissions WHERE id = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, idP);
            rs = stmt.executeQuery();

            if (rs.next()) {
                int PermissionId = rs.getInt("id");
                String PermissionLibelle = rs.getString("libelle");
                String PermissionDescription = rs.getString("description");

                Permission = new Permission(PermissionId, PermissionLibelle, PermissionDescription);
                System.out.println(Permission.getLibelle());
                System.out.println(Permission.getDescription());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Permission;
	}

}