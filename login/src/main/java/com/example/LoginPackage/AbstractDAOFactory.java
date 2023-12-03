package com.example.LoginPackage;

import java.util.*;

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
    public User getUserDAO(String username, String mdp) {
        UserDAOMySQL userDAOMySQL = new UserDAOMySQL();
        User user = userDAOMySQL.getUserByUsername(username, mdp);
        System.out.println(user.username);
        return user;
    }

    /**
     * 
     */
    public void getFactory() {
        // TODO implement here
    }

    /**
     * 
     */
    public void creerUserDAO() {
        // TODO implement here
    }

}