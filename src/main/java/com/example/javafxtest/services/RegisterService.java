package com.example.javafxtest.services;

import com.example.javafxtest.exceptions.FieldValidationException;
import com.example.javafxtest.repository.IUserRepository;

public class RegisterService {

    private final IUserRepository userRepository;
    public RegisterService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(String name, String email, String password) throws FieldValidationException {

        if (name == null || name.isBlank()) {
            throw new FieldValidationException("name", "Nome é obrigatório.");
        }
        if (email == null || email.isBlank()) {
            throw new FieldValidationException("email", "E-mail é obrigatório.");
        }
        if (!email.matches("^[\\w-.]+@[\\w-]+\\.[a-zA-Z]{2,}$")) {
            throw new FieldValidationException("email", "E-mail inválido.");
        }
        if (password == null || password.length() < 6) {
            throw new FieldValidationException("password", "Senha deve ter ao menos 6 caracteres.");
        }
        // se tudo passar, cria usuário
        userRepository.createUser(name, email, password);
    }

}
