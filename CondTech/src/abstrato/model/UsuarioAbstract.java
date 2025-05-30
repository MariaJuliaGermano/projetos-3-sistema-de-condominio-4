package abstrato.model;

abstract public class UsuarioAbstract {
    abstract public void setNome(String novoNome) throws IllegalArgumentException;
    abstract public void setCpf(String novoCpf) throws IllegalArgumentException;
    abstract public void setEmail(String novoEmail) throws IllegalArgumentException;
    abstract public void setSenha(String novaSenha) throws IllegalArgumentException;
    abstract public void setTelefone(String novoTelefone) throws IllegalArgumentException;
    abstract public void setTipoUsuario(String novoTipoUsuario) throws IllegalArgumentException;
    abstract public void setAdmin(Boolean admin) throws IllegalArgumentException;
    abstract public String getId() throws IllegalStateException;
    abstract public String getNome() throws IllegalStateException;
    abstract public Long getCpf() throws IllegalStateException;
    abstract public String getEmail() throws IllegalStateException;
    abstract public String getSenha() throws IllegalStateException;
    abstract public Long getTelefone() throws IllegalStateException;
    abstract public String getTipoUsuario() throws IllegalStateException;
    abstract public Boolean getAdmin() throws IllegalArgumentException;
}