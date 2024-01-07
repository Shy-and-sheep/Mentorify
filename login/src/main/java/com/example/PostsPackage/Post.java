package com.example.PostsPackage;

public class Post {
    private int id;
    private int typePostId;
    private int sessionId;
    private int auteurId;
    private String contenu;
    private int nbLike = 0;

    public Post(int id, int typePostId, int sessionId, int auteurId, String contenu, int nbLike) {
        this.id = id;
        this.typePostId = typePostId;
        this.sessionId = sessionId;
        this.auteurId = auteurId;
        this.contenu = contenu;
        this.nbLike = nbLike;
    }
    
    // Getter pour l'ID
    public int getId() {
        return id;
    }

    // Setter pour l'ID
    public void setId(int id) {
        this.id = id;
    }

    // Getter pour l'ID du type de post
    public int getTypePostId() {
        return typePostId;
    }

    // Setter pour l'ID du type de post
    public void setTypePostId(int typePostId) {
        this.typePostId = typePostId;
    }

    // Getter pour l'ID de session
    public int getSessionId() {
        return sessionId;
    }

    // Setter pour l'ID de session
    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    // Getter pour l'ID de l'auteur
    public int getAuteurId() {
        return auteurId;
    }

    // Setter pour l'ID de l'auteur
    public void setAuteurId(int auteurId) {
        this.auteurId = auteurId;
    }

    // Getter pour le contenu
    public String getContenu() {
        return contenu;
    }

    // Setter pour le contenu
    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    // Getter pour le nombre de likes
    public int getNbLike() {
        return nbLike;
    }

    // Setter pour le nombre de likes
    public void setNbLike(int nbLike) {
        this.nbLike = nbLike;
    }
}
