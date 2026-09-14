package Services;

import model.Repartidor;
import model.Vehiculo;
import Repositories.RepartidorRepository;

import java.util.ArrayList;

public class RepartidorService {

    private RepartidorRepository repartidorRepository;

    public RepartidorService() {
        repartidorRepository = new RepartidorRepository();
    }

    public boolean registrarRepartidor(Repartidor repartidor) {

        if (repartidor == null) {
            return false;
        }

        if (repartidorRepository.buscarPorId(
                repartidor.getIdRepartidor()) != null) {

            return false;
        }

        repartidorRepository.guardar(repartidor);

        return true;
    }

    public Repartidor buscarRepartidor(String idRepartidor) {
        return repartidorRepository.buscarPorId(idRepartidor);
    }

    public ArrayList<Repartidor> listarRepartidores() {
        return repartidorRepository.listar();
    }

    public boolean asignarVehiculo(
            String idRepartidor,
            Vehiculo vehiculo) {

        Repartidor repartidor =
                repartidorRepository.buscarPorId(idRepartidor);

        if (repartidor == null || vehiculo == null) {
            return false;
        }

        repartidor.setVehiculoAsignado(vehiculo);

        return true;
    }
}