package Repositories;

import model.Repartidor;
import java.util.ArrayList;

public class RepartidorRepository {

    private ArrayList<Repartidor> repartidores;

    public RepartidorRepository() {
        repartidores = new ArrayList<>();
    }

    public void guardar(Repartidor repartidor) {
        repartidores.add(repartidor);
    }

    public Repartidor buscarPorId(String idRepartidor) {

        for (Repartidor repartidor : repartidores) {

            if (repartidor.getIdRepartidor()
                    .equalsIgnoreCase(idRepartidor)) {

                return repartidor;
            }
        }

        return null;
    }

    public ArrayList<Repartidor> listar() {
        return repartidores;
    }
}
