package com.example.CommentairePackage;

import com.example.CommentairePackage.Commentaire;

import java.util.List;

public class DAOMySQLFactory extends AbstractDAOFactory {

    CommentaireDAOMySQL CommentaireDAOMySQL;
    public DAOMySQLFactory() {
        super();
        this.CommentaireDAOMySQL = new CommentaireDAOMySQL();
    }
    @Override
    public Commentaire getCommentaireByIdDAO(int id) {
        return this.CommentaireDAOMySQL.getCommentaireById(id);
    }
    @Override
    public List<Commentaire> getAllCommentaireDAO() {
        return this.CommentaireDAOMySQL.getAllCommentaire();
    }
    @Override
    public void removeCommentaireDAO(int id) {
        this.CommentaireDAOMySQL.removeCommentaire(id);
    }
    @Override
    public Commentaire setCommentaireDAO(int commentaireId,Integer formationId, Integer postId, String authorName,String contenu,int note) {
        return this.CommentaireDAOMySQL.setCommentaire(commentaireId,formationId,postId , authorName,contenu,note);
    }
    @Override
    public Commentaire addCommentaireDAO(Integer formationId, Integer postId, String authorName,String contenu,int note) {
        return this.CommentaireDAOMySQL.addCommentaire(formationId,postId, authorName,contenu,note);
    }
    @Override
    public List<Commentaire> getCommentairesByFormationIdDAO(Integer formationId){
        return this.CommentaireDAOMySQL.getCommentairesByFormationId(formationId);
    }

    @Override
    public List<Commentaire> getCommentairesByPostIdDAO(Integer postId) {
        return this.CommentaireDAOMySQL.getCommentairesByPostId(postId);
    }

}