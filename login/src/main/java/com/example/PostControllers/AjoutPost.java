package com.example.PostControllers;

import com.example.LoginPackage.UserFacade;
import com.example.PostsPackage.Post;
import com.example.PostsPackage.PostFacade;
import com.example.TPPackage.TypePost;
import com.example.TPPackage.TypePostFacade;
import com.example.login.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class AjoutPost implements Initializable {

    @FXML
    private Button ajoutBtn;

    @FXML
    private Button annulBtn;

    @FXML
    private TextField contenu;

    @FXML
    private ChoiceBox<String> sessions;

    @FXML
    private Label titre;

    @FXML
    private ChoiceBox<String> typePost;

    private PostFacade postFacade = PostFacade.getInstance();

    private List<String> listSessionId = new ArrayList<>();

    private  Map<String, Integer> mapNomSession = new HashMap<>();

    private List<TypePost> typePosts;

    private Map<String, Integer> mapNomTP = new HashMap<>();


    @FXML
    void annulAjout(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("ListPost-view.fxml");
    }

    @FXML
    void ajoutPost(ActionEvent event) throws IOException {
            // Récupérer les valeurs sélectionnées dans les ChoiceBox et les champs TextField
            String contenuText = contenu.getText(); // Récupérer le contenu du TextField

            String selectedType = typePost.getSelectionModel().getSelectedItem(); // Récupérer le type de post sélectionné dans le ChoiceBox typePost
            int typeId = mapNomTP.get(selectedType); // Récupérer l'ID du type de post

            String selectedSession = sessions.getSelectionModel().getSelectedItem(); // Récupérer la session sélectionnée dans le ChoiceBox sessions
            int sessionId = mapNomSession.get(selectedSession); // Récupérer l'ID de la session

            // Vous devrez obtenir l'ID de l'auteur depuis quelque part, par exemple à partir d'un objet User connecté

            int authorId = UserFacade.getInstance().getUser().getId();

            Post addedPost = postFacade.addPost(authorId, contenuText, typeId, 0, sessionId); // Le nbLike est 0 par défaut
            System.out.println(addedPost);

            if (addedPost != null) {

                System.out.println("Post ajouté avec succès !");
                Main m = new Main();
                m.changeScene("ListPost-view.fxml");
            } else {
                // Échec de l'ajout du post
                // Gérez les actions en cas d'échec de l'ajout du post
                System.out.println("Échec de l'ajout du post !");
            }
        }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //TODO remplacer par un getAllSessions
        this.listSessionId = Arrays.asList("s1", "s2", "s3");
        for (int i = 0; i< this.listSessionId.size(); i++) {
            this.mapNomSession.put(listSessionId.get(i), i );
            this.sessions.getItems().add(listSessionId.get(i));
        }

        TypePostFacade typePostFacade = TypePostFacade.getInstance();
        this.typePosts = typePostFacade.getAllTypePost();
        for (TypePost type : typePosts) {
            mapNomTP.put(type.getNom(), type.getId());
            typePost.getItems().add(type.getNom());
        }
    }


}
