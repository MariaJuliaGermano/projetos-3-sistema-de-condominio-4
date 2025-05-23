package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import connection.Conexao;

import model.AreaReservada;

public class AreaReservadaRepository {
    
    private Connection cnn;

    public AreaReservadaRepository() {
        try {
            this.cnn = Conexao.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void adicionarAreaReservada(AreaReservada areaReservada) {
        String sql = "INSERT INTO reservas (id, idCondominio, idMorador, dataReserva, horarioReservado, sttatus) VALUES(?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = cnn.prepareStatement(sql);

            ps.setString(1, areaReservada.getId());
            ps.setString(2, areaReservada.getIdCondominio());
            ps.setString(3, areaReservada.getIdMorador());
            ps.setDate(4, java.sql.Date.valueOf(areaReservada.getDataReserva()));
            ps.setTime(5, java.sql.Time.valueOf(areaReservada.getHorarioReservado()));
            ps.setString(6, areaReservada.getStatus());

            ps.execute();
            ps.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<AreaReservada> listarAreaReservadas() {
        String sql = "SELECT * FROM reservas";
        List<AreaReservada> reservas = new ArrayList<>();

        try {
            PreparedStatement ps = cnn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                reservas.add(new AreaReservada(rs.getString("id"), rs.getString("idCondominio"), rs.getString("idMorador"), rs.getDate("dataReserva").toLocalDate(), rs.getTime("horarioReservado").toLocalTime(), rs.getString("sttatus")));
            }
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reservas;
    }

}
