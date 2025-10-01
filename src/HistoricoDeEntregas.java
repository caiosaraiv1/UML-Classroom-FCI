import java.util.ArrayList;
import java.util.List;

public class HistoricoDeEntregas {
	
	private List<RegistroDeEntrega> registros;
	
	public HistoricoDeEntregas() {
		this.registros = new ArrayList<>();
	}

	public List<RegistroDeEntrega> getRegistros() {
		return registros;
	}

	public void setRegistros(List<RegistroDeEntrega> registros) {
		this.registros = registros;
	}
	
	/* TODO
	public void registrarEntrega();
	
	public List<RegistroDeEntrega> listarPorCliente();
	 */

	@Override
	public String toString() {
		return "HistoricoDeEntregas [registros=" + registros + "]";
	}
	
	
	
}
