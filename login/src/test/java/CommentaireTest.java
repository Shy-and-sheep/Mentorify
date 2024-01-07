import com.example.CommentairePackage.*;
import com.example.FormationPackage.Formation;
import com.example.FormationPackage.FormationFacade;
import com.example.LoginPackage.User;
import com.example.LoginPackage.UserFacade;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CommentaireTest {
    @Test
    public void testGetAllCommentaire() {
        CommentaireFacade commentaireFacade = CommentaireFacade.getInstance();

        List<Commentaire> commentaires = commentaireFacade.getAllCommentaire();

        assertNotNull(commentaires);
        assertFalse(commentaires.isEmpty());
    }

    @Test
    public void testAddGetByIdAndRemoveCommentaire() {
        CommentaireFacade commentaireFacade = CommentaireFacade.getInstance();
        UserFacade userFacade = UserFacade.getInstance();
        String username = "ines";
        String password = "123";

        userFacade.login(username, password);

        FormationFacade formationFacade = FormationFacade.getInstance();

        // ajout d'une nouvelle formation
        Formation newFormation = formationFacade.addFormation(userFacade.getUser().getUsername(),"Formation test","description test",2,"Chèque",2,2,"Software");

        // ajout d'un commentaire à cette formation
        Commentaire newCommentaire= commentaireFacade.addCommentaire(newFormation.getId(),"ines","commentaire test de ines",5);
        assertNotNull(newFormation);

        // Récupération du commentaire ajoutée par son ID
        int newCommentaireId = newCommentaire.getId();
        Commentaire retrievedCommentaire = commentaireFacade.getCommentaireById(newCommentaireId);
        assertNotNull(retrievedCommentaire);

        //Suppression du commentaire ajouté
        commentaireFacade.removeCommentaire(newCommentaireId);

        //on vérfiie que la formation a bien été supprimée en la réupérant
        Commentaire removedCommentaire = commentaireFacade.getCommentaireById(newCommentaireId);
        assertNull(removedCommentaire);
    }
}
