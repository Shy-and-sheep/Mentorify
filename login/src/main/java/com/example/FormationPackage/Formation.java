package com.example.FormationPackage;

import com.example.TFPackage.TypeFormation;

import java.util.*;
public class Formation {
    private int id;
    private String authorName;
    private String nom;
    private String description;
    private double prix;
    private String typesPayment;
    private int nbPlacesMax;
    private int nbPlacesDispo;
    private String typeFormation;

    public Formation(int id, String authorName, String nom, String description, double prix,
                     String typesPayment, int nbPlacesMax, int nbPlacesDispo, String typeFormation) {
        this.id = id;
        this.authorName = authorName;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.typesPayment = typesPayment;
        this.nbPlacesMax = nbPlacesMax;
        this.nbPlacesDispo = nbPlacesDispo;
        this.typeFormation = typeFormation;
    }
    // Getters
    public int getId() {
        return id;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public double getPrix() {
        return prix;
    }

    public String getTypesPayment() {
        return typesPayment;
    }

    public int getNbPlacesMax() {
        return nbPlacesMax;
    }

    public int getNbPlacesDispo() {
        return nbPlacesDispo;
    }

    public String getTypeFormation() {
        return typeFormation;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setTypesPayment(String typesPayment) {
        this.typesPayment = typesPayment;
    }

    public void setNbPlacesMax(int nbPlacesMax) {
        this.nbPlacesMax = nbPlacesMax;
    }

    public void setNbPlacesDispo(int nbPlacesDispo) {
        this.nbPlacesDispo = nbPlacesDispo;
    }

    public void setTypeFormation(String typeFormation) {
        this.typeFormation = typeFormation;
    }

}