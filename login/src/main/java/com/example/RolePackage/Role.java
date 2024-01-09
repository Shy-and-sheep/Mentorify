package com.example.RolePackage;

import java.util.*;

/**
 * 
 */
public class Role {
	
	public void Role() {}

    public Role(String libelle, String description, Permission[] permissions) {
    	this.libelle = libelle;
    	this.description = description;
    	this.permissions = permissions;
    }

    private int idR;

    private String libelle;

    private String description;

    private Permission[ ] permissions;


    public int getIdR() {
        return this.idR;
    }

    public String getLibelle() {
        return this.libelle;
    }

    private void setLibelle(String libelle) {
        this.libelle = libelle;
        }

    public String getDescription() {
        return this.description;
    }

    private void setDescription(String description) {
    	this.description = description;
    }


    public Permission[] getPermissions() {
        return this.permissions;
    }

    private void setPermissions(Permission [ ] permissions) {
        this.permissions = permissions;
        }

}