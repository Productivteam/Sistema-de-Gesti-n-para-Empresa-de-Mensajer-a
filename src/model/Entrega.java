package model;

import java.time.LocalDateTime;

public class Entrega {
    private String idEntrega;
    private Envio envio;
    private Repartidor repartidor;
    private LocalDateTime fechaHoraEntrega;
    private String nombreReceptor;
    private String firmaDigital;
    private boolean exitosa;

    public Entrega() {}

    public Entrega(String idEntrega, Envio envio, Repartidor repartidor, String nombreReceptor, String firmaDigital, boolean exitosa) {
        this.idEntrega = idEntrega;
        this.envio = envio;
        this.repartidor = repartidor;
        this.nombreReceptor = nombreReceptor;
        this.firmaDigital = firmaDigital;
        this.exitosa = exitosa;
        this.fechaHoraEntrega = LocalDateTime.now();
    }

    public String getIdEntrega() { return idEntrega; }
    public void setIdEntrega(String idEntrega) { this.idEntrega = idEntrega; }

    public Envio getEnvio() { return envio; }
    public void setEnvio(Envio envio) { this.envio = envio; }

    public Repartidor getRepartidor() { return repartidor; }
    public void setRepartidor(Repartidor repartidor) { this.repartidor = repartidor; }

    public LocalDateTime getFechaHoraEntrega() { return fechaHoraEntrega; }
    public void setFechaHoraEntrega(LocalDateTime fechaHoraEntrega) { this.fechaHoraEntrega = fechaHoraEntrega; }

    public String getNombreReceptor() { return nombreReceptor; }
    public void setNombreReceptor(String nombreReceptor) { this.nombreReceptor = nombreReceptor; }

    public String getFirmaDigital() { return firmaDigital; }
    public void setFirmaDigital(String firmaDigital) { this.firmaDigital = firmaDigital; }

    public boolean isExitosa() { return exitosa; }
    public void setExitosa(boolean exitosa) { this.exitosa = exitosa; }
}