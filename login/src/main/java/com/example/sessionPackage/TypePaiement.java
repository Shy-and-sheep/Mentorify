package com.example.sessionPackage;

public class TypePaiement {
    public String nom;
    public int id;
    public String description;

    public String getNom() {
        return nom;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public TypePaiement (int id, String nom) {
        this.id = id;
        this.nom = nom;
    }
}
