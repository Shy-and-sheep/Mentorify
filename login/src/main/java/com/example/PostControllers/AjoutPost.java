package com.example.PostControllers;

import com.example.UserPackage.UserFacade;
import com.example.PostsPackage.Post;
import com.example.PostsPackage.PostFacade;
import com.example.TPPackage.TypePost;
import com.example.TPPackage.TypePostFacade;
import com.example.login.Main;
import com.example.sessionPackage.Session;
import com.example.sessionPackage.SessionFacade;
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

    private List<Session> listSessionId = new ArrayList<>();

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
            String contenuText = contenu.getText();

            String selectedType = typePost.getSelectionModel().getSelectedItem();
            int typeId = mapNomTP.get(selectedType);

            String selectedSession = sessions.getSelectionModel().getSelectedItem();
            int sessionId = mapNomSession.get(selectedSession);
            int authorId = UserFacade.getInstance().getUser().getId();

            Post addedPost = postFacade.addPost(authorId, contenuText, typeId, 0, sessionId);
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

        this.listSessionId = SessionFacade.getInstance().getAllSession();
        for (Session session : listSessionId) {
            this.mapNomSession.put(session.getNom(), session.getId() );
            this.sessions.getItems().add(session.getNom());
        }

        TypePostFacade typePostFacade = TypePostFacade.getInstance();
        this.typePosts = typePostFacade.getAllTypePost();
        for (TypePost type : typePosts) {
            mapNomTP.put(type.getNom(), type.getId());
            typePost.getItems().add(type.getNom());
        }
    }


}
