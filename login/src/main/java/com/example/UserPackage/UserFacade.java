package com.example.UserPackage;

public class UserFacade {
    private static UserFacade instance;
    private User user;

    private UserFacade() { }

    public static UserFacade getInstance() {
        if (instance == null) {
            instance = new UserFacade();
        }
        return instance;
    }

    public User getUser() {
        return this.user;
    }


    public User login(String username, String mdp) {
        AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        this.user = factory.getUserDAO(username, mdp);
        return user;
    }

    public User Register(String name, String first_name, String username, String mdp, String email, String statut) {
        // Vérifier si l'utilisateur existe déjà
        /*
        AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        UserDAOMySQL userDAOMySQL = (UserDAOMySQL) factory.getUserDAO();
        if (userDAOMySQL.userExists(username, email)) {
            // Lever une exception ou retourner null
            return null;
        }
        */

        // Créer un nouvel utilisateur
        AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        User newUser = factory.CreateUser(name, first_name, username, mdp, email, statut);

        return newUser;
    }
}