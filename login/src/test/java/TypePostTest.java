import com.example.TPPackage.TypePostFacade;
import com.example.TPPackage.TypePost;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TypePostTest {

    @Test
    public void testGetAllTypePost() {
        TypePostFacade typePostFacade = TypePostFacade.getInstance();

        List<TypePost> allTypePost = typePostFacade.getAllTypePost();

        assertNotNull(allTypePost);
        assertFalse(allTypePost.isEmpty());
    }
    @Test
    public void testAddAndRemoveTypePost() {
        TypePostFacade typePostFacade = TypePostFacade.getInstance();

        // Ajout d'un nouveau type de Post
        TypePost newTypePost = typePostFacade.addTypePost("Nouveau Post", "Description du nouveau Post");
        assertNotNull(newTypePost);

        // Récupération du type de Post ajoutée par son ID
        int newTypeId = newTypePost.getId();
        TypePost retrievedTypePost = typePostFacade.getTypePostById(newTypeId);
        assertNotNull(retrievedTypePost);

        // Suppression du type de Post ajoutée
        typePostFacade.removeTypePost(newTypeId);

        // Vérification que le type de Post a été supprimée en essayant de la récupérer à nouveau
        TypePost removedTypePost = typePostFacade.getTypePostById(newTypeId);
        assertNull(removedTypePost);
    }

    @Test
    public void testGetTypePostById() {
        TypePostFacade typePostFacade = TypePostFacade.getInstance();

            TypePost newTypePost = typePostFacade.addTypePost("Nouveau Post", "Description du nouveau Post");
            assertNotNull(newTypePost);

            int newTypeId = newTypePost.getId();
            TypePost retrievedTypePost = typePostFacade.getTypePostById(newTypeId);

            assertNotNull(retrievedTypePost);
            assertEquals(newTypeId, retrievedTypePost.getId());

            typePostFacade.removeTypePost(newTypeId);
        }

        @Test
        public void testSetTypePost() {
            TypePostFacade typePostFacade = TypePostFacade.getInstance();

            TypePost newTypePost = typePostFacade.addTypePost("Nouveau Post", "Description du nouveau Post");
            assertNotNull(newTypePost);

            int newTypeId = newTypePost.getId();
            TypePost retrievedTypePost = typePostFacade.getTypePostById(newTypeId);
            assertNotNull(retrievedTypePost);

            String updatedName = "Post Mis à Jour";
            String updatedDescription = "Description mise à jour du Post";

            typePostFacade.setTypePost(newTypeId, updatedName,updatedDescription);

            TypePost updatedTypePost = typePostFacade.getTypePostById(newTypeId);
            assertNotNull(updatedTypePost);
            assertEquals(updatedName, updatedTypePost.getNom());
            assertEquals(updatedDescription, updatedTypePost.getDescription());

            typePostFacade.removeTypePost(newTypeId);
        }


}
