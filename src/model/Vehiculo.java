package model;

public class Vehiculo {
    private String placa;
    private String tipo;
    private double capacidadCargaKg;
    private String estadoVehiculo;

    public Vehiculo() {}

    public Vehiculo(String placa, String tipo, double capacidadCargaKg, String estadoVehiculo) {
        this.placa = placa;
        this.tipo = tipo;
        this.capacidadCargaKg = capacidadCargaKg;
        this.estadoVehiculo = estadoVehiculo;
    }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public double getCapacidadCargaKg() { return capacidadCargaKg; }
    public void setCapacidadCargaKg(double capacidadCargaKg) { this.capacidadCargaKg = capacidadCargaKg; }

    public String getEstadoVehiculo() { return estadoVehiculo; }
    public void setEstadoVehiculo(String estadoVehiculo) { this.estadoVehiculo = estadoVehiculo; }
}