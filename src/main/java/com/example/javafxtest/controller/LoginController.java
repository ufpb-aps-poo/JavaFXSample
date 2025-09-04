package com.example.javafxtest.controller;

import com.example.javafxtest.exceptions.FieldValidationException;
import com.example.javafxtest.model.User;
import com.example.javafxtest.services.LoginService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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
            User user = loginService.login(email, password);
            if (user != null) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Sucesso");
                alert.setHeaderText("Login realizado com sucesso!");
                alert.setContentText("Bem-vindo! " + user.getName());
                alert.showAndWait();
                // Aqui você pode adicionar a lógica para redirecionar o usuário para a próxima tela
            }
        } catch (FieldValidationException e) {
            switch (e.getFieldName()) {
                case "email" -> lb_error_email.setText(e.getMessage());
                case "password" -> lb_error_password.setText(e.getMessage());
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }
}
