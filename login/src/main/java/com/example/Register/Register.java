package com.example.Register;

import com.example.UserPackage.User;
import com.example.UserPackage.UserFacade;
import com.example.login.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class Register {

    private UserFacade userFacade;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField statusField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField usernameField ;

    @FXML
    private Label messageLabel;


    public Register() {
        this.userFacade = UserFacade.getInstance(); // Obtention de l'instance de UserFacade
    }
    @FXML
    protected void onRegisterButtonClick() { //Méthode pour la logique du bouton valider
        // Récupère les valeurs des champs
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String userName = usernameField.getText();
        String email = emailField.getText();
        String status = statusField.getText();
        String password = passwordField.getText();

        // Valider les champs ici (vérifier qu'ils ne sont pas vides, format de l'email, etc.)
        if (firstName.isEmpty() || lastName.isEmpty() || userName.isEmpty() || email.isEmpty() || status.isEmpty() || password.isEmpty()) {
            // Affiche un message d'erreur
            messageLabel.setTextFill(Color.RED);
            messageLabel.setText("Tous les champs sont requis.");
            return;
        }

        // Si la validation est correcte, enregistre les informations dans la base de données
        // Sinon, affiche un message d'erreur approprié
        // Appel de la méthode Register de UserFacade
        User newUser = userFacade.Register(lastName, firstName, userName, password, email, status);

        if (newUser != null) {
            // Utilisateur créé avec succès
            messageLabel.setTextFill(Color.GREEN);
            messageLabel.setText("Utilisateur créé avec succès.");
        } else {
            // Affiche un message d'erreur
            messageLabel.setTextFill(Color.RED);
            messageLabel.setText("L'inscription a échoué. Veuillez réessayer.");
        }

    }

    @FXML
    protected void onCancelButtonClick() { //Méthode pour la logique du bouton annuler
        // Pour annuler, on peut vider tous les champs
        firstNameField.clear();
        lastNameField.clear();
        emailField.clear();
        statusField.clear();
        passwordField.clear();

        /*
        Main m = new Main();
        try {
            m.changeScene("LogIn-view.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
         */
        // Ou sinon, on peut fermer la fenêtre d'inscription
        // Stage stage = (Stage) firstNameField.getScene().getWindow();
        // stage.close();
    }
    @FXML
    private void userRegister(ActionEvent event) {
        // Logique pour gérer l'enregistrement de l'utilisateur
        // Main.changeScene("Register-view.fxml"); //y a erreur ici
    }
    @FXML
    private void handleLoginLinkAction(ActionEvent event) {
        // code pour changer de scène, par exemple retourner à l'écran de connexion
        Main m = new Main();
        try {
            m.changeScene("LogIn-view.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

