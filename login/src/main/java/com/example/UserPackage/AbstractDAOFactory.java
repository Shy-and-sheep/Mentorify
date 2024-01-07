package com.example.UserPackage;

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

    public abstract User CreateUser(String name, String first_name, String username, String mdp, String email, String status);

}
