import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HistoricoDeEntregasBD implements IHistoricoDeEntregas {

    private ConnectionFactory connectionFactory;

    public HistoricoDeEntregasBD() {
        this.connectionFactory = new ConnectionFactory();
    }

    @Override
    public void registrarEntrega(Entrega entrega) {
        Connection conn = null;
        try {
            conn = connectionFactory.recuperarConexao();
            conn.setAutoCommit(false); // Inicia transação para garantir que salva tudo ou nada

            // 1. Salvar Pacote
            String sqlPacote = "INSERT INTO pacotes (peso) VALUES (?)";
            PreparedStatement psPacote = conn.prepareStatement(sqlPacote, Statement.RETURN_GENERATED_KEYS);
            psPacote.setDouble(1, entrega.getPacote().getPeso());
            psPacote.execute();
            
            ResultSet rsPacote = psPacote.getGeneratedKeys();
            if (rsPacote.next()) {
                entrega.getPacote().setID(rsPacote.getInt(1));
            }

            // 2. Salvar Entrega
            String sqlEntrega = "INSERT INTO entregas (destino, cliente_id, pacote_id, drone_id) VALUES (?, ?, ?, ?)";
            PreparedStatement psEntrega = conn.prepareStatement(sqlEntrega, Statement.RETURN_GENERATED_KEYS);
            psEntrega.setString(1, entrega.getDestino());
            psEntrega.setInt(2, entrega.getCliente().getID());
            psEntrega.setInt(3, entrega.getPacote().getID());
            psEntrega.setString(4, entrega.getDrone().getId());
            psEntrega.execute();

            ResultSet rsEntrega = psEntrega.getGeneratedKeys();
            if (rsEntrega.next()) {
                entrega.setId(rsEntrega.getInt(1));
            }
            
            // 3. Atualizar Status do Drone no Banco (para ocupado)
            String sqlDrone = "UPDATE drones SET status = ? WHERE id = ?";
            PreparedStatement psDrone = conn.prepareStatement(sqlDrone);
            psDrone.setString(1, StatusDrone.EM_ENTREGA.name()); // Ou o status atual do objeto
            psDrone.setString(2, entrega.getDrone().getId());
            psDrone.execute();

            // 4. Salvar no Histórico
            String sqlHistorico = "INSERT INTO historico_entregas (entrega_id, data_hora_registro) VALUES (?, NOW())";
            PreparedStatement psHistorico = conn.prepareStatement(sqlHistorico);
            psHistorico.setInt(1, entrega.getId());
            psHistorico.execute();

            conn.commit(); // Confirma todas as alterações
            psPacote.close();
            psEntrega.close();
            psDrone.close();
            psHistorico.close();

        } catch (SQLException e) {
            try {
                if (conn != null) conn.rollback(); // Desfaz se der erro
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            throw new RuntimeException("Erro ao registrar entrega: " + e.getMessage());
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<RegistroDeEntrega> listarPorCliente(Cliente cliente) {
        // Implementação simplificada: buscaria as entregas usando JOINs SQL
        // Para brevidade, você pode implementar depois se precisar dessa funcionalidade específica na UI
        return new ArrayList<>(); 
    }

    @Override
    public List<RegistroDeEntrega> getRegistros() {
        return new ArrayList<>();
    }
}