import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HistoricoDeEntregas implements IHistoricoDeEntregas {
    
    private List<RegistroDeEntrega> registros;
    
    public HistoricoDeEntregas() {
        this.registros = new ArrayList<>();
    }

    @Override
    public List<RegistroDeEntrega> getRegistros() {
        return registros;
    }

    public void setRegistros(List<RegistroDeEntrega> registros) {
        this.registros = registros;
    }
    
    @Override
    public void registrarEntrega(Entrega entrega) {
        RegistroDeEntrega novoRegistro = new RegistroDeEntrega(entrega);
        this.registros.add(novoRegistro);
    }
    
    @Override
    public List<RegistroDeEntrega> listarPorCliente(Cliente cliente) {
        return this.registros.stream()
            .filter(registro -> registro.getEntrega().getCliente().equals(cliente))
            .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "HistoricoDeEntregas [registros=" + registros + "]";
    }
}