package comunicacaoInterna;
import java.util.UUID;
import java.util.ArrayList;

public class Chat {
    private final String id = UUID.randomUUID().toString();
    private final ArrayList<Mensagem> mensagens = new ArrayList<>();

    public void addMensagem(Mensagem mensagem){
        if(mensagem != null){
            this.mensagens.add(mensagem);
        }
    }
    public Mensagem[] getMensagens(){
        if(this.mensagens != null){
            if(!this.mensagens.isEmpty()){
                Mensagem[] mensagensReturn = this.mensagens.toArray(new Mensagem[this.mensagens.size()]);
                return mensagensReturn;
            } else{
                throw new IllegalStateException("esta instância de Chat não possui nenhuma mensagem associada a ela");                
            }
        } else{
            throw new IllegalStateException("algo ocorreu errado na definição das mensagens desta instância de Chat");
        } 
    }
    public void removeMensagem(Mensagem alvo){
        if(alvo != null){
            for(Mensagem mensagem : this.mensagens){
                if(mensagem.equals(alvo)){
                    this.mensagens.remove(mensagem);
                    break;
                }
            }
        }
    }

    public String getId(){
        if(this.id != null){
            return this.id;            
        } else{
            throw new IllegalStateException("algo de errado ocorreu na definição do is desta intância");
        }
    }

    public Chat(Mensagem mensagem){
        addMensagem(mensagem);
    }
}
