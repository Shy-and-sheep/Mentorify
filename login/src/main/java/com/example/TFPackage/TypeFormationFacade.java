package com.example.TFPackage;

import java.util.List;

public class TypeFormationFacade extends GenericCRUD {

    private static TypeFormationFacade instance;
    private TypeFormation typeFormation;
    private List<TypeFormation> typesFormations;

    private TypeFormationFacade() { }

    public static TypeFormationFacade getInstance() {
        if (instance == null) {
            instance = new TypeFormationFacade();
        }
        return instance;
    }

    public List<TypeFormation> getAllTypeFormation() {
        AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        this.typesFormations = factory.getAllTypeFormationDAO();
        return typesFormations;
    }

    public TypeFormation setTypeFormation(int id, String nom, String description) {
        AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        this.typeFormation = factory.setTypeFormationDAO(id,nom,description);
        return typeFormation;
    }

    public TypeFormation getTypeFormation(){
        return this.typeFormation;
    }


    public TypeFormation getTypeFormationById(int id) {
        AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        this.typeFormation = factory.getTypeFormationByIdDAO(id);
        return typeFormation;
    }
    public void removeTypeFormation(int id) {
        AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        factory.removeTypeFormationDAO(id);
    }
    public TypeFormation addTypeFormation(String nom, String description) {
        AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        this.typeFormation = factory.addTypeFormationDAO(nom,description);
        return typeFormation;
    }

}