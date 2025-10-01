public class Drone {
	
    private String id;
    private int statusDaBateria;
    private double capacidadeDeCarga;
    private boolean disponivel;
    
	public Drone(String id, int statusDaBateria, double capacidadeDeCarga, boolean disponivel) {
		this.id = id;
		this.statusDaBateria = statusDaBateria;
		this.capacidadeDeCarga = capacidadeDeCarga;
		this.disponivel = disponivel;
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
		this.statusDaBateria = statusDaBateria;
	}

	public double getCapacidadeDeCarga() {
		return capacidadeDeCarga;
	}

	public void setCapacidadeDeCarga(double capacidadeDeCarga) {
		this.capacidadeDeCarga = capacidadeDeCarga;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	
	public boolean podeCarregar(double pesoDoPacote) {
		return this.capacidadeDeCarga <= pesoDoPacote;
	}

	@Override
	public String toString() {
		return "Drone [id=" + id + ", statusDaBateria=" + statusDaBateria + ", capacidadeDeCarga=" + capacidadeDeCarga
				+ ", disponivel=" + disponivel + "]";
	} 
}
