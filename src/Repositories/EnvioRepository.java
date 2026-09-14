package Repositories;

import model.Envio;
import java.util.ArrayList;

public class EnvioRepository {

    private ArrayList<Envio> envios;

    public EnvioRepository() {
        envios = new ArrayList<>();
    }

    public void guardar(Envio envio) {
        envios.add(envio);
    }

    public Envio buscarPorGuia(String numeroGuia) {

        for (Envio envio : envios) {

            if (envio.getNumeroGuia().equalsIgnoreCase(numeroGuia)) {
                return envio;
            }
        }

        return null;
    }

    public ArrayList<Envio> listar() {
        return envios;
    }
}
