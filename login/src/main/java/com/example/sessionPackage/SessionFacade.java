package com.example.sessionPackage;

import com.example.FormationPackage.Formation;
import com.example.TPaiementPackage.TypePaiement;
import com.example.UserPackage.User;


import java.util.*;

public class SessionFacade extends GenericCRUD {

    private SessionFacade() {
    }

    private static SessionFacade instance;

    private Session session;

    private List<Session> sessions;

    public static SessionFacade getInstance() {
        if (instance == null) {
            instance = new SessionFacade();
        }
        return instance;
    }

    /**
     * @return
     */
    public List<Session> getAllSession() {
        AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        this.sessions = factory.getAllSessionDAO();
        return this.sessions;
    }

    public Session setSession(int sessionId, int authorId, String nom, String description, List<Formation> formations,
                              List<User> etudiants, double prix, List<TypePaiement> typespayment, int nbPlacesMax, String lieu,
                              String date) {
        AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        this.session = factory.setSessionDAO(sessionId, authorId, nom, description, formations,prix, typespayment,  etudiants,
                nbPlacesMax, lieu, date);
        return this.session;
    }

    public Session getSessionById(int id) {
        AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        this.session = factory.getSessionByIdDAO(id);
        return this.session;
    }

    public void removeSession(int id) {
        AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        factory.removeSessionDAO(id);
    }

    public Session getSession() {
        return session;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public Session addSession(int authorId, String nom, String description, List<Formation> formations, double prix,
                              List<TypePaiement> typespayment, int nbPlacesMax, String lieu, String date) {
        AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        this.session = factory.addSessionDAO(authorId, nom, description, formations, prix, typespayment, nbPlacesMax,
                lieu, date);
        return this.session;
    }

    public void inscriptionSession(int etudiantId, int idSession) {
        AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        factory.inscriptionSessionDAO(etudiantId, idSession);
    }
    public void desinscriptionSession(int etudiantId, int idSession) {
        AbstractDAOFactory factory = AbstractDAOFactory.getInstance();
        factory.desinscriptionSessionDAO(etudiantId, idSession);
    }

}