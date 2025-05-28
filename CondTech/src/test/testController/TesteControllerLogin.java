package test.testController;

import repository.UsuarioRepository;
import service.AuthService;
import model.Usuario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import controller.LoginController;

public class TesteControllerLogin {
    private final UsuarioRepository ur = new UsuarioRepository();
    private final AuthService ar = new AuthService(ur);
    private final LoginController lc = new LoginController(ar, ur);

    @Test
    public void loginUsuarioExistente(){
        Usuario teste = lc.fazerLogin("admin", "admin");

        assertNotNull(teste);
        assertEquals("admin", teste.getNome());
        assertEquals("8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918", teste.getSenha());
    }

    @Test
    public void loginUsuarioInexistente(){
        Usuario teste = lc.fazerLogin("teste", "teste");
        assertNull(teste);
    }
}