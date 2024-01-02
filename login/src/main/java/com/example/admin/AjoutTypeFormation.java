package com.example.admin;

import com.example.LoginPackage.UserFacade;
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
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import com.example.login.Main;



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
