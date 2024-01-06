package com.example.Register;

import com.example.UserPackage.User;
import com.example.UserPackage.UserFacade;
import com.example.login.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
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
            showError("Tous les champs sont requis.");
            return;
        }

        // Si la validation est correcte, enregistre les informations dans la base de données
        // Sinon, affiche un message d'erreur approprié
        // Appel de la méthode Register de UserFacade
        User newUser = userFacade.Register(firstName, lastName, email, status, password,userName);

        if (newUser != null) {
            // Utilisateur créé avec succès
            showSuccess("Utilisateur créé avec succès.");
        } else {
            // Affiche un message d'erreur
            showError("L'inscription a échoué. Veuillez réessayer.");
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

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur de format de champs");
        alert.setHeaderText(null); // Pas de titre de l'en-tête
        alert.setContentText(message);

        alert.showAndWait();
    }

    private void showSuccess(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Succès");
        alert.setHeaderText(null); // Pas de titre de l'en-tête
        alert.setContentText(message);

        alert.showAndWait();
    }

}

