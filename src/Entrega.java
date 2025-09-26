public class Entrega {
	
    private String destino;
    private double pesoDoPacote;
    private Cliente cliente;
    private Drone drone;
    
	public Entrega(String destino, double pesoDoPacote, Cliente cliente, Drone drone) {
		this.destino = destino;
		this.pesoDoPacote = pesoDoPacote;
		this.cliente = cliente;
		this.drone = drone;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public double getPesoDoPacote() {
		return pesoDoPacote;
	}

	public void setPesoDoPacote(double pesoDoPacote) {
		this.pesoDoPacote = pesoDoPacote;
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
		return "Entrega [destino=" + destino + ", pesoDoPacote=" + pesoDoPacote + ", cliente=" + cliente + ", drone="
				+ drone + "]";
	}
}
