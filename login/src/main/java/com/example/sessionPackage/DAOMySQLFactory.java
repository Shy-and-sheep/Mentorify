package com.example.sessionPackage;

import com.example.FormationPackage.Formation;
import com.example.TPaiementPackage.TypePaiement;
import com.example.UserPackage.User;

import java.util.*;

/**
 * 
 */
public class DAOMySQLFactory extends AbstractDAOFactory {

    public DAOMySQLFactory() {
        super();
        this.sessionDAOMySQL = new SessionDAOMySQL();
    }

    public SessionDAOMySQL sessionDAOMySQL;

    public Session getSessionByIdDAO(int id) {
        return this.sessionDAOMySQL.getSessionById(id);
    }

    public void removeSessionDAO(int id) {
        this.sessionDAOMySQL.removeSession(id);
    };

    public List<Session> getAllSessionDAO() {
        return this.sessionDAOMySQL.getAllSession();
    }

    public Session addSessionDAO(int authorId, String nom, String description, List<Formation> formations, double prix,
                                 List<TypePaiement> typespayment, int nbPlacesMax, String lieu, String date) {
        return this.sessionDAOMySQL.addSession(authorId, nom, description, formations, prix, typespayment, nbPlacesMax,
                lieu, date);
    };

    public Session setSessionDAO(int sessionId, int authorId, String nom, String description,
                                 List<Formation> formations, double prix, List<TypePaiement> typespayment, List<User> etudiants,
                                 int nbPlacesMax, String lieu, String date) {
        return this.sessionDAOMySQL.setSession(sessionId, authorId, nom, description, formations, etudiants, prix, typespayment,
                nbPlacesMax, lieu, date);

    }

    public void inscriptionSessionDAO(int etudiantId, int sessionId) {
        this.sessionDAOMySQL.inscriptionSession(etudiantId, sessionId);
    }

    public void desinscriptionSessionDAO(int etudiantId, int sessionId) {
        this.sessionDAOMySQL.desinscriptionSession(etudiantId, sessionId);
    }
}