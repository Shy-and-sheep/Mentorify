package com.example.LoginPackage;

public class UserFacade {
    private static UserFacade instance;
    private AbstractDAOFactory factory;
    private User user;

    private UserFacade() {
        this.factory = AbstractDAOFactory.getInstance();
    }

    public static UserFacade getInstance() {
        if (instance == null) {
            instance = new UserFacade();
        }
        return instance;
    }

    public void handleUser ( User user) {
        if (user != null ) {
            this.user = user;
        }
    }

    public User login(String username, String mdp) {
        User user = this.factory.getUserDAO(username, mdp);
        this.handleUser(user);
        return user;
    }
}