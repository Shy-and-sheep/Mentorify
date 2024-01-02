package com.example.TFPackage;

import java.util.*;

/**
 * 
 */
public class TypeFormation {

    /**
     * Default constructor
     */
    public TypeFormation(int id, String nom, String description) {
        this.id = id;
        this.nom = nom;
        this.description = description;
    }

    /**
     * 
     */
    private int id;

    /**
     * 
     */
    private String nom;

    /**
     * 
     */
    private String description;

    /**
     * @return
     */
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