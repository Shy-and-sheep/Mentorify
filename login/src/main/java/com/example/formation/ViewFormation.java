package com.example.formation;

import com.example.FormationPackage.Formation;
import com.example.FormationPackage.FormationFacade;
import com.example.UserPackage.UserFacade;
import com.example.login.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewFormation implements Initializable{
    @FXML
    private Label formationName;
    @FXML
    private Label userName;
    @FXML
    private Label descriptionLabel;
    @FXML
    private Label typeFormationLabel;
    @FXML
    private Label placeLabel;
    @FXML
    private Label typepaiementInput;
    @FXML
    private Label prixInput;

    @FXML
    private Label inscription2Label;
    private UserFacade userFacade;

    private FormationFacade formationFacade;

    Formation formation;

    /**
     * Default constructor
     */
    public ViewFormation() {
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        this.formation = formationFacade.getInstance().getFormation();
        if (formation != null) {
            formationName.setText(formation.getNom());
            userName.setText(formation.getAuthorName());
            descriptionLabel.setText(formation.getDescription());
            typeFormationLabel.setText(formation.getTypeFormation());
            placeLabel.setText((formation.getNbPlacesMax() - formation.getNbPlacesDispo()) + "/" + formation.getNbPlacesMax());
            typepaiementInput.setText(formation.getTypesPayment());
            prixInput.setText(String.valueOf(formation.getPrix()));
        } else {
            System.out.println("erreur lors de la récupération de la formation");
        }
    }
    public void retour(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("Formation-view.fxml");
    }
    public void inscription(ActionEvent event) throws IOException {
        int userId = userFacade.getInstance().getUser().getId();
        int formationId = formationFacade.getInstance().getFormation().getId();
        formationFacade.getInstance().inscriptionFormation(userId,formationId);
        inscription2Label.setText("Inscription validée !");
        this.formation = FormationFacade.getInstance().getFormationById(formationId);
        placeLabel.setText((formation.getNbPlacesMax() - formation.getNbPlacesDispo()) + "/" + formation.getNbPlacesMax());


    }

    public void desinscription(ActionEvent event) throws IOException {
        int userId = userFacade.getInstance().getUser().getId();
        int formationId = formationFacade.getInstance().getFormation().getId();
        formationFacade.getInstance().desinscriptionFormation(userId,formationId);
        inscription2Label.setText("Inscription annulée !");
        this.formation = FormationFacade.getInstance().getFormationById(formationId);
        placeLabel.setText((formation.getNbPlacesMax() - formation.getNbPlacesDispo()) + "/" + formation.getNbPlacesMax());


    }
    public void goToComments(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("Commentaire-viem.fxml");
    }

}
