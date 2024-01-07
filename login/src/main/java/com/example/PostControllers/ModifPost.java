package com.example.PostControllers;

        import com.example.LoginPackage.User;
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

public class ModifPost implements Initializable {


    @FXML
    private Button modifBtn;

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

    private Map<String, Integer> mapNomSession = new HashMap<>();

    private List<TypePost> typePosts;

    private Map<String, Integer> mapNomTP = new HashMap<>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Post post = PostFacade.getInstance().getCurrentPost();

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

        if (post != null) {
            contenu.setText(post.getContenu());

        }
        else {
            System.out.println("erreur lors de la récupération du post sélectionné");
        }
    }

    @FXML
    void annulModif(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("ListPost-view.fxml");
    }

    @FXML
    void modifPost(ActionEvent event) throws IOException {
        // Récupérer les données du post à modifier
        Post currentPost = postFacade.getCurrentPost();
        int postId = currentPost.getId();
        String contenuText = contenu.getText();
        String selectedType = typePost.getSelectionModel().getSelectedItem();
        int typeId = mapNomTP.get(selectedType);
        String selectedSession = sessions.getSelectionModel().getSelectedItem();
        int sessionId = mapNomSession.get(selectedSession);

        User user = UserFacade.getInstance().getUser();
        int authorId = user.getId();

        // Mettre à jour le post
        Post updatedPost = postFacade.setPost(postId, authorId, contenuText, typeId, currentPost.getNbLike(), sessionId);

        if (updatedPost != null) {
            System.out.println("Post mis à jour avec succès !");
            Main m = new Main();
            m.changeScene("ListPost-view.fxml");
        } else {
            System.out.println("Échec de la mise à jour du post !");
        }
    }
}
