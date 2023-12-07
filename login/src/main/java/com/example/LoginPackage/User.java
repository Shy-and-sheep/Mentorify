package com.example.LoginPackage;

import java.util.*;

/**
 * 
 */
public class User {

    /**
     * Default constructor
     */
    public User( int id, String mdp, String username ) {
        this.id = id;
        this.username = username;
        this.mdp = mdp;
    }

    /**
     * 
     */
    public  int id;

    /**
     *
     */
    public  String username;

    /**
     * 
     */
    public  String mdp;


    /**
     * 
     */
    public int getId() {
        // TODO implement here
        return this.id;
    }

    /**
     * @return 
     * 
     */
    public String getName() {
        // TODO implement here
    	return this.username; 
    }

    /**
     * 
     */
    public void setName() {
        // TODO implement here
    }

}