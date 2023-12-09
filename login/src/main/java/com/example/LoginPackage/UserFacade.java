package com.example.LoginPackage;

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
}