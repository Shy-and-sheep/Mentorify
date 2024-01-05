package com.example.CommentairePackage;


import com.example.FormationPackage.Formation;

import java.security.Timestamp;
import java.util.List;

/**
 * 
 */
public class CommentaireFacade extends GenericCRUD {
    private static CommentaireFacade instance;

    private Commentaire commentaire;
    private List<Commentaire> commentaires;

    private CommentaireFacade() {}
    /**
     * Méthode pour récupérer l'instance
     */
    public static CommentaireFacade getInstance() {
        if (instance == null) {
            instance = new CommentaireFacade();
        }
        return instance;
    }
    public Commentaire getCommentaire() {return this.commentaire;}

    public Commentaire getCommentaireById(int id) {
        AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        this.commentaire = factory.getCommentaireByIdDAO(id);
        return commentaire;
    }

    public List<Commentaire> getAllCommentaire() {
        AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        this.commentaires = factory.getAllCommentaireDAO();
        return commentaires;
    }

    public Commentaire addCommentaire(int formationId, String authorName, String contenu, int note) {
        AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        this.commentaire = factory.addCommentaireDAO(formationId,authorName,contenu,note);
        return commentaire;
    }
    public void removeCommentaire(int id) {
        AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        factory.removeCommentaireDAO(id);
    }
    public Commentaire setCommentaire(int commentaireId,int formationId,String authorName,String contenu,int note) {
        AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        this.commentaire = factory.setCommentaireDAO(commentaireId,formationId,authorName,contenu,note);
        return commentaire;
    }

    public List<Commentaire> getCommentairesByFormationId(int formationId){
        AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        this.commentaires = factory.getCommentairesByFormationIdDAO(formationId);
        return commentaires;
    }

}