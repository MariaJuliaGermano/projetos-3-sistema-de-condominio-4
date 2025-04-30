package comunicacaoInterna;
import avisos.AvisosService;
import main.Usuario;

public class ChatService extends AvisosService {
    @Override
    public void addMensagem(String mensagem, Usuario usuario) throws IllegalArgumentException{
        if(mensagem != null){
            mensagem = mensagem.trim();
            if(!mensagem.contains("\n") && mensagem != ""){
                if(usuario != null){
                    MensagenInterface novaMensagem = new MensagenInterface(usuario, mensagem);
                    mensagemDAO.addMensagem(novaMensagem);
                } else{
                    throw new IllegalArgumentException("o usuário passado como parâmetro é nulo");
                }
            } else{
                throw new IllegalArgumentException("a mensagem passada como parâmetro não é válida");
            }
        } else{
            throw new IllegalArgumentException("a mensagem passada como parâmetro é nula");
        }
    }

    public ChatService(Usuario usuario){
        super(usuario);
    }
}
