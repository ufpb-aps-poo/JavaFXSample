package com.example.javafxtest.services;

import com.example.javafxtest.exceptions.FieldValidationException;
import com.example.javafxtest.model.User;
import com.example.javafxtest.repository.IUserRepository;

public class LoginService {

    private final IUserRepository userRepository;
    public LoginService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User login(String email, String password) throws Exception {

        // --- 1. Valida campos obrigatórios ---
        if (email == null || email.isBlank()) {
            throw new FieldValidationException("email","E-mail é obrigatório.");
        }

        if (password == null || password.isBlank()) {
            throw new FieldValidationException("password", "Senha é obrigatória.");
        }

        // --- 2. Valida formato do e-mail ---
        if (!email.matches("^[\\w-.]+@[\\w-]+\\.[a-zA-Z]{2,}$")) {
            throw new FieldValidationException("email", "E-mail inválido.");
        }

        // --- 3. Busca usuário no repositório ---
        User user = userRepository.showUserByEmail(email);
        if (user == null) {
            throw new Exception("Usuário não encontrado.");
        }

        // --- 4. Verifica senha ---
        if (!user.getPassword().equals(password)) {
            throw new Exception("Senha incorreta.");
        }

        // --- Login válido ---
        return user;
    }



}
