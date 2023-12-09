
import com.example.LoginPackage.UserFacade;
import com.example.LoginPackage.User;
import org.junit.Test;

import static org.junit.Assert.*;
//import org.junit.Test;
//import static org.junit.Assert.*;

//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
public class LoginTest {

    @Test
    public void testLoginSuccess() {
        UserFacade userFacade = UserFacade.getInstance();
        String username = "amel"; // à mettre un utilisateur valide
        String password = "amel"; // à mettre un mot de passe valide

        User result = userFacade.login(username, password);

        assertNotNull(result);
        assertEquals(username, result.getUsername());
        //assertTrue(result); // Le test réussit si les identifiants sont corrects
    }

    @Test
    public void testLoginFailure() {
        UserFacade userFacade = UserFacade.getInstance();
        String username = "ksksk";
        String password = "12";

        User result = userFacade.login(username, password);

        assertNull(result);
        //assertEquals(false, result); // Le test réussit si les identifiants sont incorrects
        //assertFalse(result); // Le test réussit si les identifiants sont incorrects

    }

}
