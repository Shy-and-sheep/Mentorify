package com.example.RolePackage;

import java.util.*;

public class RoleFacade extends GenericCRUD {

    public RoleFacade() {
    }

    private static RoleFacade instance;

    private Role role;

    public static RoleFacade getInstance() {
    	if (instance == null) {
            instance = new RoleFacade();
        }
        return instance;
    }


    public Role setRole(String libelle, String description, Permission[] permissions) {
    	AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        this.role = factory.setRoleDAO(libelle, description, permissions);
        return this.role;
    }

    public void removeRole(int idR) {
    	AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        factory.removeRoleDAO(idR);    
        }

    public Role getRoleById(int idR) {
    	AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        this.role = factory.getRoleByIdDAO(idR);
        return this.role;
    }

}