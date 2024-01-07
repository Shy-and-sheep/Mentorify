package com.example.TPaiement;

import com.example.TPPackage.TypePost;
import com.example.TPPackage.TypePostFacade;
import com.example.TPaiementPackage.TypePaiement;
import com.example.TPaiementPackage.TypePaiementFacade;
import com.example.login.Main;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class TPaiement implements Initializable {

    // Ici, ajouter les annotations @FXML pour les éléments d'interface définis dans mon fichier FXML.
    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> typeColumn;

    @FXML
    private TableColumn<?, ?> editColumn;

    @FXML
    private TableColumn<?, ?> deleteColumn;

    @FXML
    private TableView<TypePaiement> listPaiement = new TableView<>();

    private TypePaiementFacade typePaiementFacade;

    private List<TypePaiement> typePaiementList = new ArrayList<TypePaiement>();

    private Map<String, String> typePaiementMap = new HashMap<>();

    public void initialize(URL arg0, ResourceBundle arg1) {
        this.typePaiementFacade = TypePaiementFacade.getInstance();
        typePaiementList = typePaiementFacade.getAllTypePaiement();

        TableColumn<TypePaiement, String> nomPaiement = new TableColumn<>("Nom");
        nomPaiement.setCellValueFactory(new PropertyValueFactory<>("nom"));

        listPaiement.getColumns().setAll(nomPaiement);

        listPaiement.getItems().addAll(typePaiementList);

        addModifierButtonToTable();
        addSupprimerButtonToTable();
        //List<String> typePaiementNom = typePaiementList.stream().map(TypePaiement::getNom).collect(Collectors.toList());
        //listPaiement.getItems().addAll(typePaiementNom);
    }

    private void addModifierButtonToTable() {
        TableColumn<TypePaiement, Void> colBtn = new TableColumn("Modifier");

        Callback<TableColumn<TypePaiement, Void>, TableCell<TypePaiement, Void>> cellFactory = new Callback<TableColumn<TypePaiement, Void>, TableCell<TypePaiement, Void>>() {
            @Override
            public TableCell<TypePaiement, Void> call(final TableColumn<TypePaiement, Void> param) {
                final TableCell<TypePaiement, Void> cell = new TableCell<TypePaiement, Void>() {

                    private final Button btn = new Button("Modifier");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            // TODO : Changer de view ici
                            TypePaiement typePaiment = getTableView().getItems().get(getIndex());
                            System.out.println("selectedData: " + typePaiment.getNom());
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

        colBtn.setCellFactory(cellFactory);

        listPaiement.getColumns().add(colBtn);

    }

    private void addSupprimerButtonToTable() {
        TableColumn<TypePaiement, Void> colBtn = new TableColumn("Supprimer");

        Callback<TableColumn<TypePaiement, Void>, TableCell<TypePaiement, Void>> cellFactory = new Callback<TableColumn<TypePaiement, Void>, TableCell<TypePaiement, Void>>() {
            @Override
            public TableCell<TypePaiement, Void> call(final TableColumn<TypePaiement, Void> param) {
                final TableCell<TypePaiement, Void> cell = new TableCell<TypePaiement, Void>() {

                    private final Button btn = new Button("Supprimer");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            // TODO : Supprimer l'element courant ici
                            TypePaiement typePaiment = getTableView().getItems().get(getIndex());
                            System.out.println("selectedData: " + typePaiment.getNom());
                            TypePaiementFacade typePaiementFacade = TypePaiementFacade.getInstance();
                            typePaiementFacade.removeTypePaiement(typePaiment.getId());
                            getTableView().getItems().remove(getIndex());
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

        colBtn.setCellFactory(cellFactory);

        listPaiement.getColumns().add(colBtn);

    }

    // Méthodes pour les événements
    @FXML
    private void handleRetour(ActionEvent event) {
        // Logique pour le bouton Retour
    }

    @FXML
    private void handleAjouter(ActionEvent event) {
        // code pour changer de scène
        Main m = new Main();
        try {
            m.changeScene("afterAjoutTPaiement.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    private void handleRetourLinkAction(ActionEvent event) {
        // code pour changer de scène
        Main m = new Main();
        try {
            m.changeScene("tableauDeBord.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
