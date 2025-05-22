package model;

import java.util.UUID;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Usuario {
    
    private final String id = UUID.randomUUID().toString();
    private String nome;
    private Long cpf;
    private String email;
    private String senha;
    private Long telefone;
    private String tipoUsuario;
    private Boolean admin;

    public Usuario(String nome, String cpf, String email, String senha, String Telefone, String tipoUsuario, Boolean admin, Boolean auth){
        if(!auth){
            setNome(nome);
            setCpf(cpf);
            setEmail(email);
            setSenha(senha);
            setTelefone(Telefone);
            setTipoUsuario(tipoUsuario);
            setAdmin(admin);
        } else{
            setNome(nome);
            setCpf(cpf);
            setEmail(email);
            this.senha = senha;
            setTelefone(Telefone);
            setTipoUsuario(tipoUsuario);
            setAdmin(admin);
        }
    }

    public void setNome(String novoNome) throws IllegalArgumentException{
        if(novoNome != null){
            if(novoNome.trim() != ""){
                if(!novoNome.trim().contains("\n")){
                    if(!novoNome.equalsIgnoreCase(this.nome)){
                        this.nome = novoNome;
                    } else{
                        throw new IllegalArgumentException("o parâmetro passado é igual ao valor original de 'nome'");
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

    public void setCpf(String novoCpf) throws IllegalArgumentException{
        if(novoCpf != null){
            if(novoCpf.trim() != ""){
                if(!novoCpf.trim().contains("\n")){
                    if(novoCpf.length() == 11){
                        Long temp;
                        try{
                            temp = Long.parseLong(novoCpf);
                        }
                        catch(NumberFormatException n){
                            throw new IllegalArgumentException("o parametro passado não pode ser convertido para um valor numérico válido");
                        }
                        catch(Exception e){
                            throw new RuntimeException("um erro inesperado ocorreu aqui");
                        }
                        if(this.cpf != null)
                            if(!(temp == this.cpf)){
                                this.cpf = temp;
                            } else{
                                throw new IllegalArgumentException("o parâmetro passado é igual ao valor original de 'cpf'");
                            }
                        else {
                            this.cpf = temp;
                        }
                    } else{
                        throw new IllegalArgumentException("o parâmero passado não possui 11 dígitos");
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

    public void setEmail(String novoEmail) throws IllegalArgumentException{
        if(novoEmail != null){
            if(novoEmail.trim() != ""){
                if(!novoEmail.trim().contains("\n")){
                    if(novoEmail.contains("@") && novoEmail.contains(".")){
                        if(novoEmail.charAt(0) != '@' && novoEmail.charAt(novoEmail.length() - 1) != '.'){
                            if(!novoEmail.equals(this.email)){
                                this.email = novoEmail;
                            } else{
                                throw new IllegalArgumentException("o parâmetro passado é igual ao valor original de 'email'");
                            }
                        } else{
                            throw new IllegalArgumentException("o parâmetro passado está fora do padrão apropriado");
                        }
                    } else{
                        throw new IllegalArgumentException("o parâmetro passado está fora do padrão apropriado");
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

    public void setSenha(String novaSenha) throws IllegalArgumentException{
        if(novaSenha != null){
            if(novaSenha.trim() != ""){
                if(!novaSenha.trim().contains("\n")){
                    if(!novaSenha.equals(this.senha)){
                        try{
                            MessageDigest md = MessageDigest.getInstance("SHA-256");
                            byte[] senhaBytes = md.digest(novaSenha.getBytes());
                            StringBuilder senhaHash = new StringBuilder();
                            for(byte b : senhaBytes){
                                senhaHash.append(String.format("%02x", b));
                            }

                            this.senha = senhaHash.toString();
                        }
                        catch(NoSuchAlgorithmException n){
                            throw new RuntimeException("o algorítmo sha-256 não está disponível");
                        }
                    } else{
                        throw new IllegalArgumentException("o parâmetro passado é igual ao valor original de 'senha'");
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

    public void setTelefone(String novoTelefone) throws IllegalArgumentException{
        if(novoTelefone != null){
            if(novoTelefone.trim() != ""){
                if(!novoTelefone.trim().contains("\n")){
                    if(novoTelefone.length() == 11){
                        Long temp;
                        try{
                            temp = Long.parseLong(novoTelefone);
                        }
                        catch(NumberFormatException n){
                            throw new IllegalArgumentException("o parametro passado não pode ser convertido para um valor numérico válido");
                        }
                        catch(Exception e){
                            throw new RuntimeException("um erro inesperado ocorreu aqui");
                        }
                        if(!(temp == this.telefone)){
                            this.telefone = temp;
                        } else{
                            throw new IllegalArgumentException("o parâmetro passado é igual ao valor original de 'telefone'");
                        }
                    } else{
                        throw new IllegalArgumentException("o parâmero passado não possui 11 dígitos");
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

    public void setTipoUsuario(String novoTipoUsuario) throws IllegalArgumentException{
        if(novoTipoUsuario != null){
            if(novoTipoUsuario.trim() != ""){
                if(!novoTipoUsuario.trim().contains("\n")){
                    if(novoTipoUsuario.length() == 1){
                        int temp;
                        try{
                            temp = Integer.parseInt(novoTipoUsuario);
                        }
                        catch(NumberFormatException n){
                            throw new IllegalArgumentException("o parametro passado não pode ser convertido para um valor numérico válido");
                        }
                        catch(Exception e){
                            throw new RuntimeException("um erro inesperado ocorreu aqui");
                        }
                        if(this.tipoUsuario != null) {
                            switch (temp) {
                                case 1:
                                    if(!this.tipoUsuario.equals("Morador")){
                                        this.tipoUsuario = "Morador";
                                    } else{
                                        throw new IllegalArgumentException("este usuário já é do tipo Condômino");
                                    }
                                    break;

                                case 2:
                                    if(!this.tipoUsuario.equals("Síndico")){
                                        this.tipoUsuario = "Síndico";
                                    } else{
                                        throw new IllegalArgumentException("este usuário já é do tipo Síndico");
                                    }
                                    break;
                                
                                case 3:
                                    if(!this.tipoUsuario.equals("Funcionário")){
                                        this.tipoUsuario = "Funcionário";
                                    } else{
                                        throw new IllegalArgumentException("este usuário já é do tipo Funcionário");
                                    }
                                    break;
                                default:
                                    throw new IllegalArgumentException("o parâmetro passado do deve ser apenas 1 para Condômino, 2 para Síndico e 3 para Funcionário");
                            }
                        } else {
                            switch (temp) {
                                case 1:
                                    this.tipoUsuario = "Morador";
                                    break;

                                case 2:
                                    this.tipoUsuario = "Síndico";
                                    break;
                                
                                case 3:
                                    this.tipoUsuario = "Funcionário";
                                    break;
                                default:
                                    throw new IllegalArgumentException("o parâmetro passado do deve ser apenas 1 para Condômino, 2 para Síndico e 3 para Funcionário");
                            }                            
                        }

                    } else{
                        throw new IllegalArgumentException("o parâmero passado não possui 1 dígito");/////////
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

    public void setAdmin(Boolean admin) throws IllegalArgumentException{
        if(admin != null){
            this.admin = admin;
        } else{
            throw new IllegalArgumentException("o parâmetro passado é nulo");
        }
    }

    public String getId() throws IllegalStateException{
        if(this.id != null){
            return this.id;
        } else{
            throw new IllegalStateException("algo de errado ocorreu na definição do id deste usuário");
        }
    }

    public String getNome() throws IllegalStateException{
        if(this.nome != null){
            return this.nome;
        } else{
            throw new IllegalStateException("este usuário ainda não possui um nome definido");
        }
    }

    public Long getCpf() throws IllegalStateException{
        if(this.cpf != 0){
            return this.cpf;
        } else{
            throw new IllegalStateException("algo de errado ocorreu na definição do cpf deste usuário");
        }
    }

    public String getEmail() throws IllegalStateException{
        if(this.email != null){
            return this.email;
        } else{
            throw new IllegalStateException("este usuário ainda não possui um email definido");
        }
    }

    public String getSenha() throws IllegalStateException{
        if(this.senha != null){
            return this.senha;
        } else{
            throw new IllegalStateException("algo de errado ocorreu na definição da senha deste usuário");
        }
    }

    public Long getTelefone() throws IllegalStateException{
        if(this.telefone != 0){
            return this.telefone;
        } else{
            throw new IllegalStateException("este usuário ainda não possui um telefone definido");
        }
    }

    public String getTipoUsuario() throws IllegalStateException{
        if(this.tipoUsuario != null){
            return this.tipoUsuario;
        } else{
            throw new IllegalStateException("algo de errado ocorreu na definição do tipo deste usuário");
        }
    }

    public Boolean getAdmin() throws IllegalArgumentException{
        if(admin != null){
            return this.admin;
        } else{
            throw new IllegalArgumentException("algo de errado ocorreu na definição do cargo deste usuário");
        }
    }

}