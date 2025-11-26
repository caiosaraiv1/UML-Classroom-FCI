import java.sql.*;

public class GerenciadorDeDronesBD implements IGerenciadorDeDrones {

    private ConnectionFactory connectionFactory;

    public GerenciadorDeDronesBD() {
        this.connectionFactory = new ConnectionFactory();
    }

    @Override
    public void adicionarDrones(Drone drone) {
        String sql = "INSERT INTO drones (id, status_bateria, capacidade_carga, status) VALUES (?, ?, ?, ?)";

        try (Connection conn = connectionFactory.recuperarConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, drone.getId());
            ps.setInt(2, drone.getStatusDaBateria());
            ps.setDouble(3, drone.getCapacidadeDeCarga());
            ps.setString(4, drone.getStatus().name());

            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar drone: " + e.getMessage());
        }
    }

    @Override
    public Drone encontrarDrone(double pesoDoPacote) {
        // Busca o primeiro drone DISPONIVEL que aguenta o peso
        String sql = "SELECT * FROM drones WHERE status = 'DISPONIVEL' AND capacidade_carga >= ? LIMIT 1";

        try (Connection conn = connectionFactory.recuperarConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDouble(1, pesoDoPacote);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Drone(
                        rs.getString("id"),
                        rs.getInt("status_bateria"),
                        rs.getDouble("capacidade_carga"),
                        StatusDrone.valueOf(rs.getString("status"))
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null; // Nenhum drone encontrado
    }
}