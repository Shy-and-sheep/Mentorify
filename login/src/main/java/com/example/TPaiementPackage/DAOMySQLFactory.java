package com.example.TPaiementPackage;

import com.example.TPPackage.TypePostDAOMySQL;
import com.example.TPaiementPackage.AbstractDAOFactory;

import java.util.*;

/**
 * 
 */
public class DAOMySQLFactory extends AbstractDAOFactory {

    /**
     * Default constructor
     */
    public DAOMySQLFactory() {
        super();
        this.typePaiementDAOMySQL = new TypePaiementDAOMySQL();
    }

    /**
     * 
     */
    private TypePaiementDAOMySQL typePaiementDAOMySQL;

    /**
     *
     */
    public TypePaiement getTypePaiementByIdDAO( int id) {
        return this.typePaiementDAOMySQL.getTypePaiementByIdDAO(id);
    }

    /**
     * @return
     */
    public List<TypePaiement> getAllTypePaiementDAO() {
        return this.typePaiementDAOMySQL.getAllTypePaiement();
    }

    /**
     *
     */
    public TypePaiement setTypePaiementDAO( int id, String nom, String description) {
        return this.typePaiementDAOMySQL.setTypePaiementDAO(id, nom, description);
    }

    /**
     *
     */
    public TypePaiement addTypePaiementDAO(String nom, String description) {
        return this.typePaiementDAOMySQL.addTypePaiementDAO(nom, description);
    }

    /**
     *
     */
    public void removeTypePaiementDAO(int id) {
        this.typePaiementDAOMySQL.removeTypePaiementDAO(id);
    }

}