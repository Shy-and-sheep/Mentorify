package com.example.RegisterPackage;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class mainB extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Remplacez 'Register.fxml' avec le chemin correct vers votre fichier FXML
            Parent root = FXMLLoader.load(getClass().getResource("Register.fxml"));

            Scene scene = new Scene(root);

            primaryStage.setTitle("Inscription");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
