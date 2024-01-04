package com.example.TPaiementPackage;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

public class TPaiement {

    // Ici, ajouter les annotations @FXML pour les éléments d'interface définis dans mon fichier FXML.
    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> typeColumn;

    @FXML
    private TableColumn<?, ?> editColumn;

    @FXML
    private TableColumn<?, ?> deleteColumn;

    // Méthodes pour les événements
    @FXML
    private void handleRetour(ActionEvent event) {
        // Logique pour le bouton Retour
    }

    @FXML
    private void handleAjouter(ActionEvent event) {
        // Logique pour le bouton Ajouter
    }


}
