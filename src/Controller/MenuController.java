package Controller;

import model.*;

import Services.ClienteService;
import Services.EnvioService;
import Services.RepartidorService;
import Services.VehiculoService;
import Services.EntregaService;

import java.time.LocalDateTime;


import java.util.Scanner;

public class MenuController {

    private Scanner scanner;
    private ClienteService clienteService;
    private EnvioService envioService;
    private RepartidorService repartidorService;
    private VehiculoService vehiculoService;
    private EntregaService entregaService;

    public MenuController() {
        scanner = new Scanner(System.in);

        clienteService = new ClienteService();
        envioService = new EnvioService();

        repartidorService = new RepartidorService();
        vehiculoService = new VehiculoService();
        entregaService = new EntregaService();
    }

    public void iniciar() {
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    registrarCliente();
                    break;

                case 2:
                    listarClientes();
                    break;

               case 3:
                   registrarEnvio();
                   break;

                case 4:
                    listarEnvios();
                    break;

                case 5:
                    actualizarEstadoEnvio();
                    break;

                case 6:
                    consultarHistorial();
                    break;

                 case 7:
                     registrarVehiculo();
                     break;

                 case 8:
                     listarVehiculos();
                     break;

                 case 9:
                     registrarRepartidor();
                     break;

                case 10:
                    listarRepartidores();
                    break;

                case 11:
                    registrarEntrega();
                    break;

                case 12:
                    listarEntregas();
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);
    }

    private void mostrarMenu() {
        System.out.println("\n=================================");
        System.out.println("      SISTEMA DE MENSAJERÍA");
        System.out.println("=================================");
        System.out.println("1. Registrar cliente");
        System.out.println("2. Listar clientes");
        System.out.println("3. Registrar envío");
        System.out.println("4. Listar envíos");
        System.out.println("5. Actualizar estado de envío");
        System.out.println("6. Consultar historial de envío");
        System.out.println("7. Registrar vehículo");
        System.out.println("8. Listar vehículos");
        System.out.println("9. Registrar repartidor");
        System.out.println("10. Listar repartidores");
        System.out.println("11. Registrar entrega");
        System.out.println("12. Listar entregas");
        System.out.println("0. Salir");
        System.out.println("=================================");
    }

    private void registrarCliente() {
        System.out.println("\n--- REGISTRAR CLIENTE ---");

        System.out.print("ID del cliente: ");
        String idCliente = scanner.nextLine();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();

        System.out.print("Correo electrónico: ");
        String email = scanner.nextLine();

        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();

        Cliente cliente = new Cliente(
                idCliente,
                nombre,
                telefono,
                email,
                direccion
        );

        boolean registrado = clienteService.registrarCliente(cliente);

        if (registrado) {
            System.out.println("Cliente registrado correctamente.");
        } else {
            System.out.println("No se pudo registrar el cliente.");
            System.out.println("Es posible que el ID ya exista.");
        }
    }

    private void listarClientes() {
        System.out.println("\n--- LISTA DE CLIENTES ---");

        if (clienteService.listarClientes().isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        for (Cliente cliente : clienteService.listarClientes()) {
            System.out.println("---------------------------------");
            System.out.println("ID: " + cliente.getIdCliente());
            System.out.println("Nombre: " + cliente.getNombre());
            System.out.println("Teléfono: " + cliente.getTelefono());
            System.out.println("Email: " + cliente.getEmail());
            System.out.println("Dirección: " + cliente.getDireccion());
        }
    }

    private void registrarEnvio() {
        System.out.println("\n--- REGISTRAR ENVÍO ---");

        System.out.print("Número de guía: ");
        String numeroGuia = scanner.nextLine();

        System.out.print("Peso en kg: ");
        double pesoKg = Double.parseDouble(scanner.nextLine());

        System.out.print("Costo del envío: ");
        double costo = Double.parseDouble(scanner.nextLine());

        System.out.print("ID del cliente: ");
        String idCliente = scanner.nextLine();

        Cliente cliente = clienteService.buscarCliente(idCliente);

        if (cliente == null) {
            System.out.println("No existe un cliente con ese ID.");
            return;
        }

        System.out.println("\n--- ORIGEN ---");

        System.out.print("Dirección: ");
        String direccionOrigen = scanner.nextLine();

        System.out.print("Ciudad: ");
        String ciudadOrigen = scanner.nextLine();

        System.out.print("Departamento: ");
        String departamentoOrigen = scanner.nextLine();

        System.out.print("Código postal: ");
        String codigoPostalOrigen = scanner.nextLine();

        Ubicacion origen = new Ubicacion(
                direccionOrigen,
                ciudadOrigen,
                departamentoOrigen,
                codigoPostalOrigen
        );

        System.out.println("\n--- DESTINO ---");

        System.out.print("Dirección: ");
        String direccionDestino = scanner.nextLine();

        System.out.print("Ciudad: ");
        String ciudadDestino = scanner.nextLine();

        System.out.print("Departamento: ");
        String departamentoDestino = scanner.nextLine();

        System.out.print("Código postal: ");
        String codigoPostalDestino = scanner.nextLine();

        Ubicacion destino = new Ubicacion(
                direccionDestino,
                ciudadDestino,
                departamentoDestino,
                codigoPostalDestino
        );

        Envio envio = new Envio(
                numeroGuia,
                pesoKg,
                costo,
                origen,
                destino,
                cliente
        );

        boolean registrado = envioService.registrarEnvio(envio);

        if (registrado) {
            System.out.println("Envío registrado correctamente.");
        } else {
            System.out.println("No se pudo registrar el envío.");
            System.out.println("Es posible que el número de guía ya exista.");
        }
    }

    private void listarEnvios() {
        System.out.println("\n--- LISTA DE ENVÍOS ---");

        if (envioService.listarEnvios().isEmpty()) {
            System.out.println("No hay envíos registrados.");
            return;
        }

        for (Envio envio : envioService.listarEnvios()) {
            System.out.println("---------------------------------");
            System.out.println("Número de guía: " + envio.getNumeroGuia());
            System.out.println("Cliente: " + envio.getCliente().getNombre());
            System.out.println("Peso: " + envio.getPesoKg() + " kg");
            System.out.println("Costo: $" + envio.getCosto());
            System.out.println("Estado: " + envio.getEstadoActual());

            System.out.println("Origen: "
                    + envio.getOrigen().getDireccion()
                    + ", "
                    + envio.getOrigen().getCiudad());

            System.out.println("Destino: "
                    + envio.getDestino().getDireccion()
                    + ", "
                    + envio.getDestino().getCiudad());

            System.out.println("Fecha de creación: "
                    + envio.getFechaCreacion());
        }
    }

    private void actualizarEstadoEnvio() {
        System.out.println("\n--- ACTUALIZAR ESTADO DEL ENVÍO ---");

        System.out.print("Número de guía: ");
        String numeroGuia = scanner.nextLine();

        Envio envio = envioService.buscarEnvio(numeroGuia);

        if (envio == null) {
            System.out.println("No existe un envío con esa guía.");
            return;
        }

        System.out.println("\nEstado actual: " + envio.getEstadoActual());

        System.out.println("\nSeleccione el nuevo estado:");
        System.out.println("1. REGISTRADO");
        System.out.println("2. EN_TRANSITO");
        System.out.println("3. EN_RUTA_ENTREGA");
        System.out.println("4. ENTREGADO");
        System.out.println("5. NO_ENTREGADO");

        int opcionEstado = leerEntero("Seleccione una opción: ");

        EstadoEnvio nuevoEstado;

        switch (opcionEstado) {
            case 1:
                nuevoEstado = EstadoEnvio.REGISTRADO;
                break;

            case 2:
                nuevoEstado = EstadoEnvio.EN_TRANSITO;
                break;

            case 3:
                nuevoEstado = EstadoEnvio.EN_RUTA_ENTREGA;
                break;

            case 4:
                nuevoEstado = EstadoEnvio.ENTREGADO;
                break;

            case 5:
                nuevoEstado = EstadoEnvio.NO_ENTREGADO;
                break;

            default:
                System.out.println("Estado no válido.");
                return;
        }

        System.out.print("Comentario: ");
        String comentario = scanner.nextLine();

        String idHistorial = "H" + System.currentTimeMillis();

        HistorialEstado historial = new HistorialEstado(
                idHistorial,
                nuevoEstado,
                LocalDateTime.now(),
                comentario
        );

        boolean actualizado = envioService.actualizarEstado(
                numeroGuia,
                historial
        );

        if (actualizado) {
            System.out.println("Estado actualizado correctamente.");
        } else {
            System.out.println("No se pudo actualizar el estado.");
        }
    }

    private void consultarHistorial() {
        System.out.println("\n--- HISTORIAL DEL ENVÍO ---");

        System.out.print("Número de guía: ");
        String numeroGuia = scanner.nextLine();

        Envio envio = envioService.buscarEnvio(numeroGuia);

        if (envio == null) {
            System.out.println("No existe un envío con esa guía.");
            return;
        }

        System.out.println("\nGuía: " + envio.getNumeroGuia());
        System.out.println("Estado actual: " + envio.getEstadoActual());

        if (envio.getHistorialEstados().isEmpty()) {
            System.out.println("Este envío todavía no tiene historial de estados.");
            return;
        }

        System.out.println("\n--- MOVIMIENTOS ---");

        for (HistorialEstado historial : envio.getHistorialEstados()) {
            System.out.println("---------------------------------");
            System.out.println("ID: " + historial.getIdHistorial());
            System.out.println("Estado: " + historial.getEstado());
            System.out.println("Fecha: " + historial.getFechaHora());
            System.out.println("Comentario: " + historial.getComentario());
        }
    }

    private void registrarVehiculo() {

        System.out.println("\n--- REGISTRAR VEHÍCULO ---");

        System.out.print("Placa: ");
        String placa = scanner.nextLine();

        System.out.print("Tipo: ");
        String tipo = scanner.nextLine();

        System.out.print("Capacidad Kg: ");
        double capacidad = Double.parseDouble(scanner.nextLine());

        System.out.print("Estado: ");
        String estado = scanner.nextLine();

        Vehiculo vehiculo = new Vehiculo(
                placa,
                tipo,
                capacidad,
                estado
        );

        boolean registrado =
                vehiculoService.registrarVehiculo(vehiculo);

        System.out.println(
                registrado
                        ? "Vehículo registrado."
                        : "No fue posible registrar."
        );
    }

    private void listarVehiculos() {

        System.out.println("\n--- VEHÍCULOS ---");

        for (Vehiculo vehiculo :
                vehiculoService.listarVehiculos()) {

            System.out.println("----------------------");
            System.out.println("Placa: "
                    + vehiculo.getPlaca());

            System.out.println("Tipo: "
                    + vehiculo.getTipo());

            System.out.println("Capacidad: "
                    + vehiculo.getCapacidadCargaKg());

            System.out.println("Estado: "
                    + vehiculo.getEstadoVehiculo());
        }
    }

    private void registrarRepartidor() {

        System.out.println("\n--- REGISTRAR REPARTIDOR ---");

        System.out.print("ID: ");
        String id = scanner.nextLine();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();

        System.out.print("Placa del vehículo: ");
        String placa = scanner.nextLine();

        Vehiculo vehiculo =
                vehiculoService.buscarVehiculo(placa);

        if (vehiculo == null) {
            System.out.println("Vehículo no encontrado.");
            return;
        }

        Repartidor repartidor = new Repartidor(
                id,
                nombre,
                telefono,
                true,
                vehiculo
        );

        boolean registrado =
                repartidorService.registrarRepartidor(repartidor);

        System.out.println(
                registrado
                        ? "Repartidor registrado."
                        : "No fue posible registrar."
        );
    }

    private void listarRepartidores() {

        System.out.println("\n--- REPARTIDORES ---");

        for (Repartidor repartidor :
                repartidorService.listarRepartidores()) {

            System.out.println("----------------------");

            System.out.println("ID: "
                    + repartidor.getIdRepartidor());

            System.out.println("Nombre: "
                    + repartidor.getNombre());

            System.out.println("Teléfono: "
                    + repartidor.getTelefono());

            System.out.println("Disponible: "
                    + repartidor.isDisponible());

            if (repartidor.getVehiculoAsignado() != null) {

                System.out.println("Vehículo: "
                        + repartidor
                        .getVehiculoAsignado()
                        .getPlaca());
            }
        }
    }

    private void registrarEntrega() {

        System.out.println("\n--- REGISTRAR ENTREGA ---");

        System.out.print("ID Entrega: ");
        String idEntrega = scanner.nextLine();

        System.out.print("Número de guía: ");
        String guia = scanner.nextLine();

        Envio envio = envioService.buscarEnvio(guia);

        if (envio == null) {
            System.out.println("Envío no encontrado.");
            return;
        }

        System.out.print("ID Repartidor: ");
        String idRepartidor = scanner.nextLine();

        Repartidor repartidor =
                repartidorService.buscarRepartidor(idRepartidor);

        if (repartidor == null) {
            System.out.println("Repartidor no encontrado.");
            return;
        }

        System.out.print("Nombre receptor: ");
        String receptor = scanner.nextLine();

        System.out.print("Firma digital: ");
        String firma = scanner.nextLine();

        System.out.print("¿Entrega exitosa? (true/false): ");
        boolean exitosa =
                Boolean.parseBoolean(scanner.nextLine());

        Entrega entrega = new Entrega(
                idEntrega,
                envio,
                repartidor,
                receptor,
                firma,
                exitosa
        );

        boolean registrada =
                entregaService.registrarEntrega(entrega);

        if (registrada) {

            if (exitosa) {

                HistorialEstado historial =
                        new HistorialEstado(
                                "H" + System.currentTimeMillis(),
                                EstadoEnvio.ENTREGADO,
                                LocalDateTime.now(),
                                "Entrega realizada"
                        );

                envioService.actualizarEstado(
                        guia,
                        historial
                );
            }

            System.out.println("Entrega registrada.");
        }
    }

    private void listarEntregas() {

        System.out.println("\n--- ENTREGAS ---");

        for (Entrega entrega :
                entregaService.listarEntregas()) {

            System.out.println("----------------------");

            System.out.println("ID: "
                    + entrega.getIdEntrega());

            System.out.println("Guía: "
                    + entrega.getEnvio()
                    .getNumeroGuia());

            System.out.println("Repartidor: "
                    + entrega.getRepartidor()
                    .getNombre());

            System.out.println("Receptor: "
                    + entrega.getNombreReceptor());

            System.out.println("Fecha: "
                    + entrega.getFechaHoraEntrega());

            System.out.println("Exitosa: "
                    + entrega.isExitosa());
        }
    }

    private int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                int numero = Integer.parseInt(scanner.nextLine());
                return numero;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }
    }
}
