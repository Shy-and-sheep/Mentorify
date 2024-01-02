package com.example.admin;

import com.example.TFPackage.TypeFormation;
import com.example.TFPackage.TypeFormationFacade;
import com.example.login.Main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;


import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import com.example.login.Main;



public class ModifierTypeFormation {
    @FXML
    private TextField nomField;

    @FXML
    private TextField descriptionField;

    @FXML
    private Button annulerbutton;
    @FXML
    private Button ajouterbutton;

    private TypeFormationFacade typeFormationFacade;
    private int typeFormationId;

    public void initialize() {
        TypeFormation currentTypeFormation = TypeFormationFacade.getInstance().getTypeFormation();
        if (currentTypeFormation != null) {
            typeFormationId = currentTypeFormation.getId();
            nomField.setText(currentTypeFormation.getNom());
            descriptionField.setText(currentTypeFormation.getDescription());
            System.out.println(typeFormationId + currentTypeFormation.getNom() + currentTypeFormation.getDescription());
        }
    }

    public void modifiertypeformation(ActionEvent event) throws IOException {
        TypeFormationFacade.getInstance().setTypeFormation(typeFormationId, nomField.getText().toString(),descriptionField.getText().toString());
        //changement de scène
        Main m = new Main();
        m.changeScene("typeformation.fxml");
    }

    public void annulationDeModification(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("typeformation.fxml");
    }
}