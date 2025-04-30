package main;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UsuarioService {
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();
    private String idSindico;

    public String getIdSindico() throws IllegalStateException{
        if(this.idSindico != null){
            return this.idSindico;
        } else{
            throw new IllegalStateException("o id do síndico não foi definido");
        }
    }

    public void setIdsindico(UsuarioInterface user) throws IllegalArgumentException{
        if(user != null){
            if(user.getTipoUsuario() == "Síndico"){
                this.idSindico = user.getId();
            } else{
                throw new IllegalArgumentException("o usuário passado como parâmetro não é um síndico");
            }
        } else{
            throw new IllegalArgumentException("o id do síndico passado como parâmetro é nulo");
        }
    }

    public void setNome(String novoNome, UsuarioInterface user) throws IllegalArgumentException{
        if(novoNome != null){
            if(novoNome.trim() != ""){
                if(!novoNome.trim().contains("\n")){
                    if(user != null){
                        if(!novoNome.equalsIgnoreCase(user.getNome())){
                            UsuarioInterface novoUsuario = new UsuarioInterface(novoNome, user.getCpf(), user.getEmail(), user.getSenha(), user.getTelefone(), user.getTipoUsuario());
                            this.removeUsuario(user);
                            this.addUsuario(novoUsuario);
                        } else{
                            throw new IllegalArgumentException("o parâmetro passado é igual ao valor original de 'nome'");
                        }
                    } else{
                        throw new IllegalArgumentException("o id do síndico passado como parâmetro é nulo");
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
    public void setCpf(double novoCpf, UsuarioInterface user) throws IllegalArgumentException{
        if(novoCpf != 0){
            if(novoCpf != user.getCpf()){
                UsuarioInterface novoUsuario = new UsuarioInterface(user.getNome(), novoCpf, user.getEmail(), user.getSenha(), user.getTelefone(), user.getTipoUsuario());
                this.removeUsuario(user);
                this.addUsuario(novoUsuario);
            } else{
                throw new IllegalArgumentException("o parâmetro passado é igual ao valor original de 'cpf'");
            }
        } else{
            throw new IllegalArgumentException("o parâmetro passado é nulo");
        }
    }
    public void setEmail(String novoEmail, UsuarioInterface user) throws IllegalArgumentException{
        if(novoEmail != null){
            if(novoEmail.trim() != ""){
                if(!novoEmail.trim().contains("\n")){
                    if(user != null){
                        if(novoEmail.contains("@") && novoEmail.contains(".")){
                            if(!novoEmail.equalsIgnoreCase(user.getNome())){
                                UsuarioInterface novoUsuario = new UsuarioInterface(user.getNome(), user.getCpf(), novoEmail, user.getSenha(), user.getTelefone(), user.getTipoUsuario());
                                this.removeUsuario(user);
                                this.addUsuario(novoUsuario);
                            } else{
                                throw new IllegalArgumentException("o parâmetro passado é igual ao valor original de 'nome'");
                            }
                        } else{
                            throw new IllegalArgumentException("o parâmetro passado não é um email válido");
                        }
                    } else{
                        throw new IllegalArgumentException("o id do síndico passado como parâmetro é nulo");
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
    public void setSenha(String novaSenha, UsuarioInterface user) throws IllegalArgumentException{
        if(novaSenha != null){
            if(novaSenha.trim() != ""){
                if(!novaSenha.trim().contains("\n")){
                    if(user != null){
                        if(!novaSenha.equalsIgnoreCase(user.getNome())){
                            try{
                                MessageDigest md = MessageDigest.getInstance("SHA-256");
                                byte[] senhaBytes = md.digest(novaSenha.getBytes());
                                StringBuilder senhaHash = new StringBuilder();
                                for(byte b : senhaBytes){
                                    senhaHash.append(String.format("%02x", b));
                                }
    
                                UsuarioInterface novoUsuario = new UsuarioInterface(user.getNome(), user.getCpf(), user.getEmail(), senhaHash.toString(), user.getTelefone(), user.getTipoUsuario());
                                this.removeUsuario(user);
                                this.addUsuario(novoUsuario);
                            }
                            catch(NoSuchAlgorithmException n){
                                throw new RuntimeException("o algorítmo sha-256 não está disponível");
                            }
                        } else{
                            throw new IllegalArgumentException("o parâmetro passado é igual ao valor original de 'senha'");
                        }
                    } else{
                        throw new IllegalArgumentException("o id do síndico passado como parâmetro é nulo");
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
    public void setTelefone(double novoTelefone, UsuarioInterface user) throws IllegalArgumentException{
        if(novoTelefone != 0){
            if(novoTelefone != user.getTelefone()){
                UsuarioInterface novoUsuario = new UsuarioInterface(user.getNome(), user.getCpf(), user.getEmail(), user.getSenha(), novoTelefone, user.getTipoUsuario());
                this.removeUsuario(user);
                this.addUsuario(novoUsuario);
            } else{
                throw new IllegalArgumentException("o parâmetro passado é igual ao valor original de 'telefone'");
            }
        } else{
            throw new IllegalArgumentException("o parâmetro passado é nulo");
        }
    }
    public void setTipoUsuario(String novoTipoUsuario, UsuarioInterface user) throws IllegalArgumentException{
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
                        switch (temp) {
                            case 1:
                                UsuarioInterface novoUsuario = new UsuarioInterface(user.getNome(), user.getCpf(), user.getEmail(), user.getSenha(), user.getTelefone(), "Condômino");
                                this.removeUsuario(user);
                                this.addUsuario(novoUsuario);
                                break;

                            case 2:
                                UsuarioInterface novoUsuario1 = new UsuarioInterface(user.getNome(), user.getCpf(), user.getEmail(), user.getSenha(), user.getTelefone(), "Sindico");
                                this.removeUsuario(user);
                                this.addUsuario(novoUsuario1);
                                break;
                            
                            case 3:
                                UsuarioInterface novoUsuario2 = new UsuarioInterface(user.getNome(), user.getCpf(), user.getEmail(), user.getSenha(), user.getTelefone(), "Funcionário");
                                this.removeUsuario(user);
                                this.addUsuario(novoUsuario2);
                                break;
                            default:
                                throw new IllegalArgumentException("o parâmetro passado do deve ser apenas 1 para Condômino, 2 para Síndico e 3 para Funcionário");
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

    public void addUsuario(UsuarioInterface user) throws IllegalArgumentException{
        if(user != null){
            try{
                user.getId();
                user.getNome();
                user.getCpf();
                user.getEmail();
                user.getSenha();
                user.getTelefone();
                user.getTipoUsuario();

                usuarioDAO.addUsuario(user);
            }
            catch(IllegalStateException i){
                throw new IllegalArgumentException(i.getMessage());
            }
            catch(Exception e){
                throw new IllegalArgumentException("um erro inesperado ocorreu ao tentar acessar o id do usuário passado como parâmetro: " + e.getMessage());
            }
        } else{
            throw new IllegalArgumentException("o usuário passado como parâmetro é nulo");
        }
    }

    public void removeUsuario(UsuarioInterface user) throws IllegalArgumentException{
        if(user != null){
            try{
                user.getId();
                usuarioDAO.removeUsuario(user);
            }
            catch(IllegalStateException i){
                throw new IllegalArgumentException(i.getMessage());
            }
            catch(Exception e){
                throw new IllegalArgumentException("um erro inesperado ocorreu ao tentar acessar o id do usuário passado como parâmetro: " + e.getMessage());
            }
        } else{
            throw new IllegalArgumentException("o usuário passado como parâmetro é nulo");
        }
    }

    public UsuarioInterface getUsuario(UsuarioInterface user) throws IllegalArgumentException{
        if(user != null){
            try{
                user.getId();
                return usuarioDAO.getUsuario(user);
            }
            catch(IllegalStateException i){
                throw new IllegalArgumentException(i.getMessage());
            }
            catch(Exception e){
                throw new IllegalArgumentException("um erro inesperado ocorreu ao tentar acessar o id do usuário passado como parâmetro: " + e.getMessage());
            }
        } else{
            throw new IllegalArgumentException("o usuário passado como parâmetro é nulo");
        }
    }

    public UsuarioInterface[] getUsuarios() throws IllegalStateException{
        UsuarioInterface[] usuarios = usuarioDAO.getUsuarios();
        if(usuarios != null){
            return usuarios;
        } else{
            throw new IllegalStateException("algo de errado ocorreu na definição da lista de usuários desse objeto");
        }
    }

    public UsuarioService(UsuarioInterface sindico) throws IllegalArgumentException{
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
