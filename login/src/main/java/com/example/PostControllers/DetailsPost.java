package com.example.PostControllers;

import com.example.CommentairePackage.Commentaire;
import com.example.CommentairePackage.CommentaireFacade;
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
import java.util.*;

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

    private List<Commentaire> commentaires;

    private Map<String, Integer> mapCommentaires = new HashMap<>();

    @FXML
    void ajoutCommentaire(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("addCommentairePost-view.fxml");
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

            this.commentaires = CommentaireFacade.getInstance().getCommentairesByPostId(Integer.valueOf(post.getId()));

            List<String> commentStrings = new ArrayList<>();
            for (Commentaire commentaire : commentaires) {
                String commentString = commentaire.getContenu();
                commentStrings.add(commentString);
                mapCommentaires.put(commentString, commentaire.getId());
            }

            // Ajouter les chaînes à la ListView
            this.listCom.getItems().addAll(commentStrings);

            listCom.setOnMouseClicked(mouseEvent -> {
                String selectedComment = listCom.getSelectionModel().getSelectedItem();
                if (selectedComment != null) {
                    Commentaire comm = CommentaireFacade.getInstance().getCommentaireById(mapCommentaires.get(selectedComment));
                    auteurCom.setText(comm.getAuthorName() + " Note : " + comm.getNote() + "/5");
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
