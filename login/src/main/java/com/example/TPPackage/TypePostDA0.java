package com.example.TPPackage;

import java.util.*;

/**
 * 
 */
public abstract class TypePostDA0 {

    /**
     * Default constructor
     */
    public TypePostDA0() {
    }

    /**
     * @param int id
     * @return
     */
    public abstract TypePost getTypePostById(int id);

    /**
     * @param int id
     * @return
     */
    public abstract void removeTypePost(int id);

    /**
     * @return
     */
    public abstract List<TypePost> getAllTypePost();

    /**
     * @param String nom
     * @param String description
     * @return
     */
    public abstract TypePost addTypePost(String nom, String description);

    /**
     * @param String nom
     * @param String description
     * @return
     */
    public abstract TypePost setTypePost(int id, String nom, String description);

}