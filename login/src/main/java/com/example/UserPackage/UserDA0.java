package com.example.UserPackage;

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
     * @return User
     */
    public abstract User getUserByCredentials(String email, String mdp);

    public abstract User CreateUser(String name, String first_name, String username, String mdp, String email, String statut);
}