package com.example.javafxtest.controller;

import com.example.javafxtest.exceptions.FieldValidationException;
import com.example.javafxtest.services.LoginService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {

    private LoginService loginService;

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }


    @FXML
    private Button bt_login;

    @FXML
    private Label lb_error_email;

    @FXML
    private Label lb_error_password;

    @FXML
    private TextField tf_email;

    @FXML
    private PasswordField tf_password;

    @FXML
    void handleLogin(ActionEvent event) {
        // limpa mensagens de erro
        lb_error_email.setText("");
        lb_error_password.setText("");

        String email = tf_email.getText();
        String password = tf_password.getText();

        try {
            boolean success = loginService.login(email, password);
            if (success) {
                System.out.println("Login successful!");
                // Aqui você pode adicionar a lógica para redirecionar o usuário para a próxima tela
            }
        } catch (FieldValidationException e) {
            switch (e.getFieldName()) {
                case "email" -> lb_error_email.setText(e.getMessage());
                case "password" -> lb_error_password.setText(e.getMessage());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
