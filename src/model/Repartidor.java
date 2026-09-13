package model;

public class Repartidor {
    private String idRepartidor;
    private String nombre;
    private String telefono;
    private boolean disponible;
    private Vehiculo vehiculoAsignado;

    public Repartidor() {}

    public Repartidor(String idRepartidor, String nombre, String telefono, boolean disponible, Vehiculo vehiculoAsignado) {
        this.idRepartidor = idRepartidor;
        this.nombre = nombre;
        this.telefono = telefono;
        this.disponible = disponible;
        this.vehiculoAsignado = vehiculoAsignado;
    }

    public String getIdRepartidor() { return idRepartidor; }
    public void setIdRepartidor(String idRepartidor) { this.idRepartidor = idRepartidor; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    public Vehiculo getVehiculoAsignado() { return vehiculoAsignado; }
    public void setVehiculoAsignado(Vehiculo vehiculoAsignado) { this.vehiculoAsignado = vehiculoAsignado; }
}