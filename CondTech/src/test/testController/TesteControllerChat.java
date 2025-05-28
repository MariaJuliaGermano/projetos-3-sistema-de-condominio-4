package test.testController;

import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import controller.ChatController;
import repository.MensagemRepository;
import repository.UsuarioRepository;

public class TesteControllerChat {
    private final MensagemRepository mr = new MensagemRepository();
    private final UsuarioRepository ur = new UsuarioRepository();
    private final ChatController cc = new ChatController(mr, ur);

    @Test
    public void getNomeExistente(){
        assertEquals("admin", cc.getNomeUsuario("176cf727-915a-4d39-af1e-b118e4de3b32"));
    }

    @Test
    public void getNomeNaoExistente(){
        assertEquals("Usuário Desconhecido", cc.getNomeUsuario("testeteste"));
    }
}
