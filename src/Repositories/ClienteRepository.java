package Repositories;

import model.Cliente;
import java.util.ArrayList;
import java.util.List;


public class ClienteRepository {

    private ArrayList<Cliente> clientes;

    public ClienteRepository() {
        clientes = new ArrayList<>();
    }

    public void guardar(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente buscarPorId(String idCliente) {

        for (Cliente cliente : clientes) {

            if (cliente.getIdCliente().equalsIgnoreCase(idCliente)) {
                return cliente;
            }
        }

        return null;
    }

    public ArrayList<Cliente> listar() {
        return clientes;
    }
}