module com.example.login {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    //requires org.junit.platform.commons;
    //requires junit;
    opens com.example.login to javafx.fxml;
    exports com.example.login;
    exports com.example.LoginPackage;
    exports com.example.TFPackage;
    opens com.example.TFPackage to javafx.fxml;
    exports com.example.CommentairePackage;
    opens com.example.CommentairePackage to javafx.fxml;
    exports com.example.formation;
    opens com.example.formation to javafx.fxml;
    exports com.example.FormationPackage;
    opens com.example.FormationPackage to javafx.fxml;
    exports com.example.PostControllers;
    opens com.example.PostControllers to javafx.fxml;
    exports com.example.PostsPackage;
    opens com.example.PostsPackage to javafx.fxml;
    exports com.example.TPPackage;
    opens com.example.TPPackage to javafx.fxml;
    exports com.example.database;
    opens com.example.database to javafx.fxml;
    exports com.example.admin;
    opens com.example.admin to javafx.fxml;
    exports com.example.admin.TPControllers;
    opens com.example.admin.TPControllers to javafx.fxml;
    exports com.example.SessionControllers;
    opens  com.example.SessionControllers to javafx.fxml;
}
