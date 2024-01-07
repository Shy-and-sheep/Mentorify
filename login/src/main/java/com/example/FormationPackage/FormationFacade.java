package com.example.FormationPackage;


import java.util.*;
public class FormationFacade extends GenericCRUD {
    private static FormationFacade instance;
    private Formation formation;
    private List<Formation> formations;
    private FormationFacade() {}

    /**
     * Méthode pour récupérer l'instance
     */
    public static FormationFacade getInstance() {
        if (instance == null) {
            instance = new FormationFacade();
        }
        return instance;
    }

    public Formation getFormation(){
        return this.formation;
    }


    public List<Formation> getAllFormation() {
        AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        this.formations = factory.getAllFormationDAO();
        return formations;
    }

    public Formation setFormation(int formationId,String authorName,String nom,String description,double prix,String typespayment,int nbPlacesMax,int nbPlacesDispo,String typeFormation) {
        AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        this.formation = factory.setFormationDAO(formationId,authorName,nom,description,prix,typespayment,nbPlacesMax,nbPlacesDispo,typeFormation);
        return formation;
    }

    public Formation getFormationById(int id) {
        AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        this.formation = factory.getFormationByIdDAO(id);
        return formation;
    }

    public void removeFormation(int id) {
        AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        factory.removeFormationDAO(id);
    }

    public Formation addFormation(String authorName,String nom,String description, double prix,String typespayment, int nbPlacesMax, int nbPlacesDispo, String typeFormation) {
        AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        this.formation = factory.addFormationDAO(authorName,nom,description,prix,typespayment,nbPlacesMax,nbPlacesDispo,typeFormation);
        return formation;
    }

    public void inscriptionFormation(int userId, int idFormation) {
        AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        factory.inscriptionFormationDAO(userId, idFormation);
    }

    public void desinscriptionFormation(int userId, int idFormation) {
        AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        factory.desinscriptionFormationDAO(userId, idFormation);
    }

}