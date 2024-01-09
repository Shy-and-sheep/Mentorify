package com.example.RolePackage;

import java.util.List;

public class DAOMySQLFactory extends AbstractDAOFactory {

    private RoleDAOMySQL roleDAOMySQL;
    
    private PermissionDAOMySQL permissionDAOMySQL;

    public DAOMySQLFactory() {
        super();
        this.roleDAOMySQL = new RoleDAOMySQL();
        this.permissionDAOMySQL = new PermissionDAOMySQL();
    }

    public Role setRoleDAO(String libelle, String description, Permission[] permissions) {
        return this.setRoleDAO(libelle, description, permissions);
    }

    public void removeRoleDAO(int idR) {
        this.roleDAOMySQL.removeRole(idR);    }

    public Role getRoleByIdDAO(int idR) {
        return this.roleDAOMySQL.getRoleById(idR);
    }
    
    public Permission setPermissionDAO(int idP, String libelle, String description) {
        return this.permissionDAOMySQL.setPermissionDAO(idP,libelle,description);
    }

    public void removePermissionDAO(int idP) {
        this.permissionDAOMySQL.removePermissionDAO(idP);
    }

	@Override
	public List<Permission> getAllPermissionDAO() {
		return this.permissionDAOMySQL.getAllPermission();
	}

	@Override
	public Permission getPermissionByIdDAO(int idP) {
		return this.permissionDAOMySQL.getPermissionById(idP);
	}

}