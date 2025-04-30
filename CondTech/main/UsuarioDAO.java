package main;
import java.util.ArrayList;

public class UsuarioDAO {
    private final ArrayList<UsuarioInterface> usuarios = new ArrayList<>();

    public void addUsuario(UsuarioInterface usuario){
        this.usuarios.add(usuario);
    }

    public void removeUsuario(UsuarioInterface alvo){
        this.usuarios.remove(alvo);
    }

    public UsuarioInterface[] getUsuarios() throws IllegalStateException{
        if(this.usuarios != null){
            if(!this.usuarios.isEmpty()){
                UsuarioInterface[] usuariosReturn = this.usuarios.toArray(new UsuarioInterface[this.usuarios.size()]);
                return usuariosReturn;
            } else{
                throw new IllegalStateException("A lista de usuários está vazia");                
            }
        } else{
            throw new IllegalStateException("algo ocorreu errado na definição da lista de usuários deste objeto");
        }
    }

    public UsuarioInterface getUsuario(UsuarioInterface alvo){
        int index = this.usuarios.indexOf(alvo);
        return this.usuarios.get(index);
    }
}
