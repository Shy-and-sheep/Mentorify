package com.example.SessionControllers;

import com.example.FormationPackage.FormationFacade;
import com.example.LoginPackage.User;
import com.example.LoginPackage.UserFacade;
import com.example.login.Main;
import com.example.sessionPackage.Session;
import com.example.sessionPackage.SessionFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import com.example.sessionPackage.TypePaiement;
import com.example.FormationPackage.Formation;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class DetailsSession implements Initializable {

    @FXML
    private Label date;

    @FXML
    private Label descriptionSession;

    @FXML
    private Button desinscrirebtn;

    @FXML
    private Button inscriptionBtn;

    @FXML
    private Label lieu;

    @FXML
    private ListView<String> listFormations;

    @FXML
    private ListView<String> listTPaiement;

    @FXML
    private Label nbInscrit;

    @FXML
    private Label nomSession;

    @FXML
    private Label prix;

    @FXML
    private Button retourBtn;

    @FXML
    private Button voirBtn;
    private SessionFacade sessionFacade;
    private Session currentSession;

    private FormationFacade formationFacade;

    List<Formation> formations = new ArrayList<>();

    Map<String, Integer> formationMap = new HashMap<>();

    @FXML
    void desinscrire(ActionEvent event) {
        User user = UserFacade.getInstance().getUser();;
        int userId = user.getId();
        this.sessionFacade.desinscriptionSession(userId, currentSession.getId());
        this.sessionFacade.getSessionById(currentSession.getId());
        currentSession = sessionFacade.getSession();
        this.nbInscrit.setText(String.valueOf(currentSession.getEtudiants().size() + "/" + currentSession.getNbPlacesMax()));
    }

    @FXML
    void inscriptionSession(ActionEvent event) {
        User user = UserFacade.getInstance().getUser();;
        int userId = user.getId();
        this.sessionFacade.inscriptionSession(userId, currentSession.getId());
        this.sessionFacade.getSessionById(currentSession.getId());
        currentSession = sessionFacade.getSession();
        this.nbInscrit.setText(String.valueOf(currentSession.getEtudiants().size() + "/" + currentSession.getNbPlacesMax()));
    }

    @FXML
    void retournListSes(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("listSession-view.fxml");
    }

    @FXML
    void voirFormation(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("ViewFormation.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.sessionFacade = SessionFacade.getInstance();
        this.currentSession = sessionFacade.getSession();
        this.nomSession.setText(currentSession.getNom());
        this.descriptionSession.setText(currentSession.getDescription());
        this.date.setText(currentSession.getDate());
        this.lieu.setText(currentSession.getLieu());
        this.nbInscrit.setText(String.valueOf(currentSession.getEtudiants().size() + "/" + currentSession.getNbPlacesMax()));
        this.prix.setText(String.valueOf(currentSession.getPrix()));

        this.formations = currentSession.getFormations();
        for (Formation form : formations) {
            this.formationMap.put(form.getNom(), form.getId());
        }

        // Initialisation de la liste des formations de la session
        List<String> formationNames = currentSession.getFormations().stream()
                .map(Formation::getNom)
                .collect(Collectors.toList());
        listFormations.getItems().addAll(formationNames);

        listFormations.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                this.formationFacade = FormationFacade.getInstance();
                this.formationFacade.getFormationById(formationMap.get(newValue));
            }
        });

        // Initialisation de la liste des types de paiement de la session
        if (currentSession.getTypespaiement() != null) {
            List<String> typePaiementNames = currentSession.getTypespaiement().stream()
                    .map(TypePaiement::getNom)
                    .collect(Collectors.toList());
            listTPaiement.getItems().addAll(typePaiementNames);
        }
    }
}
