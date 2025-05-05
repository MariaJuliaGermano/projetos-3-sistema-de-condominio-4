package service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import model.Usuario;
import repository.UsuarioRepository;

public class AuthService {
    private UsuarioRepository repo;

    public AuthService(UsuarioRepository repo) {
        this.repo = repo;
    }

    public boolean autenticar(String Nome, String Senha) {
        Usuario user = repo.buscarPorNome(Nome);
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] senhaBytes = md.digest(Senha.getBytes());
            StringBuilder senhaHash = new StringBuilder();
            for(byte b : senhaBytes){
                senhaHash.append(String.format("%02x", b));
            }

            Senha = senhaHash.toString();
        }
        catch(NoSuchAlgorithmException n){
            throw new RuntimeException("o algorítmo sha-256 não está disponível");
        }
        return user != null && user.getSenha().equals(Senha);
    }
}
