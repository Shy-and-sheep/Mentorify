package com.example.TPaiement;

import com.example.TPaiementPackage.TypePaiement;
import com.example.TPaiementPackage.TypePaiementFacade;
import com.example.login.Main;
import com.example.TPPackage.TypePostFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class ModifierTPaiement implements Initializable {
    @FXML
    private TextField nomField;

    @FXML
    private TextField descriptionField;

    @FXML
    private Button annulerbutton;
    @FXML
    private Button ajouterbutton;

    private TypePostFacade typePostFacade;
    private int typePaiementId;

    public void initialize(URL arg0, ResourceBundle arg1) {
        TypePaiement currentTypePaiement = TypePaiementFacade.getInstance().getTypePaiement();
        if (currentTypePaiement != null) {
            typePaiementId = currentTypePaiement.getId();
            nomField.setText(currentTypePaiement.getNom());
            descriptionField.setText(currentTypePaiement.getDescription());
            System.out.println(typePaiementId + currentTypePaiement.getNom() + currentTypePaiement.getDescription());
        }
    }

    @FXML
    public void modifiertypePaiement(ActionEvent event) throws IOException {
        TypePaiementFacade.getInstance().setTypePaiement(typePaiementId, nomField.getText().toString(),descriptionField.getText().toString());
        //changement de scène
        Main m = new Main();
        m.changeScene("TPaiement.fxml");
    }

    @FXML
    public void annulationDeModification(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("TPaiement.fxml");
    }
}