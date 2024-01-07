package com.example.sessionPackage;

import com.example.FormationPackage.Formation;
import com.example.UserPackage.User;

import java.util.*;

public abstract class AbstractDAOFactory {

    AbstractDAOFactory() {
    }

    private static AbstractDAOFactory instance;

    public static AbstractDAOFactory getInstance() {
        if (instance == null) {
            instance = new DAOMySQLFactory();
        }
        return instance;
    }

    public abstract Session getSessionByIdDAO(int id);

    public abstract void removeSessionDAO(int id);

    public abstract List<Session> getAllSessionDAO();

    public abstract Session addSessionDAO(int authorId, String nom, String description, List<Formation> formations,
            double prix, List<TypePaiement> typespayment, int nbPlacesMax, String lieu, String date);

    public abstract Session setSessionDAO(int sessionId, int authorId, String nom, String description,
            List<Formation> formations, double prix, List<TypePaiement> typespayment, List<User> etudiants,
            int nbPlacesMax, String lieu, String date);

    public abstract void inscriptionSessionDAO(int etudiantId, int sessionId);

    public abstract void desinscriptionSessionDAO(int etudiantId, int sessionId);

}