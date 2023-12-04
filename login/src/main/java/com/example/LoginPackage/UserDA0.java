package com.example.LoginPackage;

/**
 * 
 */
public abstract class UserDA0{

    /**
     * Default constructor
     */
    public UserDA0() {
    }

    /**
     * @param email
     * @param mdp
     * @return
     */
    public abstract User getUserByCredentials(String email, String mdp);

}