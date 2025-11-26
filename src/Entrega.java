public class Entrega {
	
	private int id;
    private String destino;
    private Pacote pacote;
    private Cliente cliente;
    private Drone drone;
    
	public Entrega(String destino, Pacote pacote, Cliente cliente, Drone drone) {
		//setter para validar o destino na criação
		setDestino(destino);
		this.pacote = pacote;
		this.cliente = cliente;
		this.drone = drone;
	}
	
	public int getId() {
	    return id;
	}

	public void setId(int id) {
	    this.id = id;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		// destino não pode ser nulo ou vazio
		if (destino == null || destino.trim().isEmpty()) {
			throw new IllegalArgumentException("Destino inválido: não pode ser vazio.");
		}
		this.destino = destino.trim(); // ADICIONADO: Remove espaços em branco
	}
	
	public Pacote getPacote() {
		return pacote;
	}

	public void setPacote(Pacote pacote) {
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
	
}
