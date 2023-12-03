package com.example.LoginPackage;

/**
 * 
 */
public abstract class UserDA0 extends UserFacade {

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
    public abstract User getUserByUsername(String email, String mdp);

}