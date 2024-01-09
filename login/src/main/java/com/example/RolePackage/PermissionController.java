package com.example.RolePackage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

import com.example.RolePackage.Permission;
import com.example.TFPackage.TypeFormation;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/**
 * 
 */
public class PermissionController implements Initializable{
	
	@FXML
	private ListView<String> listPermission;
	
	@FXML
    private Label descriptionLabel;
	
	@FXML
    private Label permissionlibelle;

    public PermissionController() {}

    private Map<String, String> PermissionMap = new HashMap<>();
    private List<Permission> tabPermission;
    private String[] tabPermissionDescription;
    private Permission currentPermission;

    private PermissionFacade permissionFacade;

    public void CreatePermission(ActionEvent event) throws IOException {
        // TODO implement here
    }

    private Permission setPermission(String libelle, String description, Role[] roles) {
        // TODO implement here
        return null;
    }

    public void removePermission(ActionEvent event) {
    	if (currentPermission != null) {
            int typeId = currentPermission.getIdP();
            System.out.println(typeId);

            permissionFacade.removePermission(typeId);

            // Mise à jour de la liste des types de formation après la suppression
            tabPermission = permissionFacade.getAllPermission();
            List<String> typeFormationNom = tabPermission.stream().map(Permission::getLibelle).collect(Collectors.toList());

            // Effacez les labels
            permissionlibelle.setText("");
            descriptionLabel.setText("");

            // Mettre à jour la ListView avec les nouvelles données
            listPermission.getItems().clear();
            listPermission.getItems().addAll(typeFormationNom);

        } else {
            System.out.println("Veuillez sélectionner une permission à supprimer.");
        }    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.permissionFacade = PermissionFacade.getInstance();
        tabPermission = permissionFacade.getAllPermission();

        List<String> permissionLibelle = tabPermission.stream().map(Permission::getLibelle).collect(Collectors.toList());
        listPermission.getItems().addAll(permissionLibelle);
        for (Permission permission : tabPermission) {
        	PermissionMap.put(permission.getLibelle(), permission.getDescription());
        }

        listPermission.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                currentPermission = tabPermission.stream()
                        .filter(permission -> permission.getLibelle().equals(newValue))
                        .findFirst()
                        .orElse(null);

                if (currentPermission != null) {
                        this.permissionFacade.getPermissionById(currentPermission.getIdP());
                        permissionlibelle.setText(currentPermission.getLibelle());
                        updateDescription();
                }

        });
	}
	
	private void updateDescription() {
        if (currentPermission != null) {
                String description = currentPermission.getDescription();

                if (description != null && !description.isEmpty()) {
                        descriptionLabel.setText(description);
                } else {
                        descriptionLabel.setText("Description non disponible");
                }
        }
}

}