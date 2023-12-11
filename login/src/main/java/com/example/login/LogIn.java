package com.example.login;
import com.example.LoginPackage.User;
import com.example.LoginPackage.UserFacade;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;
public class LogIn {

    public LogIn() {

    }

    @FXML
    private Button logbutton;
    @FXML
    private Label wrongLogin;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;


    private UserFacade userFacade;

    public void userLogIn(ActionEvent event) throws IOException {
        this.userFacade = UserFacade.getInstance();
        checkLogin();
    }

    /*private void checkLogin() {
        Main m = new Main();
        try {
            if(username.getText().isEmpty() && password.getText().isEmpty()) {
                wrongLogin.setText("Please enter your data.");
            }
            else {
                this.userFacade = UserFacade.getInstance();
                User user = userFacade.login(username.getText().toString(), password.getText().toString());
                if (user != null) {
                    System.out.println(user.getName());
                    System.out.println("le user : " + user.id + " " + user.username + " est bien connecté");
                    wrongLogin.setText("Success!");

                    /*FXMLLoader loader = new FXMLLoader(getClass().getResource("afterLogin.fxml"));
                    Parent root = loader.load();

                    //AfterLogin afterLoginController = loader.getController();
                    //afterLoginController.setUser(user);
                    AfterLogin afterLoginController = new AfterLogin();
                    afterLoginController.setUsername(user.username);


                    m.changeScene("afterLogin.fxml");
                } else if(username.getText().isEmpty() && password.getText().isEmpty()) {
                    wrongLogin.setText("Please enter your data.");
                } else {
                    wrongLogin.setText("Wrong username or password!");
                }
            }
        } catch (Exception e) {
            System.out.println("il y a une erreur");
            wrongLogin.setText("Wrong username or password!");
        }
    }*/
    private void checkLogin() {
        Main m = new Main();
        try {
            if(username.getText().isEmpty() && password.getText().isEmpty()) {
                wrongLogin.setText("Please enter your data.");
            }
            else {
                this.userFacade = UserFacade.getInstance();
                User user = userFacade.login(username.getText().toString(), password.getText().toString());
                if (user != null) {
                    System.out.println(user.getName());
                    System.out.println("le user : " + user.id + " " + user.username + " est bien connecté");
                    wrongLogin.setText("Success!");

                    m.changeScene("afterLogin.fxml");
                } else {
                    wrongLogin.setText("Wrong username or password!");
                }
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
            wrongLogin.setText("An error occurred!");
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            wrongLogin.setText("An error occurred!");
        }
    }

}