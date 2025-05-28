package test.testRepository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;


import org.junit.Test;

import java.util.List;
import model.Mensagem;
import repository.MensagemRepository;

public class TesteRepositoryMensagem {
    private final MensagemRepository mr = new MensagemRepository();

    @Test
    public void listaUsuariosUsuariosCadastrados(){
        List<Mensagem> listaRetornada = mr.listarMensagensGrupo();

        assertNotNull(listaRetornada);
        assertFalse(listaRetornada.isEmpty());

        Mensagem mensagemRetornada = null;
        for(Mensagem mensagem : listaRetornada){if(mensagem.getId().equals("2f65d03b-9371-48c8-b5c0-6298b214c033")){mensagemRetornada = mensagem;}};
        
        assertNotNull(mensagemRetornada);
        assertEquals("2aaf8cde-1db9-40f5-bbfd-12c110842b64", mensagemRetornada.getRemetente());
        assertEquals("CHAT_CONDOMINIO", mensagemRetornada.getDestinatario());
    }
}
