package com.example.LoginPackage;

/**
 * 
 */
public class DAOMySQLFactory extends AbstractDAOFactory {
    UserDAOMySQL userDAOMySQL;

    /**
     * Default constructor
     */
    public DAOMySQLFactory() {
        super();
        this.userDAOMySQL = new UserDAOMySQL();
    }

    /**
     * 
     */
    public User getUserDAO(String username, String mdp) {
        return this.userDAOMySQL.getUserByCredentials(username, mdp);
    }

}