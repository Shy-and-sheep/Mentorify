import com.example.FormationPackage.FormationFacade;
import com.example.UserPackage.UserFacade;
import com.example.sessionPackage.Session;
import com.example.sessionPackage.SessionFacade;
import com.example.FormationPackage.Formation;
import com.example.UserPackage.User;
import com.example.sessionPackage.TypePaiement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.*;

public class SessionTest {
    private SessionFacade sessionFacade;

    @Before
    public void setUp() {
        // Initialisation de SessionFacade avant chaque test
        sessionFacade = SessionFacade.getInstance();
    }

    @After
    public void tearDown() {
        // Réinitialisation des variables après chaque test
        sessionFacade = null;
    }

    @Test
    public void testGetAllSession() {
        List<Session> allSessions = sessionFacade.getAllSession();
        assertNotNull(allSessions);
        assertFalse(allSessions.isEmpty());
        // Effectuez d'autres vérifications en fonction de votre logique métier si nécessaire
    }

    @Test
    public void testSetSession() {
        int sessionId = 1;
        int authorId = 1;
        String nom = "Nom de la session";
        String description = "Description de la session";
        List<Formation> formations = new ArrayList<>();
        List<User> etudiants = new ArrayList<>();
        double prix = 100.0;
        List<TypePaiement> typespayment = new ArrayList<>();
        int nbPlacesMax = 50;
        String lieu = "Lieu de la session";
        String date = "2024-01-02";

        Session newSession = sessionFacade.setSession(sessionId, authorId, nom, description, formations, etudiants, prix,
                typespayment, nbPlacesMax, lieu, date);

        assertNotNull(newSession);
        assertEquals(sessionId, newSession.getId());
        assertEquals(authorId, newSession.getAuthorId());
        assertEquals(nom, newSession.getNom());
        assertEquals(description, newSession.getDescription());
    }

    @Test
    public void testAddSession() {

        int authorId = 1;
        String nomSession = "Nom de la session";
        String descriptionSession = "Description de la session";
        int prixSession = 100;
        double prixDouble = prixSession;
        int nbPlacesMaxSession = 20;
        String lieuSession = "Lieu de la session";
        String dateSession = "2024-01-01";

        List<Formation> formations = new ArrayList<>();
        Formation formation1 = FormationFacade.getInstance().addFormation("Amel", "FormationTest","Description test", 10,"chèque", 3, 3, "Informatique");
        formations.add(formation1);

        List<TypePaiement> typePaiements = new ArrayList<>();
        TypePaiement typePaiement1 = new TypePaiement(4,"gratuit");
        typePaiements.add(typePaiement1);

        Session sessionAdded = sessionFacade.addSession(
                authorId, nomSession, descriptionSession, formations,
                prixSession, typePaiements, nbPlacesMaxSession, lieuSession, dateSession
        );

        assertNotNull(sessionAdded);
        assertEquals(nomSession, sessionAdded.getNom());
        assertEquals(descriptionSession, sessionAdded.getDescription());
        System.out.println(prixDouble);
        System.out.println(sessionAdded.getPrix());
        assertEquals(prixDouble, sessionAdded.getPrix(), 0.001);
        assertEquals(nbPlacesMaxSession, sessionAdded.getNbPlacesMax());
        assertEquals(lieuSession, sessionAdded.getLieu());
        assertEquals(dateSession, sessionAdded.getDate());
    }

    @Test
    public void testGetSessionById() {
        int sessionId = 10;
        Session retrievedSession = sessionFacade.getSessionById(sessionId);
        assertNotNull(retrievedSession);
    }

    @Test
    public void testRemoveSession() {
        int sessionIdToRemove = 1;
        sessionFacade.removeSession(sessionIdToRemove);
        Session removedSession = sessionFacade.getSessionById(sessionIdToRemove);
        assertNull(removedSession);
    }

}
