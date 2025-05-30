package controller;

import abstrato.controller.LoginControllerAbastract;

import model.Usuario;
import repository.UsuarioRepository;
import service.AuthService;

public class LoginController extends LoginControllerAbastract{
    private AuthService authService;
    private UsuarioRepository repo;

    public LoginController(AuthService authService, UsuarioRepository repo) {
        this.authService = authService;
        this.repo = repo;
    }

    @Override
    public Usuario fazerLogin(String Nome, String Senha) {
        if (authService.autenticar(Nome, Senha)) {
            Usuario user = repo.buscarPorNome(Nome);
            return user;
        } else {
            return null;
        }
    }
}