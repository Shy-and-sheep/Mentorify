package com.example.PostControllers;

import com.example.PostsPackage.Post;
import com.example.PostsPackage.PostFacade;
import com.example.TPPackage.TypePost;
import com.example.TPPackage.TypePostFacade;
import com.example.login.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class DetailsPost implements Initializable {

    @FXML
    private Button ajoutCom;

    @FXML
    private Label auteurCom;

    @FXML
    private AnchorPane contenuBox;

    @FXML
    private Label contenuCom;

    @FXML
    private Label contenuPost;

    @FXML
    private ListView<String> listCom;

    @FXML
    private Label nbLikes;

    @FXML
    private Label typePost;

    @FXML
    private Label userName;

    private Post post;

    private List<String> commentaires = Arrays.asList("ceci est un commentaire", "ceci est un deuxième commentaire", "il faut remplacer par des vrais commentaires");

    @FXML
    void ajoutCommentaire(ActionEvent event) {
        //TODO ajouter le chemin pour aller à l'ajout de commentaire
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.post = PostFacade.getInstance().getCurrentPost();
        if (post != null){
            contenuPost.setText(post.getContenu());
            TypePost tp = TypePostFacade.getInstance().getTypePostById(post.getTypePostId());
            typePost.setText(tp.getNom());
            userName.setText("User id : " + post.getAuteurId());
            nbLikes.setText(String.valueOf(post.getNbLike()));
            this.listCom.getItems().addAll(commentaires);
            listCom.setOnMouseClicked(mouseEvent -> {
                String selectedComment = listCom.getSelectionModel().getSelectedItem();
                if (selectedComment != null) {
                    contenuCom.setText(selectedComment);
                }
            });
        }
    }
    public void retourListPost(ActionEvent actionEvent) throws IOException {
        Main m = new Main();
        m.changeScene("ListPost-view.fxml");
    }
}
