package com.example.admin;

import com.example.TFPackage.TypeFormationFacade;
import com.example.login.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


import java.io.IOException;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class AjoutTypeFormation {
    @FXML
    private TextField nomInput;

    @FXML
    private TextField descriptionInput;

    @FXML
    private Button annulerbutton;
    @FXML
    private Button ajouterbutton;

    public void ajoutdelaformation(ActionEvent event) throws IOException {
        TypeFormationFacade.getInstance().addTypeFormation(nomInput.getText().toString(),descriptionInput.getText().toString());
        Main m = new Main();
        m.changeScene("typeformation.fxml");
    }

    public void annulation(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("typeformation.fxml");
    }
}
