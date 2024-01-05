package com.example.PostControllers;
import com.example.PostsPackage.Post;
import com.example.PostsPackage.PostFacade;
import com.example.TPPackage.TypePost;
import com.example.TPPackage.TypePostFacade;
import com.example.login.Main;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class ListPost implements Initializable  {

    public Button supprimerbutton;
    public Button modifierbutton;
    public Button viewbutton;
    public ChoiceBox<String> listTP;
    @FXML
    private Button AjouterBtn;

    @FXML
    private Button VoirBtn;

    @FXML
    private Label contenuPost;

    @FXML
    private Label autheur;

    @FXML
    private ListView<String> listPost;

    @FXML
    private Label nb_commentaires;

    @FXML
    private Label nb_likes;

    @FXML
    private Label titre;

    private PostFacade postFacade;

    private List<Post> tabPost;

    private Map<String, Integer> postMap = new HashMap<>();

    private Post currentPost;
    private List<TypePost> typePosts;

    private Map<String, Integer> mapNomTP = new HashMap<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.postFacade= PostFacade.getInstance();
        tabPost = postFacade.getPost();

        List<String> postContenu = tabPost.stream().map(Post::getContenu).collect(Collectors.toList());
        System.out.println("**********$$$$$$$$$$$$$$");
        listPost.getItems().addAll(postContenu);
        for (Post post : tabPost) {
            System.out.println(post.getContenu());
            // TODO récupére le user avec son id pour afficher son username
            postMap.put(post.getContenu(), post.getAuteurId());
        }

        listPost.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            currentPost = tabPost.stream()
                    .filter(post -> post.getContenu().equals(newValue))
                    .findFirst()
                    .orElse(null);

            if (currentPost != null) {
                this.postFacade.getPostById(currentPost.getId());
                contenuPost.setText(currentPost.getContenu());
                nb_likes.setText(String.valueOf(currentPost.getNbLike()));
                updateContenu();

                Integer userId = postMap.get(newValue);
                if (userId != null) {
                    // Ici, vous pouvez utiliser l'ID de l'utilisateur pour récupérer ses informations et afficher son nom d'utilisateur, par exemple
                    autheur.setText("Auteur: " + userId);
                }
            }
        });

        this.typePosts = TypePostFacade.getInstance().getAllTypePost();
        for (TypePost type : typePosts) {
            mapNomTP.put(type.getNom(), type.getId());
            listTP.getItems().add(type.getNom());
        }
        listTP.setOnAction(this::onSelectTypePost);
    }

    @FXML
    void ajoutPost(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("AjoutPost-view.fxml");
    }

    private void updateContenu() {
        if (currentPost != null) {
            String contenu = currentPost.getContenu();

            if (contenu != null && !contenu.isEmpty()) {
                contenuPost.setText(contenu);
            } else {
                contenuPost.setText("Description non disponible");
            }
        }
    }

    public void removePost(ActionEvent actionEvent) {
        if (currentPost != null) {
            this.postFacade.removePost(currentPost.getId());
            this.tabPost = postFacade.getPost();
            updateList(); // Mettre à jour la liste des publications dans l'interface graphique
            clearPostDetails(); // Effacer les détails de la publication
        }
    }

    private void updateList() {
        listPost.getItems().clear(); // Effacer tous les éléments actuels de la liste
        List<String> postContenu = tabPost.stream().map(Post::getContenu).collect(Collectors.toList());
        listPost.getItems().addAll(postContenu); // Ajouter les nouvelles publications à la liste
    }

    private void clearPostDetails() {
        contenuPost.setText(""); // Effacer le contenu de la publication
        nb_likes.setText(""); // Effacer le nombre de likes
        autheur.setText(""); // Effacer les détails de l'auteur
    }


    public void setPost(ActionEvent actionEvent) throws IOException {
        Main m = new Main();
        m.changeScene("ModifPost-view.fxml");
    }

    public void viewPost(ActionEvent actionEvent) throws IOException {
        Main m = new Main();
        m.changeScene("DetailsPost-view.fxml");
    }

    public void backToAfterLogin(ActionEvent actionEvent) throws IOException {
        Main m = new Main();
        m.changeScene("afterLogin.fxml");
    }

    @FXML
    void onSelectTypePost(ActionEvent event) {
        String selectedType = listTP.getValue();
        if (selectedType != null) {
            Integer typeId = mapNomTP.get(selectedType);
            if (typeId != null) {
                List<Post> postsByType = postFacade.getPostByTPId(typeId);
                tabPost.clear();
                tabPost.addAll(postsByType);
                updateList();
                clearPostDetails();
            }
        }
        else {
            List<Post> postsByType = postFacade.getPost();
            tabPost.clear();
            tabPost.addAll(postsByType);
            updateList();
            clearPostDetails();
        }
    }
}
