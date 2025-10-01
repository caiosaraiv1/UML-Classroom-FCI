import java.util.ArrayList;
import java.util.List;

public class Sistema {
	
	private List<Cliente> clientes;
	private GerenciadorDeDrones gerenciadorDeDrones;
	private HistoricoDeEntregas historicoDeEntregas;
	
	public Sistema() {
		this.clientes = new ArrayList<>();
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public GerenciadorDeDrones getGerenciadorDeDrones() {
		return gerenciadorDeDrones;
	}

	public void setGerenciadorDeDrones(GerenciadorDeDrones gerenciadorDeDrones) {
		this.gerenciadorDeDrones = gerenciadorDeDrones;
	}

	public HistoricoDeEntregas getHistoricoDeEntregas() {
		return historicoDeEntregas;
	}

	public void setHistoricoDeEntregas(HistoricoDeEntregas historicoDeEntregas) {
		this.historicoDeEntregas = historicoDeEntregas;
	}
	
	public void cadastrarCliente(Cliente cliente) {
		this.clientes.add(cliente);
	}
	
	/* TODO
	public String solicitarEntrega();
	*/

}
