package com.example.formation;

import com.example.FormationPackage.FormationFacade;
import com.example.FormationPackage.Formation;

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

public class FormationController implements Initializable {

    /**
     * Default constructor
     */
    public FormationController() {
    }
    @FXML
    private Button retour;
    @FXML
    private Button viewbutton;

    @FXML
    private Label formationname;
    @FXML
    private Label descriptionLabel;
    @FXML
    private Label prixLabel;
    @FXML
    private Label placeLabel;

    private FormationFacade formationFacade;
    @FXML
    private ListView<String> listFormations;
    private Formation currentFormation;
    private List<Formation> tabFormation;


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        this.formationFacade = FormationFacade.getInstance();
        tabFormation = formationFacade.getAllFormation();

        List<String> formationNom = tabFormation.stream().map(Formation::getNom).collect(Collectors.toList());
        listFormations.getItems().addAll(formationNom);

        if (!tabFormation.isEmpty()) {
            currentFormation = tabFormation.get(0); // Sélectionne la première formation par défaut

            formationname.setText(currentFormation.getNom());
            descriptionLabel.setText(currentFormation.getDescription());
            prixLabel.setText(currentFormation.getPrix() + " €");
            placeLabel.setText((currentFormation.getNbPlacesMax() - currentFormation.getNbPlacesDispo()) + "/" + currentFormation.getNbPlacesMax());
        }

        listFormations.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            currentFormation = tabFormation.stream()
                    .filter(formation -> formation.getNom().equals(newValue))
                    .findFirst()
                    .orElse(null);

            if (currentFormation != null) {
                this.formationFacade.getFormationById(currentFormation.getId());
                formationname.setText(currentFormation.getNom());
                descriptionLabel.setText(currentFormation.getDescription());
                prixLabel.setText(currentFormation.getPrix() + " €");
                placeLabel.setText((currentFormation.getNbPlacesMax() - currentFormation.getNbPlacesDispo()) + "/" + currentFormation.getNbPlacesMax());
            }
        });
    }


    public void setFormation(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("ModificationFormation.fxml");
    }

    public void removeFormation(ActionEvent event) {
        if (currentFormation != null) {
            int typeId = currentFormation.getId();

            formationFacade.removeFormation(typeId);

            // Mise à jour de la liste des types de formation après la suppression
            tabFormation = formationFacade.getAllFormation();
            List<String> formationNom = tabFormation.stream().map(Formation::getNom).collect(Collectors.toList());

            // Effacez les labels
            formationname.setText("");
            descriptionLabel.setText("");
            prixLabel.setText("");
            placeLabel.setText("");


            // Mettre à jour la ListView avec les nouvelles données
            listFormations.getItems().clear();
            listFormations.getItems().addAll(formationNom);

        } else {
            System.out.println("Veuillez sélectionner un type de formation à supprimer.");
        }
    }

    public void viewFormation(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("ViewFormation.fxml");
    }
    public void ajouterFormation(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("addFormation.fxml");
    }

    public void backToAfterLogin(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("afterLogin.fxml");
    }

}
