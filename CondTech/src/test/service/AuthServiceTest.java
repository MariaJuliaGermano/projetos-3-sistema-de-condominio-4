package test.service;

import model.Usuario;
import repository.UsuarioRepository;
import service.AuthService;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AuthServiceTest {

    // Teste com autenticação bem-sucedida
    @Test
    public void autenticar_DeveRetornarVerdadeiro_QuandoSenhaCorreta() {
        String nome = "joao";
        String senha = "123456";

        // Criar o usuário com a senha já criptografada pelo construtor
        Usuario usuario = new Usuario(nome, "12345678900", "joao@email.com", senha, "11999999999", "1", false);

        UsuarioRepository repoFalso = new UsuarioRepository() {
            @Override
            public Usuario buscarPorNome(String nomeParam) {
                if (nomeParam.equals(nome)) {
                    return usuario;
                }
                return null;
            }
        };

        AuthService auth = new AuthService(repoFalso);
        boolean resultado = auth.autenticar(nome, senha);

        assertTrue(resultado);
    }

    // Teste com senha incorreta
    @Test
    public void autenticarDeveRetornarFalsoQuandoSenhaIncorreta() {
        String nome = "maria";
        String senhaCorreta = "senha123";

        Usuario usuario = new Usuario("maria", "11122233344", "maria@email.com", senhaCorreta, "11999999998", "2", false);

        UsuarioRepository repoFalso = new UsuarioRepository() {
            @Override
            public Usuario buscarPorNome(String nomeParam) {
                if (nomeParam.equals(nome)) {
                    return usuario;
                }
                return null;
            }
        };

        AuthService auth = new AuthService(repoFalso);
        boolean resultado = auth.autenticar(nome, "senhaErrada");

        assertFalse(resultado);
    }

    // Teste com usuário inexistente
    @Test
    public void autenticarDeveRetornarFalsoQuandoUsuarioNaoExiste() {
        UsuarioRepository repoFalso = new UsuarioRepository() {
            @Override
            public Usuario buscarPorNome(String nomeParam) {
                return null; // Simula usuário não encontrado
            }
        };

        AuthService auth = new AuthService(repoFalso);
        boolean resultado = auth.autenticar("naoexiste", "qualquerSenha");

        assertFalse(resultado);
    }
}

