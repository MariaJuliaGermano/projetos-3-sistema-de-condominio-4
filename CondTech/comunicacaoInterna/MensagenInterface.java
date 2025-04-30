package comunicacaoInterna;
import java.util.UUID;
import main.Usuario;

public class MensagenInterface{
    private final String id = UUID.randomUUID().toString();
    private String idUsuario;
    private String mensagem;

    public String getId() throws IllegalStateException{
        if(this.id != null){
            return this.id;
        } else{
            throw new IllegalStateException("algo de errado ocorreu na definição do id dessa mensagem");
        }
    }
    public String getIdUsuario() throws IllegalStateException{
        if(this.idUsuario != null){
            return this.idUsuario;
        } else{
            throw new IllegalStateException("algo de errado ocorreu na definição do id de usuário dessa mensagem");
        }
    }
    public String getMensagem(){
        if(this.mensagem != null){
            return this.mensagem;
        } else{
            throw new IllegalStateException("algo de errado ocorreu na definição do texto dessa mensagem");
        }
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Mensagem mensagem = (Mensagem) obj;
        if (this.id != null ? !this.id.equals(mensagem.getId()) : mensagem.getId() != null) return false;
        if (this.idUsuario != null ? !this.idUsuario.equals(mensagem.getIdUsuario()) : mensagem.getIdUsuario() != null) return false;
        if (this.mensagem != null ? !this.mensagem.equals(mensagem.getMensagem()) : mensagem.getMensagem() != null) return false;
        
        return true;
    }

    public MensagenInterface(Usuario user, String mensagem){
        if(user != null){
            if(user.getTipoUsuario() == "Síndico"){
                try{
                    this.idUsuario = user.getId();
                }
                catch(IllegalStateException i){
                    throw new IllegalArgumentException(i.getMessage());
                }
                catch(Exception e){
                    throw new IllegalArgumentException("um erro inesperado ocorreu ao tentar acessar o id do usuário passado como parâmetro: " + e.getMessage());
                }

                if(mensagem != null){
                    mensagem = mensagem.trim();
                    if(!mensagem.contains("\n") && mensagem != ""){
                        this.mensagem = mensagem;
                    } else{
                        throw new IllegalArgumentException("A mensagem passada como parâmetro é uma string vazia ou contém quebras de linhas");
                    }
                } else{
                    throw new IllegalArgumentException("A mensagem passada como parâmetro é nula");
                }
            } else{
                throw new IllegalArgumentException("O usuário passado como parâmetro não é um Síndico");
            }
        } else{
            throw new IllegalArgumentException("O Usuário passado como parâmetro é nulo");
        }
    }
    public MensagenInterface(String idUsuario, String mensagem){
        if(idUsuario != null){
            this.idUsuario = idUsuario;
        } else{
            throw new IllegalArgumentException("O id do usuário passado como parâmetro é nulo");
        }
        if(mensagem != null){
            mensagem = mensagem.trim();
            if(!mensagem.contains("\n") && mensagem != ""){
                this.mensagem = mensagem;
            } else{
                throw new IllegalArgumentException("A mensagem passada como parâmetro é uma string vazia ou contém quebras de linhas");
            }
        } else{
            throw new IllegalArgumentException("A mensagem passada como parâmetro é nula");
        }
    }
}
