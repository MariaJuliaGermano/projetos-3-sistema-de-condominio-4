package avisos;
import java.util.UUID;
import java.util.ArrayDeque;
import comunicacaoInterna.Mensagem;
import main.Usuario;

public class QuadroAvisos {
    private final String id = UUID.randomUUID().toString();
    private String idSindico;
    private final ArrayDeque<Mensagem> mensagens = new ArrayDeque<>();

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
                this.mensagens.push(mensagem);
            }
        }
    }
    public Mensagem[] getMensagens(){}

}
