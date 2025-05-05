package repository;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class UsuarioRepository {
    
    private final List<Usuario> usuarios;

    public UsuarioRepository() {
        this.usuarios = new ArrayList<>();
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Usuario buscarPorNome(String Nome) {
        for (Usuario u : usuarios) {
            if (u.getNome().equalsIgnoreCase(Nome)) {
                return u;
            }
        }
        return null; //Usuario não foi encontrado
    }

    public List<Usuario> listarUsuarios() {
        return new ArrayList<>(usuarios); // cópia da lista
    }
}
