import java.util.ArrayList;
import java.util.List;

public class ClienteRepositoryEmMemoria implements IClienteRepository {
    
    private List<Cliente> clientes;

    public ClienteRepositoryEmMemoria() {
        this.clientes = new ArrayList<>();
    }

    @Override
    public void cadastrar(Cliente cliente) {
        //Verificação para ter certeza que o cliente exista (não é nulo)
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não pode ser nulo para cadastro.");
        }
        this.clientes.add(cliente);
    }

    @Override
    public List<Cliente> getClientes() {
        // Retorna uma cópia para evitar modificação externa
        return new ArrayList<>(this.clientes);
    }
}