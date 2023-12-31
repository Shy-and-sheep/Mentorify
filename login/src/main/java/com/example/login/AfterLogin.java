package com.example.login;

import com.example.UserPackage.User;
import com.example.UserPackage.UserFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class AfterLogin {

    @FXML
    private Button logout;

    @FXML
    private Label welcomeLabel;

    @FXML
    private Button tableaudebord;

    @FXML
    private Button formationbutton;

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
        m.changeScene("Login-view.fxml");;
    }

    public void adminTabDeBord(ActionEvent event) throws IOException {
        Main m = new Main();

        m.changeScene("tableauDeBord.fxml");
    }

    public void goToFormation(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("Formation-view.fxml");;}


    public void switchListPost(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("ListPost-view.fxml");
    }

    public void switchListSessions(ActionEvent actionEvent) throws IOException {
        Main m = new Main();
        m.changeScene("listSession-view.fxml");
    }
}
