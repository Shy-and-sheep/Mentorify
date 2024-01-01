package com.example.admin;

import com.example.LoginPackage.UserFacade;
import com.example.login.Main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;


import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
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

    private String[] tabTypeFormation = {"Software","Cuisine","Data","Management","Chant"};
    private String[] tabTypeDescription = {"Description du logiciel", "Description de la cuisine", "Description des données", "Description du management", "Description du chant",};

    private String currentTypeFormation;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        listetypeformation.getItems().addAll(tabTypeFormation);

        // Remplir la map avec les noms des types de formation et leurs descriptions
        for (int i = 0; i < tabTypeFormation.length; i++) {
            typeFormationMap.put(tabTypeFormation[i], tabTypeDescription[i]);
        }

        listetypeformation.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                currentTypeFormation = listetypeformation.getSelectionModel().getSelectedItem();
                typeformationname.setText(currentTypeFormation);
                updateDescription();

            }
        });
    }
    private void updateDescription() {
        String description = typeFormationMap.get(currentTypeFormation);
        if (description != null) {
            descriptionLabel.setText(description);
        } else {
            descriptionLabel.setText("Description non disponible");
        }
    }

    public void ajoutTypeFormation(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("ajoutTypeFormation.fxml");
    }
    public void modifyTypeFormation(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("modifierTypeFormation.fxml");
    }

    public void receptionNouvelleFormation(String nom, String description) {
        listetypeformation.getItems().add(nom);
        typeFormationMap.put(nom, description);
        //TO DO récupère le type formation dans la façade et l'ajoute à la liste
    }

}
