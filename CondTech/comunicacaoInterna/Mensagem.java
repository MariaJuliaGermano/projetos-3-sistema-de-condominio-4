package comunicacaoInterna;
import java.util.UUID;

import main.Usuario;

public class Mensagem {
    
    private final String id = UUID.randomUUID().toString();
    private String idUsuario;
    private String mensagem;

    private void setIdUsuario(Usuario user) throws IllegalArgumentException{
        if(user != null){
            try{
                this.idUsuario = user.getId();
            }
            catch(IllegalStateException i){
                throw new IllegalArgumentException("o usuário passado como parametro não possui um id válido");
            }
            catch(Exception e){
                throw new RuntimeException("um erro inesperado ocorreu ao tentar obter o id do usuário passado como parâmetro");
            }
        }
    }
    public void setMensagem(String mensagem) throws IllegalArgumentException{
        if(mensagem != null){
            if(mensagem.trim() != ""){
                if(!mensagem.trim().contains("\n")){
                    if(!mensagem.equalsIgnoreCase(this.mensagem)){
                        this.mensagem = mensagem;
                    } else{
                        throw new IllegalArgumentException("o parâmetro passado é igual ao valor original de 'mensagem'");
                    }
                } else{
                    throw new IllegalArgumentException("o parâmetro passado contém uma quabra de linha");
                }
            } else{
                throw new IllegalArgumentException("o parâmetro passado é uma string vazia");
            }
        } else{
            throw new IllegalArgumentException("o parâmetro passado é nulo");
        }
    }

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

    public Mensagem(Usuario user, String mensagem){
        setIdUsuario(user);
        setMensagem(mensagem);
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
}
