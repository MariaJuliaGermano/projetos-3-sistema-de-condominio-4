package test.testModel;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Test;

import model.Mensagem;

public class TesteModelMensagem {
    private final Mensagem mensagem = new Mensagem( "id","remetente", "destinatario", "conteudo", "2025-05-23T12:17:14.528996");

    @Test
    public void testeGetId(){
        assertEquals("id", mensagem.getId());
    }

    @Test
    public void testeGetRemetente(){
        assertEquals("remetente", mensagem.getRemetente());
    }

    @Test
    public void testeGetDestinatario(){
        assertEquals("destinatario" , mensagem.getDestinatario());
    }

    @Test
    public void testeGetConteudo(){
        assertEquals("conteudo", mensagem.getConteudo());
    }

    @Test
    public void testeGetDataHora(){
        LocalDateTime ldt = LocalDateTime.parse("2025-05-23T12:17:14.528996");
        assertEquals(ldt, mensagem.getDataHora());
    }

    @Test
    public void testeIsLida(){
        assertEquals(false, mensagem.isLida());
    }

    @Test
    public void testeSetLida(){
        mensagem.setLida(true);
        assertEquals(true, mensagem.isLida());
    }
}
