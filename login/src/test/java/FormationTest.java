import com.example.FormationPackage.*;
import com.example.UserPackage.User;
import com.example.UserPackage.UserFacade;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FormationTest {

    @Test
    public void testGetAllFormation() {
        FormationFacade formationFacade = FormationFacade.getInstance();

        List<Formation> formations = formationFacade.getAllFormation();

        assertNotNull(formations);
        assertFalse(formations.isEmpty());
    }

    @Test
    public void testAddGetByIdAndRemoveFormation() {
        FormationFacade formationFacade = FormationFacade.getInstance();
        UserFacade userFacade = UserFacade.getInstance();
        String username = "ines";
        String password = "123";

        userFacade.login(username, password);

        // ajout d'un nouvelle formation
        Formation newFormation = formationFacade.addFormation(userFacade.getUser().getUsername(),"Formation test","description test",2,"Chèque",2,2,"Software");
        assertNotNull(newFormation);

        // Récupération de la formation ajoutée par son ID
        int newFormationId = newFormation.getId();
        Formation retrievedFormation = formationFacade.getFormationById(newFormationId);
        assertNotNull(retrievedFormation);

        //Suppression de la formation ajoutée
        formationFacade.removeFormation(newFormationId);

        //on vérfiie que la formation a bien été supprimée en la réupérant
        Formation removedFormation = formationFacade.getFormationById(newFormationId);
        assertNull(removedFormation);
    }

}

