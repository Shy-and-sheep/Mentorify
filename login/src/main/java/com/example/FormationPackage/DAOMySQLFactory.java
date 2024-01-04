package com.example.FormationPackage;

import com.example.TFPackage.TypeFormation;

import java.util.List;
public class DAOMySQLFactory extends AbstractDAOFactory {

    FormationDAOMySQL FormationDAOMySQL;

    /**
     * Default constructor
     */
    public DAOMySQLFactory() {
        super();
        this.FormationDAOMySQL = new FormationDAOMySQL();
    }

    @Override
    public Formation getFormationByIdDAO(int id) {
        return this.FormationDAOMySQL.getFormationById(id);
    }

    @Override
    public List<Formation> getAllFormationDAO() {
        return this.FormationDAOMySQL.getAllFormation();
    }

    @Override
    public Formation addFormationDAO(String authorName,String nom,String description,double prix,String typespayment, int nbPlacesMax, int nbPlacesDispo, String typeFormation) {
        return this.FormationDAOMySQL.addFormation(authorName,nom,description,prix,typespayment,nbPlacesMax,nbPlacesDispo,typeFormation);
    }

    @Override
    public Formation setFormationDAO(int formationId,String authorName,String nom,String description,double prix,String typespayment,int nbPlacesMax,int nbPlacesDispo,String typeFormation) {
        return this.FormationDAOMySQL.setFormation(formationId,authorName,nom,description,prix,typespayment,nbPlacesMax,nbPlacesDispo,typeFormation);
    }
    @Override
    public void removeFormationDAO(int id) {
        this.FormationDAOMySQL.removeFormation(id);
    }
    @Override
    public void inscriptionFormationDAO(int userId,int idFormation){
        this.FormationDAOMySQL.inscriptionFormation(userId,idFormation);
    }

    @Override
    public void desinscriptionFormationDAO(int userId,int idFormation){
        this.FormationDAOMySQL.desinscriptionFormation(userId,idFormation);
    }

}