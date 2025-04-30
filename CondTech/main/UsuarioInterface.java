package main;
import java.util.UUID;

public class UsuarioInterface {
    private final String id = UUID.randomUUID().toString();
    private String nome;
    private double cpf;
    private String email;
    private String senha;
    private double telefone;
    private String tipoUsuario;

    public String getId() throws IllegalStateException{
        if(this.id != null){
            return this.id;
        } else{
            throw new IllegalStateException("algo de errado ocorreu na definição do id desse usuário");
        }
    }
    public String getNome() throws IllegalStateException{
        if(this.nome != null){
            return this.nome;
        } else{
            throw new IllegalStateException("algo de errado ocorreu na definição do nome desse usuário");
        }
    }
    public double getCpf() throws IllegalStateException{
        if(this.cpf != 0){
            return this.cpf;
        } else{
            throw new IllegalStateException("algo de errado ocorreu na definição do cpf desse usuário");
        }
    }
    public String getEmail() throws IllegalStateException{
        if(this.email != null){
            return this.email;
        } else{
            throw new IllegalStateException("algo de errado ocorreu na definição do email desse usuário");
        }
    }
    public String getSenha() throws IllegalStateException{
        if(this.senha != null){
            return this.senha;
        } else{
            throw new IllegalStateException("algo de errado ocorreu na definição da senha desse usuário");
        }
    }
    public double getTelefone() throws IllegalStateException{
        if(this.telefone != 0){
            return this.telefone;
        } else{
            throw new IllegalStateException("algo de errado ocorreu na definição do telefone desse usuário");
        }
    }
    public String getTipoUsuario() throws IllegalStateException{
        if(this.tipoUsuario != null){
            return this.tipoUsuario;
        } else{
            throw new IllegalStateException("algo de errado ocorreu na definição do tipo de usuário desse usuário");
        }
    }

    public UsuarioInterface(String nome, double cpf, String email, String senha, double telefone, String tipoUsuario) throws IllegalArgumentException{
        if(nome != null){
            this.nome = nome;
        } else{
            throw new IllegalArgumentException("o nome passado como parâmetro é nulo");
        }
        if(cpf != 0){
            this.cpf = cpf;
        } else{
            throw new IllegalArgumentException("o cpf passado como parâmetro é nulo");
        }
        if(email != null){
            this.email = email;
        } else{
            throw new IllegalArgumentException("o email passado como parâmetro é nulo");
        }
        if(senha != null){
            this.senha = senha;
        } else{
            throw new IllegalArgumentException("a senha passada como parâmetro é nula");
        }
        if(telefone != 0){
            this.telefone = telefone;
        } else{
            throw new IllegalArgumentException("o telefone passado como parâmetro é nulo");
        }
        if(tipoUsuario != null){
            this.tipoUsuario = tipoUsuario;
        } else{
            throw new IllegalArgumentException("o tipo de usuário passado como parâmetro é nulo");
        }
    }
    public UsuarioInterface(String cpf, String Senha, String tipoUsuario){
        if(cpf != null){
            this.cpf = Double.parseDouble(cpf);
        } else{
            throw new IllegalArgumentException("o cpf passado como parâmetro é nulo");
        }
        if(Senha != null){
            this.senha = Senha;
        } else{
            throw new IllegalArgumentException("a senha passada como parâmetro é nula");
        }
        if(tipoUsuario != null){
            this.tipoUsuario = tipoUsuario;
        } else{
            throw new IllegalArgumentException("o tipo de usuário passado como parâmetro é nulo");
        }
        
        this.nome = null;
        this.email = null;
        this.telefone = 0;
    }

}
