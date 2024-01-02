package com.example.TPPackage;

import java.util.List;

/**
 *
 */
public class DAOMySQLFactory extends AbstractDAOFactory {
    TypePostDAOMySQL TypePostDAOMySQL;

    /**
     * Default constructor
     */
    public DAOMySQLFactory() {
        super();
        this.TypePostDAOMySQL = new TypePostDAOMySQL();
    }

    @Override
    public TypePost getTypePostByIdDAO(int id) {
        return this.TypePostDAOMySQL.getTypePostById(id);
    }

    @Override
    public List<TypePost> getAllTypePostDAO() {
        return this.TypePostDAOMySQL.getAllTypePost();
    }

    @Override
    public TypePost addTypePostDAO(String nom, String description) {
        return this.TypePostDAOMySQL.addTypePost(nom, description);
    }

    @Override
    public TypePost setTypePostDAO(int id, String nom, String description) {
        return this.TypePostDAOMySQL.setTypePost(id, nom, description);
    }

    @Override
    public void removeTypePostDAO(int id) {
        System.out.println("ceci est l'id de DAOMYSQLFactory" + id);
        this.TypePostDAOMySQL.removeTypePost(id);
    }

}