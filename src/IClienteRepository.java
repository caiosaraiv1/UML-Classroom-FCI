import java.util.List;

public interface IClienteRepository {

    void cadastrar(Cliente cliente);

    List<Cliente> getClientes();
}