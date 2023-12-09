package com.example.login;

import com.example.LoginPackage.User;
import com.example.LoginPackage.UserFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class AfterLogin {

    @FXML
    private Button logout;


    public void userLogOut(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("LogIn-view.fxml");

    }


}
