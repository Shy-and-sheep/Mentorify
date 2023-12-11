package com.example.login;

import com.example.LoginPackage.User;
import com.example.LoginPackage.UserFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import java.io.IOException;

public class AfterLogin {

    @FXML
    private Button logout;

    @FXML
    private Label welcomeLabel;

    private UserFacade userFacade;


    public void initialize() {
        displayWelcomeMessage();
    }

    private void displayWelcomeMessage() {
        User currentUser = userFacade.getInstance().getUser();
        if (currentUser != null) {
            String name = currentUser.getName();
            welcomeLabel.setText("Hello " + name + "!");
        }
    }

    public void userLogOut(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("LogIn-view.fxml");
    }
}
