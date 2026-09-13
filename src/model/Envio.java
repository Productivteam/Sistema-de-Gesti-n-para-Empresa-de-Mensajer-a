package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Envio {
    private String numeroGuia;
    private double pesoKg;
    private double costo;
    private LocalDateTime fechaCreacion;
    private Ubicacion origen;
    private Ubicacion destino;
    private EstadoEnvio estadoActual;
    private Cliente cliente;
    private Repartidor repartidorAsignado;
    private ArrayList<HistorialEstado> historialEstados;

    public Envio() {
        this.historialEstados = new ArrayList<>();
    }

    public Envio(String numeroGuia, double pesoKg, double costo, Ubicacion origen, Ubicacion destino, Cliente cliente) {
        this.numeroGuia = numeroGuia;
        this.pesoKg = pesoKg;
        this.costo = costo;
        this.origen = origen;
        this.destino = destino;
        this.cliente = cliente;
        this.fechaCreacion = LocalDateTime.now();
        this.estadoActual = EstadoEnvio.REGISTRADO;
        this.historialEstados = new ArrayList<>();
    }

    public String getNumeroGuia() { return numeroGuia; }
    public void setNumeroGuia(String numeroGuia) { this.numeroGuia = numeroGuia; }

    public double getPesoKg() { return pesoKg; }
    public void setPesoKg(double pesoKg) { this.pesoKg = pesoKg; }

    public double getCosto() { return costo; }
    public void setCosto(double costo) { this.costo = costo; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public Ubicacion getOrigen() { return origen; }
    public void setOrigen(Ubicacion origen) { this.origen = origen; }

    public Ubicacion getDestino() { return destino; }
    public void setDestino(Ubicacion destino) { this.destino = destino; }

    public EstadoEnvio getEstadoActual() { return estadoActual; }
    public void setEstadoActual(EstadoEnvio estadoActual) { this.estadoActual = estadoActual; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Repartidor getRepartidorAsignado() { return repartidorAsignado; }
    public void setRepartidorAsignado(Repartidor repartidorAsignado) { this.repartidorAsignado = repartidorAsignado; }

    public ArrayList<HistorialEstado> getHistorialEstados() { return historialEstados; }
    public void agregarHistorial(HistorialEstado historial) {
        this.historialEstados.add(historial);
        this.estadoActual = historial.getEstado();
    }
}