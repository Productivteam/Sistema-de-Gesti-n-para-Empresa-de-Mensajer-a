package model;

import java.time.LocalDateTime;

public class HistorialEstado {
    private String idHistorial;
    private EstadoEnvio estado;
    private LocalDateTime fechaHora;
    private String comentario;

    public HistorialEstado() {}

    public HistorialEstado(String idHistorial, EstadoEnvio estado, LocalDateTime fechaHora, String comentario) {
        this.idHistorial = idHistorial;
        this.estado = estado;
        this.fechaHora = fechaHora;
        this.comentario = comentario;
    }

    public String getIdHistorial() { return idHistorial; }
    public void setIdHistorial(String idHistorial) { this.idHistorial = idHistorial; }

    public EstadoEnvio getEstado() { return estado; }
    public void setEstado(EstadoEnvio estado) { this.estado = estado; }

    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }

    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }
}