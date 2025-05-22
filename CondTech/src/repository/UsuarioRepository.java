package repository;
import java.util.ArrayList;
import java.util.List;
import connection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuario;

public class UsuarioRepository {
    
    private Connection cnn;

    public UsuarioRepository() {
        try {
            this.cnn = Conexao.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void adicionarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (id, nome, cpf, email, senha, telefone, tipoUsuario, adm) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = cnn.prepareStatement(sql);

            ps.setString(1, usuario.getId());
            ps.setString(2, usuario.getNome());
            ps.setLong(3, usuario.getCpf());
            ps.setString(4, usuario.getEmail());
            ps.setString(5, usuario.getSenha());
            ps.setLong(6, usuario.getTelefone());
            ps.setString(7, usuario.getTipoUsuario());
            ps.setBoolean(8, usuario.getAdmin());

            ps.execute();
            ps.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Usuario buscarPorNome(String Nome) {
        String sql = "SELECT * FROM usuarios WHERE NOME = ?";
        try {
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, Nome);

            ResultSet rs =  ps.executeQuery();
            ps.close();

            Usuario user = new Usuario(rs.getString("nome"), rs.getString("cpf"), rs.getString("email"), rs.getString("senha"), rs.getString("telefone"), rs.getString("tipoUsuario"), rs.getBoolean("adm"));
            return user;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Usuario> listarUsuarios() {
        String sql = "SELECT * FROM usuarios";
        List<Usuario> usuarios = new ArrayList<>();

        try {
            PreparedStatement ps = cnn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ps.close();

            while(rs.next()){
                usuarios.add(new Usuario(rs.getString("nome"), rs.getString("cpf"), rs.getString("email"), rs.getString("senha"), rs.getString("telefone"), rs.getString("tipoUsuario"), rs.getBoolean("adm")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }
}
