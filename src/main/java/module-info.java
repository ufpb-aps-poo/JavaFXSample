module com.example.javafxtest {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.javafxtest to javafx.fxml;
    exports com.example.javafxtest;
    exports com.example.javafxtest.controller;
    exports com.example.javafxtest.services;
    exports com.example.javafxtest.repository;
    exports com.example.javafxtest.model;
    opens com.example.javafxtest.controller to javafx.fxml;
}