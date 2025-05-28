package test.testRepository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import model.Usuario;
import repository.UsuarioRepository;

public class TesteRepositoryUsuario {
    private final UsuarioRepository ur = new UsuarioRepository();

    @Test
    public void listaUsuariosUsuariosCadastrados(){
        List<Usuario> listaRetornada = ur.listarUsuarios();

        assertNotNull(listaRetornada);
        assertFalse(listaRetornada.isEmpty());

        Usuario usuarioRetornado = null;
        for(Usuario usuario : listaRetornada){if(usuario.getId().equals("2aaf8cde-1db9-40f5-bbfd-12c110842b64")){usuarioRetornado = usuario;}};

        assertNotNull(usuarioRetornado);
        assertEquals("46070d4bf934fb0d4b06d9e2c46e346944e322444900a435d7d9a95e6d7435f5", usuarioRetornado.getSenha());
        assertEquals("raoni@professor.com", usuarioRetornado.getEmail());
    }
}
