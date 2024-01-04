package com.example.formation;

import com.example.FormationPackage.Formation;
import com.example.FormationPackage.FormationFacade;
import com.example.LoginPackage.UserFacade;
import com.example.LoginPackage.User;


import com.example.TFPackage.TypeFormation;
import com.example.TFPackage.TypeFormationFacade;
import com.example.login.Main;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class AddFormation implements Initializable {
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


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        this.formationFacade = FormationFacade.getInstance();
        this.typeFormationFacade = TypeFormationFacade.getInstance();
        tF = typeFormationFacade.getAllTypeFormation();
        List<String> typeFormationNames = tF.stream().map(TypeFormation::getNom).collect(Collectors.toList());
        TFChoiceBox.getItems().addAll(typeFormationNames);
        TPChoiceBox.getItems().addAll(tP);
    }
    public void ajoutdelaformation(ActionEvent event) throws IOException {
        User currentUser = userFacade.getInstance().getUser();
        double prix = Double.parseDouble(prixInput.getText());
        // TODO : ajouter la connextion à typepayment pour récupérer le nom du typepayment à partir de l'id
        String typespayment = TPChoiceBox.getValue();
        int nbPlacesMax = Integer.parseInt(placesInput.getText());
        String typeFormationName =TFChoiceBox.getValue();

        List<TypeFormation> typeFormations= typeFormationFacade.getInstance().getAllTypeFormation();

        formationFacade.getInstance().addFormation(currentUser.getUsername(), nomInput.getText().toString(),descriptionInput.getText().toString(),prix,typespayment,nbPlacesMax,nbPlacesMax,typeFormationName);
        Main m = new Main();
        m.changeScene("Formation-view.fxml");
    }

    public void annulation(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("Formation-view.fxml");
    }


}
