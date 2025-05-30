package abstrato.controller;

import java.util.List;
import model.Mensagem;
import model.Usuario;

abstract public class ChatControllerAbstract {
    abstract public void enviarMensagemGrupo(String idRemetente, String conteudo);
    abstract public List<Mensagem> listarMensagensGrupo();
    abstract public List<Usuario> listarUsuarios();
    abstract public String getNomeUsuario(String id);
}
