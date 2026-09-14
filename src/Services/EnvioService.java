package Services;

import model.Envio;
import model.HistorialEstado;


import Repositories.EnvioRepository;

import java.util.ArrayList;

public class EnvioService {

    private EnvioRepository envioRepository;

    public EnvioService() {
        envioRepository = new EnvioRepository();
    }

    public boolean registrarEnvio(Envio envio) {

        if (envio == null) {
            return false;
        }

        if (envioRepository.buscarPorGuia(envio.getNumeroGuia()) != null) {
            return false;
        }

        envioRepository.guardar(envio);

        return true;
    }

    public Envio buscarEnvio(String numeroGuia) {
        return envioRepository.buscarPorGuia(numeroGuia);
    }

    public ArrayList<Envio> listarEnvios() {
        return envioRepository.listar();
    }

    public boolean actualizarEstado(
            String numeroGuia,
            HistorialEstado historial) {

        Envio envio = envioRepository.buscarPorGuia(numeroGuia);

        if (envio == null || historial == null) {
            return false;
        }

        envio.agregarHistorial(historial);

        return true;
    }
}
