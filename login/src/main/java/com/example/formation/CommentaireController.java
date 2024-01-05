package com.example.formation;

import java.util.*;
import com.example.CommentairePackage.CommentaireFacade;
import com.example.CommentairePackage.Commentaire;

import com.example.FormationPackage.Formation;
import com.example.FormationPackage.FormationFacade;
import com.example.login.Main;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
public class CommentaireController implements Initializable {

    public CommentaireController() {}
    private CommentaireFacade commentaireFacade;
    private Commentaire currentCommentaire;
    private List<Commentaire> tabCommentaire;
    private FormationFacade formationFacade;
    @FXML
    private ListView<String> listCommentaire;
    @FXML
    private Label authorName;
    @FXML
    private Label contenuLabel;
    @FXML
    private Label noteLabel;
    @FXML
    private Label nomFormationLabel;
    @FXML
    private Button deletebutton;
    @FXML
    private Label moyenneNoteLabel;


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        this.commentaireFacade = CommentaireFacade.getInstance();
        this.formationFacade = FormationFacade.getInstance();
        nomFormationLabel.setText("Commentaires de la formation " + FormationFacade.getInstance().getFormation().getNom());

        int currentFormation = FormationFacade.getInstance().getFormation().getId();

        this.tabCommentaire =  CommentaireFacade.getInstance().getCommentairesByFormationId(currentFormation);

        List<String> commentaires = tabCommentaire.stream().map(Commentaire::getContenu).collect(Collectors.toList());
        listCommentaire.getItems().addAll(commentaires);

        listCommentaire.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                    currentCommentaire = tabCommentaire.stream()
                            .filter(comment -> comment.getContenu().equals(newValue))
                            .findFirst()
                            .orElse(null);

                    if (currentCommentaire != null) {
                        this.commentaireFacade.getCommentaireById(currentCommentaire.getId());
                        authorName.setText(currentCommentaire.getAuthorName());
                        contenuLabel.setText(currentCommentaire.getContenu());
                        noteLabel.setText("Note :" + currentCommentaire.getNote() + "/5");
                    }
                });
        //par défaut
        if (!tabCommentaire.isEmpty()) {
            double sumNotes = 0;
            for (Commentaire commentaire : tabCommentaire) {
                sumNotes += commentaire.getNote();
            }
            double moyenneNotes = sumNotes / commentaires.size();
            moyenneNoteLabel.setText("Note : " + String.format("%.1f", moyenneNotes) + "/5");
            Commentaire firstComment = tabCommentaire.get(0);
            authorName.setText(firstComment.getAuthorName());
            contenuLabel.setText(firstComment.getContenu());
            noteLabel.setText("Note :" + firstComment.getNote() + "/5");
        }
    }

    public void retourFormations(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("ViewFormation.fxml");
    }

    public void modifyComments(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("modifierCommentaire.fxml");
    }
    public void deleteComments(ActionEvent event) throws IOException {
        if (currentCommentaire != null) {
            System.out.println("l'id du commentaire : "+  currentCommentaire.getId());
            int commentId = currentCommentaire.getId();
            this.commentaireFacade.removeCommentaire(commentId);

            // Mettre à jour les commentaires après la suppression
            tabCommentaire = commentaireFacade.getCommentairesByFormationId(this.formationFacade.getFormation().getId());
            List<String> commentaireAutheur = tabCommentaire.stream().map(Commentaire::getContenu).collect(Collectors.toList());

            // Vérifier si le commentaire supprimé est celui affiché actuellement
            if (currentCommentaire.getId() == commentId) {
                currentCommentaire = null;
                authorName.setText("");
                contenuLabel.setText("");
                noteLabel.setText("");
            }

            listCommentaire.getItems().clear();
            listCommentaire.getItems().addAll(commentaireAutheur);
        }
    }

    public void ajouterComm(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("addCommentaire.fxml");
    }


}