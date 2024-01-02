package com.example.TFPackage;

import com.example.TFPackage.TypeFormation;

import java.util.*;

/**
 * 
 */
public abstract class TypeFormationDA0{

    /**
     * Default constructor
     */
    public TypeFormationDA0() {
    }

    /**
     * @param int id 
     * @return
     */
    public abstract TypeFormation getTypeFormationById(int id);

    /**
     * @param int id 
     * @return
     */
    public abstract void removeTypeFormation(int id);

    /**
     * @return
     */
    public abstract List<TypeFormation> getAllTypeFormation();

    /**
     * @param String nom 
     * @param String description 
     * @return
     */
    public abstract TypeFormation addTypeFormation(String nom, String description);

    /**
     * @param String nom 
     * @param String description 
     * @return
     */
    public abstract TypeFormation setTypeFormation(int id, String nom, String description);

}