public class HistoricoDeEntregas {
	
	private int ID;
    private String dadosDaEntrega;
    private Cliente cliente;
    private Drone drone;
    private Entrega entrega;
    
	public HistoricoDeEntregas(int iD, String dadosDaEntrega, Cliente cliente, Drone drone, Entrega entrega) {
		this.ID = iD;
		this.dadosDaEntrega = dadosDaEntrega;
		this.cliente = cliente;
		this.drone = drone;
		this.entrega = entrega;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		this.ID = iD;
	}

	public String getDadosDaEntrega() {
		return dadosDaEntrega;
	}

	public void setDadosDaEntrega(String dadosDaEntrega) {
		this.dadosDaEntrega = dadosDaEntrega;
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

	public Entrega getEntrega() {
		return entrega;
	}

	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}

	@Override
	public String toString() {
		return "HistoricoDeEntregas [ID=" + ID + ", dadosDaEntrega=" + dadosDaEntrega + ", cliente=" + cliente
				+ ", drone=" + drone + ", entrega=" + entrega + "]";
	}  
}
