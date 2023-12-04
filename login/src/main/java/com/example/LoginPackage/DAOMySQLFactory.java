package com.example.LoginPackage;

/**
 * 
 */
public class DAOMySQLFactory extends AbstractDAOFactory {

    /**
     * Default constructor
     */
    public DAOMySQLFactory() {
        super();
    }

    /**
     * 
     */
    public User getUserDAO(String username, String mdp) {
        // TO DO demander au prof si global ou local
        UserDAOMySQL userDAOMySQL = new UserDAOMySQL();
        User user = userDAOMySQL.getUserByCredentials(username, mdp);
        System.out.println(user.username);
        return user;
    }

}