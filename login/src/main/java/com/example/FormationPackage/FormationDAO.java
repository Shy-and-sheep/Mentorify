package com.example.FormationPackage;

import java.util.*;

public abstract class FormationDAO {

    /**
     * Default constructor
     */
    public FormationDAO() {}

    public abstract Formation getFormationById(int id);

    public abstract void removeFormation(int id);

    public abstract List<Formation> getAllFormation();

    public abstract Formation addFormation(String authorName,String nom,String description, double prix,String typespayment, int nbPlacesMax, int nbPlacesDispo, String typeFormation);

    public abstract Formation setFormation(int formationId,String authorName,String nom,String description,double prix,String typespayment,int nbPlacesMax,int nbPlacesDispo,String typeFormation);

    public abstract void inscriptionFormation(int userId, int idFormation);

    public abstract void desinscriptionFormation(int userId,int idFormation);

    public abstract List<Formation> getFormationByTF(String TF);
}