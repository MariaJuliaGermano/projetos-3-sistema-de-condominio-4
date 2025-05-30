package abstrato.repository;

import java.util.List;
import model.Usuario;

abstract public class UsuarioRepositoryAbstract {
    abstract public void adicionarUsuario(Usuario usuario);
    abstract public Usuario buscarPorNome(String Nome);
    abstract public List<Usuario> listarUsuarios();
}
