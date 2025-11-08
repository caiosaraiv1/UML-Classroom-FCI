public class Pacote {
	
	private int ID;
    private double peso;
    
	public Pacote(int iD, double peso) {
		this.ID = iD;
		this.peso = peso;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		this.ID = iD;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException("O peso deve ser positivo.");
        }
        this.peso = peso;
    }

	@Override
	public String toString() {
		return "Pacote [ID=" + ID + ", peso=" + peso + "]";
	}
}
