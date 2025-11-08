import java.util.List;

public class Sistema {
    
    private IClienteRepository clienteRepository;
    private IGerenciadorDeDrones gerenciadorDeDrones;
    private IHistoricoDeEntregas historicoDeEntregas;
    
    public Sistema(IClienteRepository clienteRepository, 
                   IGerenciadorDeDrones gerenciadorDeDrones, 
                   IHistoricoDeEntregas historicoDeEntregas) {
                       
        this.clienteRepository = clienteRepository;
        this.gerenciadorDeDrones = gerenciadorDeDrones;
        this.historicoDeEntregas = historicoDeEntregas;
    }

    public List<Cliente> getClientes() {
        return clienteRepository.getClientes();
    }

    public IGerenciadorDeDrones getGerenciadorDeDrones() {
        return gerenciadorDeDrones;
    }

    public IHistoricoDeEntregas getHistoricoDeEntregas() {
        return historicoDeEntregas;
    }
    
    public void cadastrarCliente(Cliente cliente) {
        this.clienteRepository.cadastrar(cliente);
    }
    
    
    public String solicitarEntrega(Cliente cliente, String destino, double pesoDoPacote) {
        
        System.out.println("Buscando drone para " + pesoDoPacote + "kg...");
        Drone drone = gerenciadorDeDrones.encontrarDrone(pesoDoPacote);
        
        if (drone == null) {
            System.out.println("Nenhum drone disponível.");
            return "Falha: Nenhum drone disponível ou adequado.";
        }
        
        Pacote pacote = new Pacote(1, pesoDoPacote); 
        Entrega novaEntrega = new Entrega(destino, pacote, cliente, drone);
        
        System.out.println("Atribuindo entrega ao Drone " + drone.getId());
        drone.setStatus(StatusDrone.EM_ENTREGA);
        
        historicoDeEntregas.registrarEntrega(novaEntrega);
        
        System.out.println("Entrega registrada no histórico.");
        return "Sucesso: Entrega agendada com Drone " + drone.getId();
    }
}