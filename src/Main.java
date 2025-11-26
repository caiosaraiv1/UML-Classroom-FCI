public class Main {

    public static void main(String[] args) {
        System.out.println("=== Iniciando Sistema de Entregas ===");

        try {
            // 1. Instanciar os Repositórios que conectam no Banco de Dados
            IClienteRepository repoClientes = new ClienteRepositoryBD();
            IGerenciadorDeDrones repoDrones = new GerenciadorDeDronesBD();
            IHistoricoDeEntregas repoHistorico = new HistoricoDeEntregasBD();

            // 2. Inicializar o Sistema com as dependências
            Sistema sistema = new Sistema(repoClientes, repoDrones, repoHistorico);

            // ---------------------------------------------------------
            // PREPARAÇÃO DE DADOS (CENÁRIO DE TESTE)
            // ---------------------------------------------------------

            // 3. Vamos cadastrar um Drone de teste (se ele não existir, vai dar erro de chave duplicada na segunda execução, então tratamos isso)
            Drone droneTeste = new Drone("DRONE-ALPHA-01", 100, 10.0, StatusDrone.DISPONIVEL);
            try {
                System.out.println("Tentando cadastrar drone " + droneTeste.getId() + "...");
                repoDrones.adicionarDrones(droneTeste);
                System.out.println("-> Drone cadastrado com sucesso.");
            } catch (Exception e) {
                System.out.println("-> Aviso: O drone provavelmente já existe no banco. Seguindo o fluxo...");
            }

            // 4. Cadastrar um Cliente novo
            // Passamos ID 0 pois o banco de dados vai gerar o ID real (Auto Increment)
            Cliente novoCliente = new Cliente(0, "Maria Exemplo", "maria@teste.com", "Rua das Laranjeiras, 404");
            sistema.cadastrarCliente(novoCliente);
            System.out.println("-> Cliente cadastrado! ID gerado pelo banco: " + novoCliente.getID());

            // ---------------------------------------------------------
            // TESTE DE FLUXO PRINCIPAL: SOLICITAR ENTREGA
            // ---------------------------------------------------------
            System.out.println("\n--- Solicitando Entrega ---");
            
            String destino = "Av. Paulista, 900";
            double pesoPacote = 2.5; // 2.5kg (O drone aguenta 10kg)

            // O método solicitarEntrega faz tudo: busca drone, atribui, salva entrega e histórico
            Entrega entregaRealizada = sistema.solicitarEntrega(novoCliente, destino, pesoPacote);

            System.out.println("\n=== SUCESSO! ENTREGA AGENDADA ===");
            System.out.println("ID da Entrega: " + entregaRealizada.getId());
            System.out.println("Cliente: " + entregaRealizada.getCliente().getNome());
            System.out.println("Drone Atribuído: " + entregaRealizada.getDrone().getId());
            System.out.println("Status do Drone agora: " + entregaRealizada.getDrone().getStatus());
            System.out.println("Destino: " + entregaRealizada.getDestino());

        } catch (Exception e) {
            System.err.println("\n--- ERRO NO SISTEMA ---");
            e.printStackTrace();
        }
    }
}