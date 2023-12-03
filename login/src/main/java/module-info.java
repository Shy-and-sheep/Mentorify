module com.example.login {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.login to javafx.fxml;
    exports com.example.login;
    exports com.example.database;
    opens com.example.database to javafx.fxml;
}