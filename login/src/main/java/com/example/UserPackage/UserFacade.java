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

    public User Register(String last_name, String first_name, String username, String mdp, String email, String status) {
        // Vérifier si l'utilisateur existe déjà
        /*
        AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        UserDAOMySQL userDAOMySQL = (UserDAOMySQL) factory.getUserDAO();
        if (userDAOMySQL.userExists(username, email)) {
            // Lever une exception ou retourner null
            return null;
        }
        */

        if (username.isEmpty()){
            System.out.println("Username vide");
            return null;
        }
        if (mdp.length()< 8) {
            System.out.println("Password vide ou ses caractères sont inférieurs à 8");
            return null;
        }

        // Créer un nouvel utilisateur
        AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        User newUser = factory.CreateUser(last_name, first_name, username, mdp, email, status);

        return newUser;

    }
}