package com.example.RolePackage;

import java.util.List;

public class PermissionFacade {

    public PermissionFacade() {
    }

    private static PermissionFacade instance;

    private Permission permission;
    
    private List<Permission> permissions;

    public static PermissionFacade getInstance() {
    	if (instance == null) {
            instance = new PermissionFacade();
        }
        return instance;
    }

    public Permission setPermission(int idP,String libelle, String description) {
    	AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        this.permission = factory.setPermissionDAO(idP, libelle, description);
        return this.permission;
    }
    
    public List<Permission> getAllPermission() {
        AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        this.permissions = factory.getAllPermissionDAO();
        return permissions;
    }

    public void removePermission(int idP) {
    	AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        factory.removePermissionDAO(idP);
    }

	public Permission getPermissionById(int idP) {
		AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        this.permission = factory.getPermissionByIdDAO(idP);
        return permission;		
	}

}