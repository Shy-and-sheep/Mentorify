package com.example.TPaiementPackage;

import java.util.List;

/**
 * 
 */
public abstract class TypePaiementDAO {

    /**
     * Default constructor
     */
    public TypePaiementDAO() {
    }

    /**
     *
     *
     */
    public abstract TypePaiement getTypePaiementByIdDAO(int id);

    /**
     *
     */
    public abstract List<TypePaiement> getAllTypePaiement();

    /**
     *
     *
     */
    public abstract TypePaiement setTypePaiementDAO(int id, String nom, String description);

    /**
     *
     *
     *
     */
    public abstract TypePaiement addTypePaiementDAO(String nom, String description);

    /**
     *
     */
    public abstract void removeTypePaiementDAO(int id);

}