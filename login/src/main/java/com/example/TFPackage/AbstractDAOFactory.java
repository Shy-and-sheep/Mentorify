package com.example.TFPackage;

import com.example.TFPackage.DAOMySQLFactory;

import java.util.*;

/**
 * Singleton class for AbstractDAOFactory
 */
public abstract class AbstractDAOFactory {

    /**
     * Private constructor to prevent instantiation outside of this class
     */
    private static AbstractDAOFactory instance;

    protected AbstractDAOFactory() {
    }

    /**
     * Method to get the singleton instance of AbstractDAOFactory
     */
    public static AbstractDAOFactory getInstance() {
        if (instance == null) {
            instance = new DAOMySQLFactory();
        }
        return instance;
    }

    /**
     * @param int id 
     * @return
     */
    public abstract TypeFormation getTypeFormationByIdDAO(int id);

    /**
     * @param int id 
     * @return
     */
    public void removeTypeFormationDAO(int id) {
    }

    /**
     * Method to get TypeFormationDAO instance
     */
    public abstract List<TypeFormation> getAllTypeFormationDAO();

    /**
     * @param String nom 
     * @param String description 
     * @return TypeFormation
     */
    public abstract TypeFormation addTypeFormationDAO(String nom,String description);

    /**
     * @param String nom 
     * @param String description 
     * @return
     */
    public abstract TypeFormation setTypeFormationDAO(int id,String nom, String description);

}