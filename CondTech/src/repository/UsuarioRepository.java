package repository;

import abstrato.repository.UsuarioRepositoryAbstract;

import java.util.ArrayList;
import java.util.List;
import connection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuario;

public class UsuarioRepository extends UsuarioRepositoryAbstract{
    
    private Connection cnn;

    public UsuarioRepository() {
        try {
            this.cnn = Conexao.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
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

    @Override
    public Usuario buscarPorNome(String Nome) {
        String sql = "SELECT * FROM usuarios WHERE NOME = ?";
        try {
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, Nome);

            ResultSet rs =  ps.executeQuery();
            
            if(rs.next()){
                String tipoMorador = rs.getString("tipoUsuario");
                String temp;

                switch (tipoMorador) {
                    case "Morador":
                        temp = "1";
                        break;
                    case "Síndico":
                        temp = "2";
                        break;
                    case "Funcionário":
                        temp = "3";
                        break;   
                    default:
                        temp = null;
                        break;
                }
                
                Usuario user = new Usuario(rs.getString("id"), rs.getString("nome"), rs.getString("cpf"), rs.getString("email"), rs.getString("senha"), rs.getString("telefone"), temp, rs.getBoolean("adm"));
                
                return user;
            } else{
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Usuario> listarUsuarios() {
        String sql = "SELECT * FROM usuarios";
        List<Usuario> usuarios = new ArrayList<>();

        try {
            PreparedStatement ps = cnn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                String tipoMorador = rs.getString("tipoUsuario");
                String temp;

                switch (tipoMorador) {
                    case "Morador":
                        temp = "1";
                        break;
                    case "Síndico":
                        temp = "2";
                        break;
                    case "Funcionário":
                        temp = "3";
                        break;   
                    default:
                        temp = null;
                        break;
                }

                usuarios.add(
                    new Usuario(
                        rs.getString("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getString("telefone"),
                        temp,
                        rs.getBoolean("adm")
                    )
                );
            }
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }
}
