package backend.backsoft.dto;

public class RecetasGuardadasDTO {
    private Integer recetasGuardadasId;
    private Integer userId;
    private Integer recetaId;
    private java.time.LocalDateTime fechaHora;

    // Constructor sin argumentos
    public RecetasGuardadasDTO() {
    }

    // Constructor con argumentos
    public RecetasGuardadasDTO(Integer recetasGuardadasId, Integer userId, Integer recetaId, java.time.LocalDateTime fechaHora) {
        this.recetasGuardadasId = recetasGuardadasId;
        this.userId = userId;
        this.recetaId = recetaId;
        this.fechaHora = fechaHora;
    }

    // Getters y setters
    public Integer getRecetasGuardadasId() {
        return recetasGuardadasId;
    }

    public void setRecetasGuardadasId(Integer recetasGuardadasId) {
        this.recetasGuardadasId = recetasGuardadasId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRecetaId() {
        return recetaId;
    }

    public void setRecetaId(Integer recetaId) {
        this.recetaId = recetaId;
    }

    public java.time.LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(java.time.LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    // toString, equals y hashCode pueden ser generados automáticamente por el IDE si son necesarios.
}
