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
        // A para 'cliente' ser nulo
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente a ser cadastrado não pode ser nulo.");
        }
        this.clienteRepository.cadastrar(cliente);
    }

    public Entrega solicitarEntrega(Cliente cliente, String destino, double pesoDoPacote) {
        
        try {
            // 1. Validação Inicial
            if (cliente == null) {
                throw new IllegalArgumentException("Cliente não pode ser nulo para solicitar entrega.");
            }
            
            // A criação de Pacote e Entrega chama os setters, que fazem a validação de peso e destino.
            Pacote pacote = new Pacote(1, pesoDoPacote); 
            Entrega novaEntrega = new Entrega(destino, pacote, cliente, null); // drone é null inicialmente
            
            // 2. Atribuir Drone
            System.out.println("Buscando drone para " + pesoDoPacote + "kg...");
            Drone drone = gerenciadorDeDrones.encontrarDrone(pacote.getPeso());
            
            if (drone == null) {
                // Erro caso não haja drone disponível
                System.err.println("Falha: Nenhum drone disponível ou adequado.");
                throw new IllegalStateException("Nenhum drone disponível ou adequado no momento.");
            }
            
            // Sucesso na atribuição
            System.out.println("Atribuindo entrega ao Drone " + drone.getId());
            novaEntrega.setDrone(drone);
            
            // Atualiza o Status do Drone
            drone.setStatus(StatusDrone.EM_ENTREGA);
            
            // 3. Registro da Operação
            historicoDeEntregas.registrarEntrega(novaEntrega);
            
            System.out.println("Sucesso: Entrega agendada com Drone " + drone.getId());
            return novaEntrega;
            
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.err.println("Falha controlada: " + e.getMessage());
            throw e; // Relança a exceção de negócio para o chamador
            
        } catch (Exception e) {
            System.err.println("ERRO INESPERADO no sistema: " + e.toString());
            // Lança um erro genérico
            throw new RuntimeException("Erro inesperado no processamento da solicitação.", e);
        }
    }
}