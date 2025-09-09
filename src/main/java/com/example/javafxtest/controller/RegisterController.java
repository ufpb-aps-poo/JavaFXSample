package com.example.javafxtest.controller;

import com.example.javafxtest.exceptions.FieldValidationException;
import com.example.javafxtest.repository.UserMemoryRepository;
// import com.example.javafxtest.services.LoginService;
import com.example.javafxtest.services.RegisterService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;


public class RegisterController {

    private RegisterService registerService;

    public void setRegisterService(RegisterService registerService) {
        this.registerService = registerService;
    }

    @FXML
    private Button br_register;


    @FXML
    private TextField tf_email;

    @FXML
    private TextField tf_name;

    @FXML
    private PasswordField tf_password;

    @FXML
    private Label lb_error_email;

    @FXML
    private Label lb_error_name;

    @FXML
    private Label lb_error_password;

    @FXML
    void handleRegister(ActionEvent event) {
        // limpa erros
        lb_error_name.setText("");
        lb_error_email.setText("");
        lb_error_password.setText("");

        try {
            registerService.registerUser(
                    tf_name.getText(),
                    tf_email.getText(),
                    tf_password.getText()
            );

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Sucesso");
            alert.setHeaderText(null);
            alert.setContentText("Usuário cadastrado com sucesso!");
            alert.showAndWait();


            // REMOVA OS COMENTARIOS QUANDO FOR IMPLEMENTAR O LOGIN
            //goToLogin(event);

        } catch (FieldValidationException e) {
            switch (e.getFieldName()) {
                case "name" -> lb_error_name.setText(e.getMessage());
                case "email" -> lb_error_email.setText(e.getMessage());
                case "password" -> lb_error_password.setText(e.getMessage());
            }
        } /*catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }*/  // REMOVA OS COMENTARIOS QUANDO FOR IMPLEMENTAR O LOGIN
    }

    // REMOVA OS COMENTARIOS QUANDO FOR IMPLEMENTAR O LOGIN
/*    private void goToLogin(ActionEvent event) throws IOException {
        // Carrega o FXML da tela de login
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/javafxtest/login.fxml"));
        Parent loginRoot = loader.load();

        // Se precisar, pode pegar o controller do login e passar serviços
        LoginController loginController = loader.getController();
        loginController.setLoginService(new LoginService(new UserMemoryRepository()));

        // Pega o Stage atual a partir do botão que disparou o evento
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(loginRoot));
        stage.setTitle("Login");
        stage.show();
    }*/

}