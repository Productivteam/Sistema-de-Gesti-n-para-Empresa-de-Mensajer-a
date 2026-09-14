package Services;

import model.Entrega;
import Repositories.EntregaRepository;

import java.util.ArrayList;

public class EntregaService {

    private EntregaRepository entregaRepository;

    public EntregaService() {
        entregaRepository = new EntregaRepository();
    }

    public boolean registrarEntrega(Entrega entrega) {

        if (entrega == null) {
            return false;
        }

        if (entregaRepository.buscarPorId(
                entrega.getIdEntrega()) != null) {

            return false;
        }

        entregaRepository.guardar(entrega);

        return true;
    }

    public Entrega buscarEntrega(String idEntrega) {
        return entregaRepository.buscarPorId(idEntrega);
    }

    public ArrayList<Entrega> listarEntregas() {
        return entregaRepository.listar();
    }
}