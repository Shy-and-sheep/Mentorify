package com.example.ProfilPackage;

import java.util.*;

/**
 * 
 */
public abstract class AbstractDAOFactory {

    private static AbstractDAOFactory instance;

    protected AbstractDAOFactory() {}


    /**
     * @return
     */
    public static AbstractDAOFactory getInstance() {
        if (instance == null) {
            instance = new DAOMySQLFactory();
        }
        return instance;
    }

    /**
     * 
     */
    public abstract void UpdateInfosProfil();

    /**
     * 
     */
    public abstract void SeDeconnecter();

    /**
     * 
     */
    public abstract void AccederProfil();

    /**
     * 
     */
    public abstract void ListeFormation();

    /**
     * 
     */
    public abstract void ListeFormationCrées();

    /**
     * 
     */
    public abstract void CreerFormation();

}