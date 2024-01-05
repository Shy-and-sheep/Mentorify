package com.example.CommentairePackage;

import java.security.Timestamp;
import java.util.*;
import java.sql.*;

public class Commentaire {
    private int id;
    private int formationId;
    private String authorName;
    private String contenu;
    private int note;


    public Commentaire(int id, int formationId, String authorName, String contenu, int note) {
        this.id = id;
        this.formationId = formationId;
        this.authorName = authorName;
        this.contenu = contenu;
        this.note = note;
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