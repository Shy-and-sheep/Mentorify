package com.example.RolePackage;

public class Permission {

    public Permission() {
    }

    private int idP;

    private String libelle;

    private String description;

    public int getIdP() {
        return this.idP;
    }

    public Permission(int idP,String libelle, String description) {
    	this.idP = idP;
    	this.libelle = libelle;
    	this.description = libelle;
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

}