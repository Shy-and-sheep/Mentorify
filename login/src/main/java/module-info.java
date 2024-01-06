module com.example.login {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    //requires org.junit.platform.commons;
    //requires junit;




    opens com.example.login to javafx.fxml;
    exports com.example.login;
    exports com.example.UserPackage;
    exports com.example.database;
    opens com.example.database to javafx.fxml;
    exports com.example.admin;
    opens com.example.admin to javafx.fxml;
    exports com.example.admin.TPControllers;
    opens com.example.admin.TPControllers to javafx.fxml;
    exports com.example.TPaiement;
    opens com.example.TPaiement to javafx.fxml;
    exports com.example.Register ;
    opens com.example.Register to javafx.fxml ;
}
