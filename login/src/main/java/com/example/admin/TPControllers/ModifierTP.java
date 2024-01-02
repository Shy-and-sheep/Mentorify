package com.example.admin.TPControllers;

import com.example.login.Main;
import com.example.TPPackage.TypePost;
import com.example.TPPackage.TypePostFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class ModifierTP implements Initializable {
    @FXML
    private TextField nomField;

    @FXML
    private TextField descriptionField;

    @FXML
    private Button annulerbutton;
    @FXML
    private Button ajouterbutton;

    private TypePostFacade typePostFacade;
    private int typePostId;

    public void initialize(URL arg0, ResourceBundle arg1) {
        TypePost currentTypePost = TypePostFacade.getInstance().getTypePost();
        if (currentTypePost != null) {
            typePostId = currentTypePost.getId();
            nomField.setText(currentTypePost.getNom());
            descriptionField.setText(currentTypePost.getDescription());
            System.out.println(typePostId + currentTypePost.getNom() + currentTypePost.getDescription());
        }
    }

    public void modifiertypePost(ActionEvent event) throws IOException {
        TypePostFacade.getInstance().setTypePost(typePostId, nomField.getText().toString(),descriptionField.getText().toString());
        //changement de scène
        Main m = new Main();
        m.changeScene("TP-view.fxml");
    }

    public void annulationDeModification(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("TP-view.fxml");
    }
}