import com.example.UserPackage.UserFacade;
import com.example.UserPackage.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegisterTest {

    private UserFacade userFacade;

    @Before
    public void setUp() {
        // Faut s'assurer que c'est connecté à la BD
        userFacade = UserFacade.getInstance();
    }
    @Test
    public void RegisterTestSuccess () {
        // Préparer les données de test
        String last_name = "";
        String first_name = "";
        String username = "yo";
        String password = "1234";
        String email = "";
        String status = "";

        // Appel à la méthode Register
        User newUser = userFacade.Register(last_name, first_name, username, password, email, status);

        // Vérifier les résultats
        assertNotNull(newUser);
        assertEquals(username, newUser.getUsername());

    }

    @Test
    public void RegisterTestFail () {
        String last_name = " 20";
        String first_name = "20";
        String username = "20";
        String password = "20";
        String email = "20@gmail.com";
        String status = "20";

        // Tentative d'inscription avec des informations qui devraient échouer
        User newUser = userFacade.Register(last_name, first_name, username, password, email, status);

        assertNull(newUser);
    }

}
