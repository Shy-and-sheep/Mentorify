package com.example.LoginPackage;

import java.util.*;

/**
 * 
 */
public class UserFacade {

    /**
     * Default constructor
     */
    public UserFacade() {
        this.factory = new DAOMySQLFactory();

    }

    /**
     * 
     */
    public AbstractDAOFactory factory;

    /**
     * 
     */
    public User user;

    /**
     * 
     */
    public void getFacade() {
        // TODO implement here
    }

    /**
     * @param username
     * @param mdp
     */
    public User login(String username, String mdp) {

        User user = this.factory.getUserDAO(username, mdp);
        System.out.println(user.username);
        return user;
    }

}