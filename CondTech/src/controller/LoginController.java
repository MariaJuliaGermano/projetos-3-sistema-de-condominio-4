package controller;

import model.Usuario;
import repository.UsuarioRepository;
import service.AuthService;

public class LoginController {
    private AuthService authService;
    private UsuarioRepository repo;

    public LoginController(AuthService authService, UsuarioRepository repo) {
        this.authService = authService;
        this.repo = repo;
    }

    public Usuario fazerLogin(String Nome, String Senha) {
        if (authService.autenticar(Nome, Senha)) {
            Usuario user = repo.buscarPorNome(Nome);
            return user;
        } else {
            return null;
        }
    }
}