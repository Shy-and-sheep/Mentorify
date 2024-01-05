package com.example.CommentairePackage;


import java.security.Timestamp;
import java.util.List;

public abstract class AbstractDAOFactory {

    /**
     * Default constructor
     */
    protected AbstractDAOFactory() {}

    /**
     * Private constructor to prevent instantiation outside of this class
     */
    private static AbstractDAOFactory instance;

    /**
     * Method to get the singleton instance of AbstractDAOFactory
     */
    public static AbstractDAOFactory getInstance() {
        if (instance == null) {
            instance = new DAOMySQLFactory();
        }
        return instance;
    }

    public abstract Commentaire getCommentaireByIdDAO(int id);
    public abstract List<Commentaire> getAllCommentaireDAO();
    public void removeCommentaireDAO(int id) {}
    public abstract Commentaire setCommentaireDAO(int commentaireId, int formationId, String authorName, String contenu, int note);
    public abstract Commentaire addCommentaireDAO(int formationId,String authorName,String contenu,int note);
    public abstract List<Commentaire> getCommentairesByFormationIdDAO(int formationId);
}