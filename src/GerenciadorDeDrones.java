import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeDrones implements IGerenciadorDeDrones {

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
    
    @Override
    public void adicionarDrones(Drone drone) {
        this.frotaDeDrones.add(drone);
    }
    
    @Override
    public Drone encontrarDrone(double pesoDoPacote) {
        for (Drone drone : frotaDeDrones) {
            // ATENÇÃO: Corrigindo o bug lógico do original
            // O drone DEVE ter capacidade MAIOR ou IGUAL ao peso.
            if (drone.isDisponivel() && drone.podeCarregar(pesoDoPacote)) {
                return drone;
            }
        }
        return null;
    }
}