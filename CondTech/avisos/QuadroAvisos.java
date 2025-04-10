package avisos;
import java.util.UUID;
import java.util.ArrayList;
import comunicacaoInterna.Mensagem;
import main.Usuario;

public class QuadroAvisos {
    private final String id = UUID.randomUUID().toString();
    private String idSindico;
    private final ArrayList<Mensagem> mensagens = new ArrayList<>();

    private void setIdSindico(Usuario user){
        if(user != null){
            if(user.getTipoUsuario() == "Síndico"){
                try{
                    this.idSindico = user.getId();
                }
                catch(IllegalStateException i){
                    throw new IllegalArgumentException("o usuário passado como parâmetro não possui um id válido");
                }
                catch(Exception e){
                    throw new RuntimeException("um erro inesperado ocorreu ao tentar obter o id do usuário passado como parâmetro");
                }
            } else{
                throw new IllegalArgumentException("o usuário passado como parâmetro deve ser um Síndico para que possa ser cadastrado");
            }
        } else{
            throw new IllegalArgumentException("o parâmetro passado é nulo");
        }
    }
    public void addMensagem(Mensagem mensagem){
        if(mensagem != null){
            if(this.idSindico.equals(mensagem.getIdUsuario())){
                this.mensagens.add(mensagem);
            }
        }
    }
    public Mensagem[] getMensagens(){
        if(this.mensagens != null){
            if(!this.mensagens.isEmpty()){
                Mensagem[] mensagensReturn = this.mensagens.toArray(new Mensagem[this.mensagens.size()]);
                return mensagensReturn;
            } else{
                throw new IllegalStateException("esta instância de QuadroAvisos não possui nenhuma mensagem associada a ela");                
            }
        } else{
            throw new IllegalStateException("algo ocorreu errado na definição das mensagens desta instância de QuadroAvisos");
        }
    }
    public void removeMensagen(Mensagem alvo){
        if(alvo != null){
            for(Mensagem mensagem : this.mensagens){
                if(mensagem.equals(alvo)){
                    this.mensagens.remove(mensagem);
                    break;
                }
            }
        }
    }

    public String getId() throws IllegalStateException{
        if(this.id != null){
            return this.id;
        } else{
            throw new IllegalStateException("algo de errado ocorreu na definição do id desse Quadro de Avisos");
        }
    }
    public String getIdSindico() throws IllegalStateException{
        if(this.idSindico != null){
            return this.idSindico;
        } else{
            throw new IllegalStateException("algo de errado ocorreu na definição do id do síndico desse Quadro de Avisos");
        }
    }

    public QuadroAvisos(Usuario user, Mensagem mensagem){
        setIdSindico(user);
        addMensagem(mensagem);
    }
}
