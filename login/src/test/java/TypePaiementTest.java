import com.example.TPaiementPackage.TypePaiementFacade;
import com.example.TPaiementPackage.TypePaiement ;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TypePaiementTest {

    @Test
    public void testGetAllTypePost() {
        TypePaiementFacade typePostFacade = TypePaiementFacade.getInstance();

        List<TypePaiement> allTypePost = typePostFacade.getAllTypePaiement();

        assertNotNull(allTypePost);
        assertFalse(allTypePost.isEmpty());
    }
    @Test
    public void testAddAndRemoveTypePost() {
        TypePaiementFacade typePostFacade = TypePaiementFacade.getInstance();

        // Ajout d'un nouveau type de Post
        TypePaiement newTypePaiement = typePostFacade.addTypePaiement("Nouveau TypePaiement", "Description du nouveau TypePaiement");
        assertNotNull(newTypePaiement);

        // Récupération du type de Post ajoutée par son ID
        int newTypeId = newTypePaiement.getId();
        TypePaiement retrievedTypePaiement = typePostFacade.getTypePaiementById(newTypeId);
        assertNotNull(retrievedTypePaiement);

        // Suppression du type de Post ajoutée
        typePostFacade.removeTypePaiement(newTypeId);

        // Vérification que le type de Post a été supprimée en essayant de la récupérer à nouveau
        TypePaiement removeTypePaiement = typePostFacade.getTypePaiementById(newTypeId);
        assertNull(removeTypePaiement);
    }

    @Test
    public void testGetTypePostById() {
        TypePaiementFacade typePaiementFacade = TypePaiementFacade.getInstance();

        TypePaiement newTypePaiement = typePaiementFacade.addTypePaiement("Nouveau TypePaiement", "Description du nouveau TypePaiement");
        assertNotNull(newTypePaiement);

        int newTypeId = newTypePaiement.getId();
        TypePaiement retrievedTypePaiement = typePaiementFacade.getTypePaiementById(newTypeId);

        assertNotNull(retrievedTypePaiement);
        assertEquals(newTypeId, retrievedTypePaiement.getId());

        typePaiementFacade.removeTypePaiement(newTypeId);
    }

    @Test
    public void testSetTypePost() {
        TypePaiementFacade typePaiementFacade = TypePaiementFacade.getInstance();

        TypePaiement newTypePaiement = typePaiementFacade.addTypePaiement("Nouveau TypePaiement", "Description du nouveau TypePaiement");
        assertNotNull(newTypePaiement);

        int newTypeId = newTypePaiement.getId();
        TypePaiement retrievedTypePaiement = typePaiementFacade.getTypePaiementById(newTypeId);
        assertNotNull(retrievedTypePaiement);

        String updatedName = "TypePaiement Mis à Jour";
        String updatedDescription = "Description mise à jour du TypePaiement";

        typePaiementFacade.setTypePaiement(newTypeId, updatedName,updatedDescription);

        TypePaiement updatedTypePaiement = typePaiementFacade.getTypePaiementById(newTypeId);
        assertNotNull(updatedTypePaiement);
        assertEquals(updatedName, updatedTypePaiement.getNom());
        assertEquals(updatedDescription, updatedTypePaiement.getDescription());

        typePaiementFacade.removeTypePaiement(newTypeId);
    }


}
