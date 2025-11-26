public class Drone {
	
    private String id;
    private int statusDaBateria;
    private double capacidadeDeCarga;
    private StatusDrone status;
    
	public Drone(String id, int statusDaBateria, double capacidadeDeCarga, StatusDrone status) {
		this.id = id;
		this.statusDaBateria = statusDaBateria;
		this.capacidadeDeCarga = capacidadeDeCarga;
		this.status = status; 
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getStatusDaBateria() {
		return statusDaBateria;
	}

	public void setStatusDaBateria(int statusDaBateria) {
        if (statusDaBateria < 0 || statusDaBateria > 100) {
            throw new IllegalArgumentException("Bateria inválida.");
        }
		this.statusDaBateria = statusDaBateria;
	}

	public double getCapacidadeDeCarga() {
		return capacidadeDeCarga;
	}

	public void setCapacidadeDeCarga(double capacidadeDeCarga) {
		this.capacidadeDeCarga = capacidadeDeCarga;
	}

	public boolean isDisponivel() {
		return this.status == StatusDrone.DISPONIVEL;
	}

	public StatusDrone getStatus() {
		return status;
	}

	public void setStatus(StatusDrone status) {
		this.status = status;
	}
	
	public boolean podeCarregar(double pesoDoPacote) {
        return this.capacidadeDeCarga >= pesoDoPacote;
    }

	@Override
	public String toString() {
		return "Drone [id=" + id + ", statusDaBateria=" + statusDaBateria + ", capacidadeDeCarga=" + capacidadeDeCarga
				+ ", status=" + status + "]"; // Campo 'disponivel' atualizado para 'status'
	} 
}