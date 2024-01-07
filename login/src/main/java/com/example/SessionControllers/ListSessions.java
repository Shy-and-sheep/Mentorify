package com.example.SessionControllers;

import com.example.PostsPackage.Post;
import com.example.login.Main;
import com.example.sessionPackage.Session;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import com.example.sessionPackage.SessionFacade;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class ListSessions implements Initializable {

    @FXML
    private Button ajoutBtn;

    @FXML
    private Label dateSession;

    @FXML
    private Label descriptionSession;

    @FXML
    private Button detailBtn;

    @FXML
    private ListView<String> listSession;

    @FXML
    private Button modifBtn;

    @FXML
    private Label nbInscrits;

    @FXML
    private Label prixSession;

    @FXML
    private Button retourBtn;

    @FXML
    private Label titre;

    private SessionFacade sessionFacade;
    private List<Session> tabSessions;

    private Map<String, Integer> sessionMap = new HashMap<>();

    private Session currentSession;

    @FXML
    void ajouterSession(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("AjoutSession-view.fxml");
    }

    @FXML
    void detailsSession(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("DetailsSession-view.fxml");
    }

    @FXML
    void modfiSession(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("ModifSession-view.fxml");
    }
    @FXML
    void suppSession(ActionEvent event) {
        if (currentSession != null) {
            this.sessionFacade.removeSession(currentSession.getId());
            this.tabSessions = sessionFacade.getAllSession();
            updateList();
            clearSessionDetails();
        }
    }

    private void updateList() {
        listSession.getItems().clear(); // Effacer tous les éléments actuels de la liste
        List<String> postContenu = tabSessions.stream().map(Session::getNom).collect(Collectors.toList());
        listSession.getItems().addAll(postContenu); // Ajouter les nouvelles publications à la liste
    }

    @FXML
    void retourAccueil(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("afterLogin.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.sessionFacade = SessionFacade.getInstance();
        tabSessions = sessionFacade.getAllSession(); // Obtenir toutes les sessions

        List<String> sessionNames = tabSessions.stream().map(Session::getNom).collect(Collectors.toList());
        listSession.getItems().addAll(sessionNames);

        for (Session session : tabSessions) {
            sessionMap.put(session.getNom(), session.getId());
            // TODO: Récupérer et afficher d'autres détails de session si nécessaire
        }

        listSession.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            currentSession = tabSessions.stream()
                    .filter(session -> session.getNom().equals(newValue))
                    .findFirst()
                    .orElse(null);

            if (currentSession != null) {
                this.sessionFacade.getSessionById(currentSession.getId());
                descriptionSession.setText(currentSession.getDescription());
                nbInscrits.setText(String.valueOf(currentSession.getEtudiants().size()) + "/" + currentSession.getNbPlacesMax());
                prixSession.setText(String.valueOf(currentSession.getPrix()));
                dateSession.setText(String.valueOf(currentSession.getDate()));
                updateSessionDetails();

            }
        });

    }

    private void updateSessionDetails() {
        if (currentSession != null) {
            String description = currentSession.getDescription();
            String date = currentSession.getDate();

            if (description != null && !description.isEmpty()) {
                descriptionSession.setText(description);
            } else {
                descriptionSession.setText("Description non disponible");
            }

            if (date != null && !date.isEmpty()) {
                dateSession.setText(date);
            } else {
                dateSession.setText("Date non disponible");
            }

            // Mise à jour d'autres détails de session si nécessaire
        }
    }

    private void clearSessionDetails() {
        prixSession.setText("");
        dateSession.setText("");
        nbInscrits.setText("");
        descriptionSession.setText("");
    }
}

