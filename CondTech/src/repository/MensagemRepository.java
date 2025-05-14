package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.Mensagem;

public class MensagemRepository {
    private final List<Mensagem> mensagens;
    private static final String CHAT_GRUPO = "CHAT_CONDOMINIO"; 

    public MensagemRepository() {
        this.mensagens = new ArrayList<>();
    }

    public void adicionarMensagem(Mensagem mensagem) {
        mensagens.add(mensagem);
    }

    public List<Mensagem> listarMensagensGrupo() {
        return mensagens.stream()
                .filter(m -> m.getDestinatario().equals(CHAT_GRUPO))
                .collect(Collectors.toList());
    }
    
    public static String getIdGrupo() {
        return CHAT_GRUPO;
    }
}