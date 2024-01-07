package com.example.formation;

import com.example.CommentairePackage.Commentaire;
import com.example.CommentairePackage.CommentaireFacade;
import com.example.FormationPackage.FormationFacade;
import com.example.LoginPackage.UserFacade;
import com.example.login.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ModifierCommentaire implements Initializable {
    @FXML
    private TextField contenuInput;
    @FXML
    private ChoiceBox<Integer> noteChoiceBox;
    private Integer[] note = {1,2,3,4,5};
    private UserFacade userFacade;
    private CommentaireFacade commentaireFacade;
    private FormationFacade formationFacade;
    private String author;
    private int formationId;
    private int commentaireId;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        Commentaire commentaire = commentaireFacade.getInstance().getCommentaire();
        noteChoiceBox.getItems().addAll(note);

        if(commentaire != null){
            commentaireId = commentaire.getId();
            author = commentaire.getAuthorName();
            formationId = commentaire.getFormationId();
            noteChoiceBox.setValue(commentaire.getNote());
            contenuInput.setText(commentaire.getContenu());
        } else {
            System.out.println("erreur lors de la récupération du commentaire");
        }

    }

    public void modificationcommentaire(ActionEvent event) throws IOException {
        CommentaireFacade.getInstance().setCommentaire(commentaireId,formationId,null, author,contenuInput.getText().toString(),noteChoiceBox.getValue());
        Main m = new Main();
        m.changeScene("Commentaire-viem.fxml");
    }

    public void annulation(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("Commentaire-viem.fxml");
    }
}
