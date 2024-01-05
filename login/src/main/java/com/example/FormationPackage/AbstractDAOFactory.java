package com.example.FormationPackage;

import com.example.CommentairePackage.Commentaire;

import java.util.*;

/**
 * Singleton class for AbstractDAOFactory
 */
public abstract class AbstractDAOFactory {

    /**
     * Private constructor to prevent instantiation outside of this class
     */
    private static AbstractDAOFactory instance;

    protected AbstractDAOFactory() {}


    /**
     * Method to get the singleton instance of AbstractDAOFactory
     */
    public static AbstractDAOFactory getInstance() {
        if (instance == null) {
            instance = new DAOMySQLFactory();
        }
        return instance;
    }

    public abstract Formation getFormationByIdDAO(int id);

    public void removeFormationDAO(int id) {}

    public abstract List<Formation> getAllFormationDAO();

    public abstract Formation addFormationDAO(String authorName,String nom,String description, double prix,String typespayment, int nbPlacesMax, int nbPlacesDispo, String typeFormation);

    public abstract Formation setFormationDAO(int formationId,String authorName,String nom,String description,double prix,String typespayment,int nbPlacesMax,int nbPlacesDispo,String typeFormation);

    public abstract void inscriptionFormationDAO(int userId,int idFormation);

    public abstract void desinscriptionFormationDAO(int userId,int idFormation);


}