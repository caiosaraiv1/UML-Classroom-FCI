import java.time.LocalDateTime;

public class RegistroDeEntrega {

	private Entrega entrega;
	private LocalDateTime dataHoraRegistro;
	
	public RegistroDeEntrega(Entrega entrega) {
		this.entrega = entrega;
		this.dataHoraRegistro = LocalDateTime.now();
	}

	public Entrega getEntrega() {
		return entrega;
	}

	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}

	public LocalDateTime getDataHoraRegistro() {
		return dataHoraRegistro;
	}

	public void setDataHoraRegistro(LocalDateTime dataHoraRegistro) {
		this.dataHoraRegistro = dataHoraRegistro;
	}

	@Override
	public String toString() {
		return "RegistroDeEntrega [entrega=" + entrega + ", dataHoraRegistro=" + dataHoraRegistro + "]";
	}
}
