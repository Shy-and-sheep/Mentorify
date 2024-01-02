package com.example.TPPackage;

import java.util.List;

public class TypePostFacade extends GenericCRUD {

    private static TypePostFacade instance;
    private TypePost TypePost;
    private List<TypePost> typesPosts;

    private TypePostFacade() {
    }

    public static TypePostFacade getInstance() {
        if (instance == null) {
            instance = new TypePostFacade();
        }
        return instance;
    }

    public List<TypePost> getAllTypePost() {
        AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        this.typesPosts = factory.getAllTypePostDAO();
        return typesPosts;
    }

    public TypePost setTypePost(int id, String nom, String description) {
        AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        this.TypePost = factory.setTypePostDAO(id, nom, description);
        return TypePost;
    }

    public TypePost getTypePost() {
        return this.TypePost;
    }

    public TypePost getTypePostById(int id) {
        AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        this.TypePost = factory.getTypePostByIdDAO(id);
        return TypePost;
    }

    public void removeTypePost(int id) {
        AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        factory.removeTypePostDAO(id);
    }

    public TypePost addTypePost(String nom, String description) {
        AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        this.TypePost = factory.addTypePostDAO(nom, description);
        return TypePost;
    }
}