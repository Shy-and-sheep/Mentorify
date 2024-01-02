package com.example.admin;

import com.example.TFPackage.TypeFormationFacade;
import com.example.TFPackage.TypeFormation;

import com.example.login.Main;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;


import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javafx.scene.control.Button;


public class Typeformation implements Initializable {
    @FXML
    private ListView<String> listetypeformation;
    @FXML
    private Label titre;
    @FXML
    private Label typeformationname;
    @FXML
    private Label descriptionLabel;
    @FXML
    private Button modifierbutton;
    @FXML
    private Button supprimerboutton;
    @FXML
    private Button ajouterbutton;
    private Map<String, String> typeFormationMap = new HashMap<>();
    private List<TypeFormation> tabTypeFormation;
    private String[] tabTypeDescription;
    private TypeFormation currentTypeFormation;

    private TypeFormationFacade typeFormationFacade;


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        this.typeFormationFacade = TypeFormationFacade.getInstance();
        tabTypeFormation = typeFormationFacade.getAllTypeFormation();

        List<String> typeFormationNom = tabTypeFormation.stream().map(TypeFormation::getNom).collect(Collectors.toList());
        listetypeformation.getItems().addAll(typeFormationNom);

        for (TypeFormation formation : tabTypeFormation) {
            typeFormationMap.put(formation.getNom(), formation.getDescription());
        }

        listetypeformation.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            currentTypeFormation = tabTypeFormation.stream()
                    .filter(formation -> formation.getNom().equals(newValue))
                    .findFirst()
                    .orElse(null);

            if (currentTypeFormation != null) {
                this.typeFormationFacade.getTypeFormationById(currentTypeFormation.getId());
                typeformationname.setText(currentTypeFormation.getNom());
                updateDescription();
            }
        });
    }
    private void updateDescription() {
        if (currentTypeFormation != null) {
            String description = currentTypeFormation.getDescription();

            if (description != null && !description.isEmpty()) {
                descriptionLabel.setText(description);
            } else {
                descriptionLabel.setText("Description non disponible");
            }
        }
    }


    public void addTypeFormation(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("ajoutTypeFormation.fxml");
    }
    public void setTypeFormation(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("modifierTypeFormation.fxml");
    }

    public void removeTypeFormation(ActionEvent event) {
        if (currentTypeFormation != null) {
            int typeId = currentTypeFormation.getId();
            System.out.println(typeId);

            typeFormationFacade.removeTypeFormation(typeId);

            // Mise à jour de la liste des types de formation après la suppression
            tabTypeFormation = typeFormationFacade.getAllTypeFormation();
            List<String> typeFormationNom = tabTypeFormation.stream().map(TypeFormation::getNom).collect(Collectors.toList());

            // Effacez les labels
            typeformationname.setText("");
            descriptionLabel.setText("");

            // Mettre à jour la ListView avec les nouvelles données
            listetypeformation.getItems().clear();
            listetypeformation.getItems().addAll(typeFormationNom);

        } else {
            System.out.println("Veuillez sélectionner un type de formation à supprimer.");
        }
    }


    public TypeFormation getTypeFormtionById(int id) {
        return typeFormationFacade.getTypeFormationById(id);
    }

}
