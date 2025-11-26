import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection recuperarConexao() {
        try {
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/sistema_entregas_drones?useTimezone=true&serverTimezone=UTC", 
                "root", 
                ""); 
            // TODO: Professor, configure a senha do seu banco aqui antes de rodar!
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar no banco: " + e.getMessage(), e);
        }
    }
}