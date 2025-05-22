import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.Conection;

public class teste {
    public static void main(String[] args) {
        String sql = "INSERT INTO USUARIO_TESTE (ID_USUARIO, NOME, SENHA, MENSAGEM) VALUES(?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = Conection.getConnection()
                                            .prepareStatement(sql);

            ps.setString(1, "testeDeId");
            ps.setString(2, "Usuario Teste");
            ps.setString(3, "testeDeSenha");
            ps.setString(4, "isso é um teste de banco de dados");

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
