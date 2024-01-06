import com.example.TFPackage.TypeFormationFacade;
import com.example.TFPackage.TypeFormation;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TypeFormationTest {
    @Test
    public void testGetAllTypeFormation() {
        TypeFormationFacade typeFormationFacade = TypeFormationFacade.getInstance();

        List<TypeFormation> allTypeFormation = typeFormationFacade.getAllTypeFormation();

        assertNotNull(allTypeFormation);
        assertFalse(allTypeFormation.isEmpty());
    }
    @Test
    public void testAddAndRemoveTypeFormation() {
        TypeFormationFacade typeFormationFacade = TypeFormationFacade.getInstance();

        // Ajout d'une nouvelle formation
        TypeFormation newTypeFormation = typeFormationFacade.addTypeFormation("Nouvelle Formation", "Description de la nouvelle formation");
        assertNotNull(newTypeFormation);

        // Récupération de la formation ajoutée par son ID
        int newTypeId = newTypeFormation.getId();
        TypeFormation retrievedTypeFormation = typeFormationFacade.getTypeFormationById(newTypeId);
        assertNotNull(retrievedTypeFormation);

        // Suppression de la formation ajoutée
        typeFormationFacade.removeTypeFormation(newTypeId);

        // Vérification que la formation a été supprimée en essayant de la récupérer à nouveau
        TypeFormation removedTypeFormation = typeFormationFacade.getTypeFormationById(newTypeId);
        assertNull(removedTypeFormation);
    }
}
