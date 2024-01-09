package com.example.RolePackage;

import java.util.List;

import com.example.TPPackage.TypePost;

public abstract class AbstractDAOFactory {

    private static AbstractDAOFactory instance;

    public AbstractDAOFactory() {}

    public static AbstractDAOFactory getInstance() {
        if (instance == null) {
            instance = new DAOMySQLFactory();
        }
        return instance;
    }

    public abstract Role setRoleDAO(String libelle, String description, Permission[] permissions);
    
    public abstract void removeRoleDAO(int idR);
    
    public abstract Role getRoleByIdDAO(int idR);
    
    public abstract Permission setPermissionDAO(int idP, String libelle, String description);
    
    public abstract List<Permission> getAllPermissionDAO();
    
    public abstract void removePermissionDAO(int idP);

	public abstract Permission getPermissionByIdDAO(int idP);

}