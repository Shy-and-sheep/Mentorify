package com.example.admin.TPControllers;

import com.example.login.Main;
import com.example.TPPackage.TypePostFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
public class AjoutTypePost {
        @FXML
        private TextField nomInput;

        @FXML
        private TextField descriptionInput;

        @FXML
        private Button annulerbutton;
        @FXML
        private Button ajouterbutton;

        public void ajoutduPost(ActionEvent event) throws IOException {
            TypePostFacade.getInstance().addTypePost(nomInput.getText().toString(),descriptionInput.getText().toString());
            Main m = new Main();
            m.changeScene("TP-view.fxml");
        }

        public void annulation(ActionEvent event) throws IOException {
            Main m = new Main();
            m.changeScene("TP-view.fxml");
        }
}
