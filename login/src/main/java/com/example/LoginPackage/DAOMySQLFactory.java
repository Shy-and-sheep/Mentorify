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
        // TO DO demander au prof si global ou local

        User user = this.userDAOMySQL.getUserByCredentials(username, mdp);
        System.out.println(user.username);
        return user;
    }

}