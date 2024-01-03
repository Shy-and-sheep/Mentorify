package com.example.admin.TPControllers;

import com.example.login.Main;
import com.example.TPPackage.TypePost;
import com.example.TPPackage.TypePostFacade;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class TypePostControllers implements Initializable {
        @FXML
        private Button ajoutBtn;

        @FXML
        private AnchorPane divTitre;

        @FXML
        private ListView<String> listPub;

        @FXML
        private Button modifBtn;

        @FXML
        private Label typepostnom;

        @FXML
        private AnchorPane pubBtn;

        @FXML
        private Button retourBtn;

        @FXML
        private Button supprimeBtn;

        @FXML
        private Label titre;

        @FXML
        private BorderPane typePubPage;

        private Map<String, String> typePostMap = new HashMap<>();
        private List<TypePost> tabTypePost;
        private String[] tabTypeDescription;
        private TypePost currentTypePost;

        private TypePostFacade typePostFacade;

        public void initialize(URL arg0, ResourceBundle arg1) {
                this.typePostFacade = TypePostFacade.getInstance();
                tabTypePost = typePostFacade.getAllTypePost();

                List<String> typePostNom = tabTypePost.stream().map(TypePost::getNom).collect(Collectors.toList());
                listPub.getItems().addAll(typePostNom);
                System.out.println("**************************");
                for (TypePost post : tabTypePost) {
                        typePostMap.put(post.getNom(), post.getDescription());

                        System.out.println(post.getNom());
                }

                listPub.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                        currentTypePost = tabTypePost.stream()
                                .filter(post -> post.getNom().equals(newValue))
                                .findFirst()
                                .orElse(null);

                        if (currentTypePost != null) {
                                this.typePostFacade.getTypePostById(currentTypePost.getId());
                                typepostnom.setText(currentTypePost.getNom());
                        }
                });
        }

        public void setTypPost(ActionEvent event) throws IOException {
                Main m = new Main();
                m.changeScene("ModifierTP-view.fxml");
        }

        public void removeTypePost(ActionEvent event) {
                if (currentTypePost != null) {
                        int typeId = currentTypePost.getId();
                        System.out.println(typeId);

                        typePostFacade.removeTypePost(typeId);

                        // Mise à jour de la liste des types de Post après la suppression
                        tabTypePost = typePostFacade.getAllTypePost();
                        List<String> typePostNom = tabTypePost.stream().map(TypePost::getNom).collect(Collectors.toList());

                        // Effacez les labels
                        typepostnom.setText("");

                        // Mettre à jour la ListView avec les nouvelles données
                        listPub.getItems().clear();
                        listPub.getItems().addAll(typePostNom);

                } else {
                        System.out.println("Veuillez sélectionner un type de post à supprimer.");
                }
        }

        public TypePost getTypeFormtionById(int id) {
                return typePostFacade.getTypePostById(id);
        }

        public void setTypePost(ActionEvent event) throws IOException {
                Main m = new Main();
                m.changeScene("ModifierTP-view.fxml");
        }

        public void ajoutTP (ActionEvent a) throws IOException {
                Main m = new Main();
                m.changeScene("AjoutTypePost-view.fxml");
        }
}
