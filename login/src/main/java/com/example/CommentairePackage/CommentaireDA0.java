package com.example.CommentairePackage;
import java.security.Timestamp;
import java.util.*;

public abstract class CommentaireDA0{

    public CommentaireDA0() {}
    public abstract Commentaire getCommentaireById(int id);
    public abstract List<Commentaire> getAllCommentaire();
    public abstract void removeCommentaire(int id);
    public abstract Commentaire addCommentaire(int formationId, String authorName, String contenu, int note);
    public abstract Commentaire setCommentaire(int commentaireId,int formationId,String authorName,String contenu,int note);
    public abstract List<Commentaire> getCommentairesByFormationId(int formationId);

}