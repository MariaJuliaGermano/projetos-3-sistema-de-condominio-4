package avisos;
import java.util.UUID;
import java.util.ArrayDeque;
import comunicacaoInterna.Mensagem;

public class QuadroAvisos {
    private final String id = UUID.randomUUID().toString();
    private String idSindico;
    private final ArrayDeque<Mensagem> mensagens = new ArrayDeque<>();

    
}
