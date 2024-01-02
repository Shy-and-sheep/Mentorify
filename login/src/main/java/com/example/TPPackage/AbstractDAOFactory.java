package com.example.TPPackage;

import java.util.*;

public abstract class AbstractDAOFactory {

    private static AbstractDAOFactory instance;

    public AbstractDAOFactory() {
        // Default constructor
    }

    public static AbstractDAOFactory getInstance() {
        if (instance == null) {
            instance = new DAOMySQLFactory();
        }
        return instance;
    }

    public abstract TypePost getTypePostByIdDAO(int id);

    public abstract void removeTypePostDAO(int id);

    public abstract List<TypePost> getAllTypePostDAO();

    public abstract TypePost addTypePostDAO(String nom, String description);

    public abstract TypePost setTypePostDAO(int id, String nom, String description);
}
