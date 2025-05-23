package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import connection.Conexao;
import model.Ocorrencia;

public class OcorrenciaRepository {

    private Connection cnn;

    public OcorrenciaRepository() {
        try {
            this.cnn = Conexao.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void adicionarOcorrencia(Ocorrencia ocorrencia) {
         String sql = "INSERT INTO ocorrencias (id, idMorador, dataRegistro, descricao, sttatus, anexos) VALUES(?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = cnn.prepareStatement(sql);

            ps.setString(1, ocorrencia.getId());
            ps.setString(2, ocorrencia.getIdMorador());
            ps.setDate(3, java.sql.Date.valueOf(ocorrencia.getDataRegistro()));
            ps.setString(4, ocorrencia.getDescricao());
            ps.setString(5, ocorrencia.getStatus());
            ps.setString(6, String.join(", ", ocorrencia.getAnexos()));

            ps.execute();
            ps.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Ocorrencia> listarOcorrencias() {
        String sql = "SELECT * FROM ocorrencias";
        List<Ocorrencia> ocorrencias = new ArrayList<>();

        try {
            PreparedStatement ps = cnn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                List<String> anexos = Arrays.asList(rs.getString("anexos"));
                ocorrencias.add(new Ocorrencia(rs.getString("id"), rs.getString("idMorador"), rs.getDate("dataRegistro").toLocalDate(), rs.getString("descricao"), rs.getString("sttatus"), anexos));
            }
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ocorrencias;
    }

}
