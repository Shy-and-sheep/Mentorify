package com.example.Register;


import com.example.login.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Register {

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
    protected void onRegisterButtonClick() { //Méthode pour la logique du bouton valider
        // Récupère les valeurs des champs
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String email = emailField.getText();
        String status = statusField.getText();
        String password = passwordField.getText();

        // Valider les champs ici (vérifier qu'ils ne sont pas vides, format de l'email, etc.)

        // Si la validation est correcte, enregistre les informations dans la base de données
        // Sinon, affiche un message d'erreur approprié
    }

    @FXML
    protected void onCancelButtonClick() { //Méthode pour la logique du bouton annuler
        // Pour annuler, on peut vider tous les champs
        firstNameField.clear();
        lastNameField.clear();
        emailField.clear();
        statusField.clear();
        passwordField.clear();

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

