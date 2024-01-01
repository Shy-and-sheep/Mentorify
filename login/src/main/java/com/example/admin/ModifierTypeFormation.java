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

    public void modifiertypeformation(ActionEvent event) throws IOException {
        // TO DO : récupère les infos du type de formation pour préremplir les input
        // TO DO : modifie le type de formation dans la façade
        Main m = new Main();
        m.changeScene("typeformation.fxml");
    }

    public void annulationDeModification(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("typeformation.fxml");
    }
}