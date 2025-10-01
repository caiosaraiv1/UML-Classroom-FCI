import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeDrones {

	public List<Drone> frotaDeDrones;
	
	public GerenciadorDeDrones() {
		this.frotaDeDrones = new ArrayList<>();
	}

	public List<Drone> getFrotaDeDrones() {
		return frotaDeDrones;
	}

	public void setFrotaDeDrones(List<Drone> frotaDeDrones) {
		this.frotaDeDrones = frotaDeDrones;
	}
	
	public void adicionarDrones(Drone drone) {
		this.frotaDeDrones.add(drone);
	}
	
	public Drone encontrarDrone(double pesoDoPacote) {
		for (Drone drone : frotaDeDrones) {
			if (drone.isDisponivel() && drone.podeCarregar(pesoDoPacote)) {
				return drone;
			}
		}
		return null;
	}
}

