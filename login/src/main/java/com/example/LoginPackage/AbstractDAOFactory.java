package com.example.LoginPackage;

import java.util.*;

/**
 * Singleton class for AbstractDAOFactory
 */
public abstract class AbstractDAOFactory {

    private static AbstractDAOFactory instance;

    /**
     * Private constructor to prevent instantiation outside of this class
     */
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
     * Method to get UserDAO instance
     */
    public abstract User getUserDAO(String username, String mdp);

    /**
     * Method to get the factory
     */
    public void getFactory() {
        // TODO implement here
    }

    /**
     * Method to create UserDAO
     */
    public void creerUserDAO() {
        // TODO implement here
    }
}
