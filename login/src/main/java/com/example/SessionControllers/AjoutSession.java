package com.example.SessionControllers;

import com.example.FormationPackage.Formation;
import com.example.FormationPackage.FormationFacade;
import com.example.TPaiementPackage.TypePaiementFacade;
import com.example.UserPackage.UserFacade;
import com.example.login.Main;
import com.example.sessionPackage.Session;
import com.example.sessionPackage.SessionFacade;
import com.example.TPaiementPackage.TypePaiement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class AjoutSession implements Initializable {

    @FXML
    private Button ajoutBtn;

    @FXML
    private ChoiceBox<String> choixForm1;

    @FXML
    private ChoiceBox<String> choixForm2;

    @FXML
    private ChoiceBox<String> choixForm3;

    @FXML
    private ChoiceBox<String> choixTPa1;

    @FXML
    private ChoiceBox<String> choixTPa2;

    @FXML
    private ChoiceBox<String> choixTPa3;

    @FXML
    private TextArea date;

    @FXML
    private TextArea description;

    @FXML
    private TextArea lieu;

    @FXML
    private TextArea nbPlacesMax;

    @FXML
    private TextArea nom;

    @FXML
    private TextArea prix;

    @FXML
    private Button retourBtn;

    private SessionFacade sessionFacade;

    private FormationFacade formationFacade;
    private List<Formation> formations = new ArrayList<>();
    private List<ChoiceBox<String>> listeChoiceBoxFormations = new ArrayList<>();

    Map<String, Integer> formationMap = new HashMap<>();;

    private List<TypePaiement> typePaiements = new ArrayList<>();
    private List<ChoiceBox<String>> listeChoiceBoxPaiements = new ArrayList<>();
    Map<String, Integer> typePaiementMap = new HashMap<>();



    @FXML
    void addSession(ActionEvent event) throws IOException {
        int authorId = UserFacade.getInstance().getUser().getId();
        String nomSession = nom.getText();
        String descriptionSession = description.getText();
        int prixSession = Integer.parseInt(prix.getText());
        int nbPlacesMaxSession = Integer.parseInt(nbPlacesMax.getText());
        String lieuSession = lieu.getText();
        String dateSession = date.getText();

        List<Formation> formations = new ArrayList<>();
        for (ChoiceBox<String> choiceBox : listeChoiceBoxFormations) {
            String formationSelected = choiceBox.getValue();
            int formationId = formationMap.getOrDefault(formationSelected, -1);
            Formation formation = FormationFacade.getInstance().getFormationById(formationId);
            formations.add(formation);
        }

        List<TypePaiement> typePaiements = new ArrayList<>();
        for (ChoiceBox<String> choiceBox : listeChoiceBoxPaiements) {
            String typePaiementSelected = choiceBox.getValue();
            int typePaiementId = typePaiementMap.getOrDefault(typePaiementSelected, -1);
            TypePaiement tp = TypePaiementFacade.getInstance().getTypePaiementById(typePaiementId);
            typePaiements.add(tp);
        }

        SessionFacade sessionFacade = SessionFacade.getInstance();
        Session sessionAdded = sessionFacade.addSession(authorId, nomSession, descriptionSession, formations,
                prixSession, typePaiements, nbPlacesMaxSession, lieuSession, dateSession);

        if (sessionAdded != null) {
            System.out.println("Session bien ajouté !");
            Main m = new Main();
            m.changeScene("listSession-view.fxml");
        } else {
            System.out.println("aucune session n'a été ajoutée");
        }
    }

    @FXML
    void retourAccueil(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("listSession-view.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.formationFacade = FormationFacade.getInstance();
        this.formations = formationFacade.getAllFormation();
        this.typePaiements = TypePaiementFacade.getInstance().getAllTypePaiement();

        for (Formation formation : formations) {
            if (formation != null) {
                formationMap.put(formation.getNom(), formation.getId());
            }
        }

        for (TypePaiement typePaiement : typePaiements) {
            if (typePaiement != null) {
                typePaiementMap.put(typePaiement.getNom(), typePaiement.getId());
            }
        }

        listeChoiceBoxFormations.addAll(
                List.of(choixForm1, choixForm2, choixForm3)
        );

        for (ChoiceBox<String> choiceBox : listeChoiceBoxFormations) {
            choiceBox.getItems().addAll(
                    formations.stream()
                            .map(Formation::getNom)
                            .toList()
            );

            // Écouteur pour gérer la sélection d'une formation dans une ChoiceBox
            choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue != null) {
                    for (ChoiceBox<String> cb : listeChoiceBoxFormations) {
                        if (!cb.equals(choiceBox)) {
                            cb.getItems().remove(newValue);
                        }
                    }
                }
            });

            listeChoiceBoxPaiements.addAll(
                    List.of(choixTPa1, choixTPa2, choixTPa3)
            );

            for (ChoiceBox<String> cB : listeChoiceBoxPaiements) {
                // Création d'une liste temporaire pour les types de paiement restants
                List<String> remainingTypePaiements = new ArrayList<>();

                // Ajout des types de paiement restants qui n'ont pas été ajoutés à cette ChoiceBox
                for (TypePaiement tp : typePaiements) {
                    String nomTypePaiement = tp.getNom();
                    if (!cB.getItems().contains(nomTypePaiement)) {
                        remainingTypePaiements.add(nomTypePaiement);
                    }
                }

                // Ajout des types de paiement restants à cette ChoiceBox
                cB.getItems().addAll(remainingTypePaiements);

                // Écouteur pour gérer la sélection d'un type de paiement dans une ChoiceBox
                cB.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        for (ChoiceBox<String> cb : listeChoiceBoxPaiements) {
                            if (!cb.equals(cB)) {
                                cb.getItems().remove(newValue);
                            }
                        }
                    }
                });
            }
        }
    }
}
