package Services;

import model.Vehiculo;
import Repositories.VehiculoRepository;

import java.util.ArrayList;

public class VehiculoService {

    private VehiculoRepository vehiculoRepository;

    public VehiculoService() {
        vehiculoRepository = new VehiculoRepository();
    }

    public boolean registrarVehiculo(Vehiculo vehiculo) {

        if (vehiculo == null) {
            return false;
        }

        if (vehiculoRepository.buscarPorPlaca(
                vehiculo.getPlaca()) != null) {

            return false;
        }

        vehiculoRepository.guardar(vehiculo);

        return true;
    }

    public Vehiculo buscarVehiculo(String placa) {
        return vehiculoRepository.buscarPorPlaca(placa);
    }

    public ArrayList<Vehiculo> listarVehiculos() {
        return vehiculoRepository.listar();
    }
}
