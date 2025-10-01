public class Entrega {
	
    private String destino;
    private Pacote pacote;
    private Cliente cliente;
    private Drone drone;
    
	public Entrega(String destino, Pacote pacote, Cliente cliente, Drone drone) {
		this.destino = destino;
		this.pacote = pacote;
		this.cliente = cliente;
		this.drone = drone;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Pacote getPacote() {
		return pacote;
	}

	public void setPesoDoPacote(Pacote pacote) {
		this.pacote = pacote;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Drone getDrone() {
		return drone;
	}

	public void setDrone(Drone drone) {
		this.drone = drone;
	}

	@Override
	public String toString() {
		return "Entrega [destino=" + destino + ", pacote=" + pacote + ", cliente=" + cliente + ", drone=" + drone + "]";
	}

	
}
