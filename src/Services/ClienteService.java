package Services;

import model.Cliente;
import Repositories.ClienteRepository;

import java.util.ArrayList;

public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService() {
        clienteRepository = new ClienteRepository();
    }

    public boolean registrarCliente(Cliente cliente) {

        if (cliente == null) {
            return false;
        }

        if (clienteRepository.buscarPorId(cliente.getIdCliente()) != null) {
            return false;
        }

        clienteRepository.guardar(cliente);

        return true;
    }

    public Cliente buscarCliente(String idCliente) {
        return clienteRepository.buscarPorId(idCliente);
    }

    public ArrayList<Cliente> listarClientes() {
        return clienteRepository.listar();
    }
}
