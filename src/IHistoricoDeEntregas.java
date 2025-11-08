import java.util.List;

public interface IHistoricoDeEntregas {

    
    void registrarEntrega(Entrega entrega);

    List<RegistroDeEntrega> listarPorCliente(Cliente cliente);
    
    List<RegistroDeEntrega> getRegistros();
}