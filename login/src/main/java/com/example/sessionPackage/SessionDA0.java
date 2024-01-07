package com.example.sessionPackage;

import com.example.FormationPackage.Formation;
import com.example.TPaiementPackage.TypePaiement;
import com.example.UserPackage.User;

import java.util.*;

/**
 * 
 */
public abstract class SessionDA0 {

    /**
     * Default constructor
     */
    public SessionDA0() {
    }

    public abstract Session getSessionById(int id);

    public abstract void removeSession(int id);

    public abstract List<Session> getAllSession();

    public abstract Session addSession(int authorId, String nom, String description, List<Formation> formations,
                                       double prix, List<TypePaiement> typespayment, int nbPlacesMax, String lieu, String date);

    public abstract Session setSession(int sessionId, int authorId, String nom, String description,
                                       List<Formation> formations, List<User> etudiants, double prix, List<TypePaiement> typespayment,
                                       int nbPlacesMax, String lieu, String date);

    public abstract void inscriptionSession(int etudiantId, int sessionId);

    public abstract void desinscriptionSession(int etudiantId, int sessionId);

}