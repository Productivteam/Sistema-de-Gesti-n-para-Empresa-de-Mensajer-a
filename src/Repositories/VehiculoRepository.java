package Repositories;

import model.Vehiculo;
import java.util.ArrayList;

public class VehiculoRepository {

    private ArrayList<Vehiculo> vehiculos;

    public VehiculoRepository() {
        vehiculos = new ArrayList<>();
    }

    public void guardar(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    public Vehiculo buscarPorPlaca(String placa) {

        for (Vehiculo vehiculo : vehiculos) {

            if (vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                return vehiculo;
            }
        }

        return null;
    }

    public ArrayList<Vehiculo> listar() {
        return vehiculos;
    }
}