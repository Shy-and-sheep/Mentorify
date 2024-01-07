package com.example.CommentairePackage;
import java.security.Timestamp;
import java.util.*;

public abstract class CommentaireDA0{

    public CommentaireDA0() {}
    public abstract Commentaire getCommentaireById(int id);
    public abstract List<Commentaire> getAllCommentaire();
    public abstract void removeCommentaire(int id);
    public abstract Commentaire addCommentaire(Integer formationId, Integer postId, String authorName, String contenu, int note);
    public abstract Commentaire setCommentaire(int commentaireId,Integer formationId,Integer postId, String authorName,String contenu,int note);
    public abstract List<Commentaire> getCommentairesByFormationId(Integer formationId);

    public abstract List<Commentaire> getCommentairesByPostId(Integer postId);


}