package com.example.UserPackage;

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

    public User CreateUser( String name, String first_name, String username, String mdp, String email,  String statut) {
        // TODO implement here
        return null;
    }

}