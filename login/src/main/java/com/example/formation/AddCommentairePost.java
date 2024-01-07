package com.example.formation;

import com.example.CommentairePackage.CommentaireFacade;
import com.example.UserPackage.UserFacade;
import com.example.PostsPackage.PostFacade;
import com.example.login.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddCommentairePost implements Initializable {

    @FXML
    private TextField contenuInput;
    @FXML
    private ChoiceBox<Integer> noteChoiceBox;
    private Integer[] note = {1,2,3,4,5};
    private UserFacade userFacade;
    private CommentaireFacade commentaireFacade;
    private PostFacade postFacade;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        this.commentaireFacade = commentaireFacade.getInstance();
        noteChoiceBox.getItems().addAll(note);
    }

    public void ajoutducommentaire(ActionEvent event) throws IOException {
        String authorName = userFacade.getInstance().getUser().getUsername();
        int postId = PostFacade.getInstance().getCurrentPost().getId();
        int note = noteChoiceBox.getValue();
        String contenu = contenuInput.getText();

        commentaireFacade.getInstance().addCommentaire(null, postId, authorName,contenu,note);
        Main m = new Main();
        m.changeScene("DetailsPost-view.fxml");
    }

    public void annulation(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("DetailsPost-view.fxml");
    }

}
