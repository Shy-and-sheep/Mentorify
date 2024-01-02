module com.example.login {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    //requires org.junit.platform.commons;
    //requires junit;




    opens com.example.login to javafx.fxml;
    exports com.example.login;
    exports com.example.LoginPackage;
    exports com.example.database;
    opens com.example.database to javafx.fxml;
    exports com.example.TPControllers;
    opens com.example.TPControllers to javafx.fxml;
}