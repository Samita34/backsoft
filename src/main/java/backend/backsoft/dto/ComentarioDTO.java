package backend.backsoft.dto;

public class ComentarioDTO {
    private Integer comentarioId;
    private Integer recetaId;
    private Integer userId;
    private String textoComentario;
    private java.time.LocalDateTime fechaHora;

    // Constructor sin argumentos
    public ComentarioDTO() {
    }

    // Constructor con argumentos
    public ComentarioDTO(Integer comentarioId, Integer recetaId, Integer userId, String textoComentario, java.time.LocalDateTime fechaHora) {
        this.comentarioId = comentarioId;
        this.recetaId = recetaId;
        this.userId = userId;
        this.textoComentario = textoComentario;
        this.fechaHora = fechaHora;
    }

    // Getters y setters
    public Integer getComentarioId() {
        return comentarioId;
    }

    public void setComentarioId(Integer comentarioId) {
        this.comentarioId = comentarioId;
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

    public String getTextoComentario() {
        return textoComentario;
    }

    public void setTextoComentario(String textoComentario) {
        this.textoComentario = textoComentario;
    }

    public java.time.LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(java.time.LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    // toString, equals y hashCode pueden ser generados automáticamente por el IDE si son necesarios.
}
