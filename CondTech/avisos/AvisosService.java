package avisos;
import comunicacaoInterna.MensagenInterface;
import comunicacaoInterna.MensagemDAO;
import main.Usuario;

public class AvisosService {
    protected final MensagemDAO mensagemDAO = new MensagemDAO();
    private String idSindico;

    public void editarMensagem(MensagenInterface alvo, String newMensagem, Usuario usuario) throws IllegalArgumentException{
        MensagenInterface[] mensagens = mensagemDAO.getMensagens();

        int index = indexOfMensagem(alvo);
        if(index != -1){
            MensagenInterface mensagem = mensagens[index];
            if(newMensagem != null){
                newMensagem = newMensagem.trim();
                if(newMensagem != "" && !newMensagem.contains("\n")){
                    mensagemDAO.removeMensagem(mensagem);
                    this.addMensagem(newMensagem, usuario);
                } else{
                    throw new IllegalArgumentException("a nova mensagem passada como parâmetro não é válida");
                }
            } else{
                throw new IllegalArgumentException("a nova mensagem passada como parâmetro é nula");
            }
        } else{
            throw new IllegalArgumentException("a mensagem passada como parâmetro não existe na lista de mensagens");
        }
    }

    public int indexOfMensagem(MensagenInterface alvo) throws IllegalArgumentException{
        if(alvo != null){
            MensagenInterface[] mensagens = mensagemDAO.getMensagens();
            int iterador = 0;
            for(MensagenInterface mensagem : mensagens){
                if(mensagem.equals(alvo)){
                    return iterador;
                }
                iterador ++;
            }
            return -1;
        } else{
            throw new IllegalArgumentException("o alvo passado como parâmetro é nulo");
        }
    }

    public void addMensagem(String mensagem, Usuario usuario) throws IllegalArgumentException{
        if(mensagem != null){
            mensagem = mensagem.trim();
            if(!mensagem.contains("\n") && mensagem != ""){
                if(usuario != null){
                    if(usuario.getTipoUsuario() == "Síndico"){
                        MensagenInterface novaMensagem = new MensagenInterface(usuario, mensagem);
                        mensagemDAO.addMensagem(novaMensagem);
                    }
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

    public void removeMensagem(MensagenInterface alvo) throws IllegalArgumentException{
        if(alvo != null){
            int index = indexOfMensagem(alvo);
            if(index != -1){
                MensagenInterface mensagem = mensagemDAO.getMensagem(alvo);
                mensagemDAO.removeMensagem(mensagem);
            } else{
                throw new IllegalArgumentException("a mensagem passada como parâmetro não existe na lista de mensagens");
            }
        } else{
            throw new IllegalArgumentException("o alvo passado como parâmetro é nulo");
        }
    }

    public String getIdSindico() throws IllegalStateException{
        if(this.idSindico != null){
            return this.idSindico;
        } else{
            throw new IllegalStateException("algo de errado ocorreu na definição do id do sindico deste objeto");
        }
    }

    public AvisosService(Usuario sindico) throws IllegalArgumentException{
        if(sindico != null){
            if(sindico.getTipoUsuario() == "Síndico"){
                this.idSindico = sindico.getId();
            } else{
                throw new IllegalArgumentException("o usuário passado como parâmetro não é um síndico");
            }
        } else{
            throw new IllegalArgumentException("o usuário passado como parâmetro é nulo");
        }
    }
}
