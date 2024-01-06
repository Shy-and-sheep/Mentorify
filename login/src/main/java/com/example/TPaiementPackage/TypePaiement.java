package com.example.TPaiementPackage;

import java.util.*;

/**
 * 
 */
public class TypePaiement {

    /**
     * Default constructor
     */
    public TypePaiement(int id, String nom, String description) {
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
     *
     */
    public String getDescription() {
        return this.description;
    }

    /**
     *
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     */
    public void setDescription(String description) {
        this.description = description;
    }

}