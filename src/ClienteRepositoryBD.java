import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepositoryBD implements IClienteRepository {

    private ConnectionFactory connectionFactory;

    public ClienteRepositoryBD() {
        this.connectionFactory = new ConnectionFactory();
    }

    @Override
    public void cadastrar(Cliente cliente) {
        String sql = "INSERT INTO clientes (nome, email, endereco) VALUES (?, ?, ?)";

        try (Connection conn = connectionFactory.recuperarConexao();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEmail());
            ps.setString(3, cliente.getEndereco());

            ps.execute();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    cliente.setID(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Cliente> getClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT id, nome, email, endereco FROM clientes";

        try (Connection conn = connectionFactory.recuperarConexao();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Cliente c = new Cliente(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("endereco")
                );
                clientes.add(c);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clientes;
    }
}