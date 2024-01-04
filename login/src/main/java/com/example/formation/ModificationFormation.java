package com.example.formation;

import com.example.FormationPackage.Formation;
import com.example.FormationPackage.FormationFacade;
import com.example.LoginPackage.User;
import com.example.LoginPackage.UserFacade;
import com.example.TFPackage.TypeFormation;
import com.example.TFPackage.TypeFormationFacade;
import com.example.login.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class ModificationFormation implements Initializable {
    @FXML
    private TextField nomInput;

    @FXML
    private TextField descriptionInput;
    @FXML
    private TextField placesInput;

    @FXML
    private TextField prixInput;

    @FXML
    private ChoiceBox<String> TPChoiceBox;
    @FXML
    private ChoiceBox<String> TFChoiceBox;

    private UserFacade userFacade;

    private FormationFacade formationFacade;
    private TypeFormationFacade typeFormationFacade;
    private String[] tP = {"Chèque","Carte","Espèce"};
    private List<TypeFormation> tF;
    private int formationId;
    private String author;





    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        Formation formation = formationFacade.getInstance().getFormation();
        this.typeFormationFacade = TypeFormationFacade.getInstance();
        tF = typeFormationFacade.getAllTypeFormation();
        List<String> typeFormationNames = tF.stream().map(TypeFormation::getNom).collect(Collectors.toList());
        TFChoiceBox.getItems().addAll(typeFormationNames);
        TPChoiceBox.getItems().addAll(tP);

        if (formation != null) {
            author = formation.getAuthorName();
            formationId = formation.getId();
            nomInput.setText(formation.getNom());
            descriptionInput.setText(formation.getDescription());
            prixInput.setText(String.valueOf(formation.getPrix()));
            placesInput.setText(String.valueOf(formation.getNbPlacesMax()));
            TPChoiceBox.setValue(formation.getTypesPayment());
            TFChoiceBox.setValue(formation.getTypeFormation());


        } else {
            System.out.println("erreur lors de la récupération de la formation");
        }
    }
    public void modifierformation(ActionEvent event) throws IOException {
        FormationFacade.getInstance().setFormation(formationId,author,nomInput.getText().toString(),descriptionInput.getText().toString(),Double.parseDouble(prixInput.getText()),TPChoiceBox.getValue(),Integer.parseInt(placesInput.getText()),Integer.parseInt(placesInput.getText()),TFChoiceBox.getValue());
        Main m = new Main();
        m.changeScene("ViewFormation.fxml");
    }

    public void annulation(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("Formation-view.fxml");
    }




}
