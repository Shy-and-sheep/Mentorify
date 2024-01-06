package com.example.TPaiementPackage;

import com.example.TPaiementPackage.AbstractDAOFactory;
import com.example.TPaiementPackage.GenericCRUD;

import java.util.*;

/**
 * 
 */
public class TypePaiementFacade extends GenericCRUD {

    private TypePaiement typePaiement ;

    private List<TypePaiement> typePaiements ;
    /**
     * Default constructor
     */
    public TypePaiementFacade() {
    }

    private static TypePaiementFacade instance;

    /**
     * @return
     */
    public static TypePaiementFacade getInstance() {
        if (instance == null) {
            instance = new TypePaiementFacade();
        }
        return instance;
    }

    /**
     * @return
     */
    public List<TypePaiement> getAllTypePaiement() {
        AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        this.typePaiements = factory.getAllTypePaiementDAO();
        return typePaiements;
    }


    public TypePaiement setTypePaiement(int id, String nom,  String description) {
        AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        this.typePaiement = factory.setTypePaiementDAO(id, nom, description);
        return typePaiement;
    }


    public TypePaiement getTypePaiementById( int id) {
        AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        this.typePaiement = factory.getTypePaiementByIdDAO(id);
        return typePaiement;
    }


    public TypePaiement addTypePaiement( String nom,  String description) {
        AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        this.typePaiement = factory.addTypePaiementDAO(nom, description);
        return typePaiement;
    }

    public void removeTypePaiement( int id) {
        AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        factory.removeTypePaiementDAO(id);
    }

}