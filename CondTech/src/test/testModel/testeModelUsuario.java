package test.testModel;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Usuario;

public class testeModelUsuario {
    private final Usuario usuario = new Usuario( "id","nome", "12345678901", "teste@teste.com", "senha", "12345678901", "1", true);

    @Test
    public void testeGetId(){
        assertEquals("id", usuario.getId());
    }

    @Test
    public void testeGetNome(){
        assertEquals("nome", usuario.getNome());
    }

    @Test
    public void testeGetCpf(){
        Long cpf = Long.parseLong("12345678901");
        assertEquals(cpf, usuario.getCpf());
    }

    @Test
    public void testeGetEmail(){
        assertEquals("teste@teste.com", usuario.getEmail());
    }

    @Test
    public void testeGetSenha(){
        assertEquals("senha", usuario.getSenha());
    }

    @Test
    public void testeGetTelefone(){
        Long telefone = Long.parseLong("12345678901");
        assertEquals(telefone, usuario.getTelefone());
    }

    @Test
    public void testeGetTipoUsuario(){
        assertEquals("Morador", usuario.getTipoUsuario());
    }

    @Test
    public void testeGetAdmin(){
        assertEquals(true, usuario.getAdmin());
    }

    @Test
    public void testeSetNome(){
        usuario.setNome("teste1");
        assertEquals("teste1", usuario.getNome());
    }

    @Test
    public void testeSetCpf(){
        usuario.setCpf("09876543210");
        Long cpf = Long.parseLong("09876543210");
        assertEquals(cpf, usuario.getCpf());
    }

    @Test
    public void testeSetEmail(){
        usuario.setEmail("teste2@teste2.com");
        assertEquals("teste2@teste2.com", usuario.getEmail());
    }

    @Test
    public void testeSetSenha(){
        usuario.setSenha("teste3");
        assertEquals("ee80b6f59a0e2c1c30853d1be6246defa9e70c10f8efb2178cabe14f2edca6ba", usuario.getSenha());
    }

    @Test
    public void testeSetTelefone(){
        usuario.setTelefone("09876543210");
        Long telefone = Long.parseLong("09876543210");
        assertEquals(telefone, usuario.getTelefone());
    }

    @Test
    public void testeSetTipoUsuario(){
        usuario.setTipoUsuario("2");
        assertEquals("Síndico", usuario.getTipoUsuario());
    }

    @Test
    public void testeSetAdmin(){
        usuario.setAdmin(false);
        assertEquals(false, usuario.getAdmin());
    }
}
