package repository;

import abstrato.repository.MensagemRepositoryAbstract;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.Conexao;
import java.util.ArrayList;
import java.util.List;

import model.Mensagem;

public class MensagemRepository extends MensagemRepositoryAbstract{
    private Connection cnn;
    private static final String CHAT_GRUPO = "CHAT_CONDOMINIO"; 

    public MensagemRepository() {
        try {
            this.cnn = Conexao.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void adicionarMensagem(Mensagem mensagem) {
        String sql = "INSERT INTO mensagens (id, remetente, destinatario, conteudo, dataHora, lida) VALUES(?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = cnn.prepareStatement(sql);

            ps.setString(1, mensagem.getId());
            ps.setString(2, mensagem.getRemetente());
            ps.setString(3, mensagem.getDestinatario());
            ps.setString(4, mensagem.getConteudo());
            ps.setString(5, mensagem.getDataHora().toString());
            ps.setBoolean(6, mensagem.isLida());

            ps.execute();
            ps.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Mensagem> listarMensagensGrupo() {
        String sql = "SELECT * FROM mensagens";
        List<Mensagem> mensagens = new ArrayList<>();

        try {
            PreparedStatement ps = cnn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                mensagens.add(
                    new Mensagem(
                        rs.getString("id"),
                        rs.getString("remetente"),
                        rs.getString("destinatario"),
                        rs.getString("conteudo"),
                        rs.getString("dataHora")
                    )
                );
            }
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mensagens;
    }
    
    public static String getIdGrupo() {
        return CHAT_GRUPO;
    }
}