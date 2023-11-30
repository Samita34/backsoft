package backend.backsoft.dto;

public class CalificacionDTO {
    private Integer calificacionId;
    private Integer recetaId;
    private Integer userId;
    private Integer puntuacion;
    private java.time.LocalDateTime fechaHora;

    // Constructor sin argumentos
    public CalificacionDTO() {
    }

    // Constructor con argumentos
    public CalificacionDTO(Integer calificacionId, Integer recetaId, Integer userId, Integer puntuacion, java.time.LocalDateTime fechaHora) {
        this.calificacionId = calificacionId;
        this.recetaId = recetaId;
        this.userId = userId;
        this.puntuacion = puntuacion;
        this.fechaHora = fechaHora;
    }

    // Getters y setters
    public Integer getCalificacionId() {
        return calificacionId;
    }

    public void setCalificacionId(Integer calificacionId) {
        this.calificacionId = calificacionId;
    }

    public Integer getRecetaId() {
        return recetaId;
    }

    public void setRecetaId(Integer recetaId) {
        this.recetaId = recetaId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    public java.time.LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(java.time.LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    // toString, equals y hashCode pueden ser generados automáticamente por el IDE si son necesarios.
}
