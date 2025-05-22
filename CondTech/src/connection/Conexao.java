package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String url = "jdbc:mysql://localhost:3306/condtech_db";
    private static final String user = "root";
    private static final String password = "root";
    private static Connection connection;

    public static Connection getConnection() throws SQLException{
        try{
            if(connection == null){
                connection = DriverManager.getConnection(url, user, password);
            }
            return connection;
        }
        catch(SQLException e){
            throw new SQLException(e.getSQLState());
        }
    }
}
