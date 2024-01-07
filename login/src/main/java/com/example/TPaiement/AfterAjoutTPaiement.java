package com.example.TPaiement;

import com.example.TPaiementPackage.TypePaiementFacade;
import com.example.login.Main;
import com.example.TPPackage.TypePostFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
public class AfterAjoutTPaiement {
    @FXML
    private TextField nomInput;

    @FXML
    private TextField descriptionInput;

    @FXML
    private Button annulerbutton;
    @FXML
    private Button ajouterbutton;

    public void ajoutduPaiement(ActionEvent event) throws IOException {
        TypePaiementFacade.getInstance().addTypePaiement(nomInput.getText().toString(),descriptionInput.getText().toString());
        Main m = new Main();
        m.changeScene("TPaiement.fxml");
    }

    public void annulation(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("TPaiement.fxml");
    }
}
