package com.example.LoginPackage;

import com.example.LoginPackage.UserFacade;
import com.example.LoginPackage.User;
//import org.junit.Test;
//import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {
	
	@Test
    public void testLoginSuccess() {
        UserFacade userFacade = UserFacade.getInstance();
        String username = "testUser"; // à mettre un utilisateur valide 
        String password = "testPassword"; // à mettre un mot de passe valide 

        User result = userFacade.login(username, password);

        assertNotNull(result);
        assertEquals(username, result.getName());
        //assertTrue(result); // Le test réussit si les identifiants sont corrects
    }

    @Test
    public void testLoginFailure() {
        UserFacade userFacade = UserFacade.getInstance();
        String username = "nonExistingUser";
        String password = "wrongPassword";

        User result = userFacade.login(username, password);

        assertNull(result);
        //assertFalse(result); // Le test réussit si les identifiants sont incorrects

    }

}
