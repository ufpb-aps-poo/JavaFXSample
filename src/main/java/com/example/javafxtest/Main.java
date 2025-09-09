package com.example.javafxtest;

import com.example.javafxtest.controller.RegisterController;
import com.example.javafxtest.services.RegisterService;
import com.example.javafxtest.repository.UserMemoryRepository;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("register.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        RegisterService service = new RegisterService(new UserMemoryRepository());
        RegisterController controller = (RegisterController) fxmlLoader.getController();
        controller.setRegisterService(service);

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}