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
    public Commentaire setCommentaireDAO(int commentaireId,int formationId,String authorName,String contenu,int note) {
        return this.CommentaireDAOMySQL.setCommentaire(commentaireId,formationId,authorName,contenu,note);
    }
    @Override
    public Commentaire addCommentaireDAO(int formationId,String authorName,String contenu,int note) {
        return this.CommentaireDAOMySQL.addCommentaire(formationId,authorName,contenu,note);
    }
    @Override
    public List<Commentaire> getCommentairesByFormationIdDAO(int formationId){
        return this.CommentaireDAOMySQL.getCommentairesByFormationId(formationId);
    }

}