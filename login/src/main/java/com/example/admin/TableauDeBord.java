package com.example.admin;


import com.example.LoginPackage.UserFacade;
import com.example.login.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


import java.io.IOException;

public class TableauDeBord {

    @FXML
    private Button typesDeFormationButton;

    @FXML
    private Label tabdebordlabel;

    private UserFacade userFacade;

    public void switchToTypeFormation(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("typeformation.fxml");;}
}

