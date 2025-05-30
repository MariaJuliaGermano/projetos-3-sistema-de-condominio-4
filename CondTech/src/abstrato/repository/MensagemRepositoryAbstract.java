package abstrato.repository;

import java.util.List;
import model.Mensagem;

abstract public class MensagemRepositoryAbstract {
    abstract public void adicionarMensagem(Mensagem mensagem);
    abstract public List<Mensagem> listarMensagensGrupo();
}
