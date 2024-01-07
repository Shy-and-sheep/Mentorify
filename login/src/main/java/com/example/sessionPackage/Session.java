package com.example.sessionPackage;

import com.example.FormationPackage.Formation;
import com.example.LoginPackage.User;

import java.util.List;

public class Session {

    private int id;
    private int authorId;
    private String nom;
    private String description;
    private List<Formation> formations;
    private List<User> etudiants;
    private int nbPlacesMax;
    private String lieu;
    private double prix;
    private String date;
    private List<TypePaiement> typespaiement;

    public Session(int id, int authorId, String nom, String description, double prix, int nbPlacesMax, String lieu,
            String date) {
        this.id = id;
        this.authorId = authorId;
        this.nom = nom;
        this.description = description;
        this.nbPlacesMax = nbPlacesMax;
        this.lieu = lieu;
        this.prix = prix;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Formation> getFormations() {
        return formations;
    }

    public void setFormations(List<Formation> formations) {
        this.formations = formations;
    }

    public List<User> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(List<User> etudiants) {
        this.etudiants = etudiants;
    }

    public int getNbPlacesMax() {
        return nbPlacesMax;
    }

    public void setNbPlacesMax(int nbPlacesMax) {
        this.nbPlacesMax = nbPlacesMax;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<TypePaiement> getTypespaiement() {
        return typespaiement;
    }

    public void setTypespaiement(List<TypePaiement> typespaiement) {
        this.typespaiement = typespaiement;
    }
}
