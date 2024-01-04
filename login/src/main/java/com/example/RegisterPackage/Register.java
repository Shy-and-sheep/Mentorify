package com.example.RegisterPackage;


import javafx.fxml.FXML;
import javafx.scene.control.TextField;

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
    protected void onRegisterButtonClick() {
        // Implémentation de la logique d'inscription
        // Valider les champs et les enregistrer dans la base de données
    }

    @FXML
    protected void onCancelButtonClick() {
        // Implémentation de la logique d'annulation
        // Peut-être vider les champs ou fermer la fenêtre
    }
}

