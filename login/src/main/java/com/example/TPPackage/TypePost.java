package com.example.TPPackage;

public class TypePost {

    private int id;
    private String nom;
    private String description;

    public TypePost(int id, String nom, String description) {
        this.id = id;
        this.nom = nom;
        this.description = description;
    }

    public int getId() {
        return this.id;
    }

    /**
     * @return
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * @return
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * @param String nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @param String Description
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
