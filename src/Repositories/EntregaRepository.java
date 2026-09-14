package Repositories;

import model.Entrega;
import java.util.ArrayList;

public class EntregaRepository {

    private ArrayList<Entrega> entregas;

    public EntregaRepository() {
        entregas = new ArrayList<>();
    }

    public void guardar(Entrega entrega) {
        entregas.add(entrega);
    }

    public Entrega buscarPorId(String idEntrega) {

        for (Entrega entrega : entregas) {

            if (entrega.getIdEntrega().equalsIgnoreCase(idEntrega)) {
                return entrega;
            }
        }

        return null;
    }

    public ArrayList<Entrega> listar() {
        return entregas;
    }
}
