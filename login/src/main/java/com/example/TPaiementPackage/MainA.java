package com.example.TPaiementPackage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;



/**
 public class Main TPaiment extends Application {

 public static void main(String[] args) {
 launch(args);
 }

 @Override
 public void start(Stage primaryStage) throws Exception {
 Parent root = FXMLLoader.load(getClass().getResource("TPaiement.fxml"));
 primaryStage.setTitle("Gestion des Types de Paiement");
 primaryStage.setScene(new Scene(root));
 primaryStage.show();
 }
 }
 */

public class MainA extends Application{
    private static Stage stg;

    @Override
    public void start(Stage stage) throws IOException {
        stg = stage;
        stage.setResizable(false);
        // Change ici pour ton fichier FXML initial.
        var test = getClass().getResource("TPaiement.fxml");
        Parent root = FXMLLoader.load(test);
        stage.setTitle("Mentorify");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    public static void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(MainA.class.getResource(fxml));
        stg.getScene().setRoot(pane);
    }

    public static void main(String[] args) {
        launch();
    }
}
