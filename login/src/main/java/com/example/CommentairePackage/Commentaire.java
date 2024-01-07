package com.example.CommentairePackage;

public class Commentaire {
    private int id;
    private Integer formationId;

    private Integer postId;
    private String authorName;
    private String contenu;
    private int note;


    public int getPostId() {
        return postId;
    }

    public Commentaire(int id, Integer formationId, Integer postId, String authorName, String contenu, int note) {
        this.id = id;
        this.formationId = formationId;
        this.authorName = authorName;
        this.contenu = contenu;
        this.note = note;
        this.postId = postId;
    }

    public int getId() {
        return this.id;
    }
    public int getFormationId(){return this.formationId;}
    public String getAuthorName(){return this.authorName;}
    public String getContenu(){return this.contenu;}
    public int getNote(){return this.note;}
    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
    public void setNote(int note) {
        this.note = note;
    }
}