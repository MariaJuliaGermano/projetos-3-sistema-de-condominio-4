package comunicacaoInterna;
import java.util.ArrayList;

public class MensagemDAO {
    private final ArrayList<MensagenInterface> mensagens = new ArrayList<>();

    public void addMensagem(MensagenInterface mensagem){
        this.mensagens.add(mensagem);
    }
    public void removeMensagem(MensagenInterface alvo){
        this.mensagens.remove(alvo);
    }
    public MensagenInterface[] getMensagens() throws IllegalStateException{
        if(this.mensagens != null){
            if(!this.mensagens.isEmpty()){
                MensagenInterface[] mensagensReturn = this.mensagens.toArray(new MensagenInterface[this.mensagens.size()]);
                return mensagensReturn;
            } else{
                throw new IllegalStateException("A lista de mensagens está vazia");                
            }
        } else{
            throw new IllegalStateException("algo ocorreu errado na definição da lista de mensagens deste objeto");
        }
    }
    public MensagenInterface getMensagem(MensagenInterface alvo){
        int index = this.mensagens.indexOf(alvo);
        return this.mensagens.get(index);
    }
}
