package com.example.TPaiementPackage;

import java.util.List;

/**
 * 
 */
public abstract class AbstractDAOFactory {

    /**
     * Default constructor
     */
    public AbstractDAOFactory() {
    }

    /**
     * 
     */
    private static AbstractDAOFactory instance;

    /**
     * @return
     */
    public static AbstractDAOFactory getInstance() {
        if (instance == null) {
            instance = new DAOMySQLFactory();
        }
        return instance;
    }

    /**
     *
     */
    public abstract TypePaiement getTypePaiementByIdDAO(int id);

    /**
     * @return
     */
    public abstract List<TypePaiement> getAllTypePaiementDAO();

    /**
     *
     */
    public abstract TypePaiement setTypePaiementDAO(int id, String nom,  String description);

    /**
     *
     */
    public abstract TypePaiement addTypePaiementDAO( String nom, String description);

    /**
     *
     */
    public abstract void removeTypePaiementDAO( int id) ;

}