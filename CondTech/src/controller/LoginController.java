package controller;

import service.AuthService;

public class LoginController {
    private AuthService authService;

    public LoginController(AuthService authService) {
        this.authService = authService;
    }

    public void fazerLogin(String Nome, String Senha) {
        if (authService.autenticar(Nome, Senha)) {
            System.out.println("Login bem-sucedido.");
        } else {
            System.out.println("Login inválido.");
        }
    }
}