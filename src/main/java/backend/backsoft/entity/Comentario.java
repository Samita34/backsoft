package backend.backsoft.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "comentarios")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comentarioid")
    private Integer comentarioID;

    @Column(name = "recetaid", nullable = false)
    private Integer recetaID;

    @Column(name = "userid", nullable = false)
    private Integer userID;

    @Column(name = "textocomentario", nullable = false, columnDefinition = "TEXT")
    private String textoComentario;

    @Column(name = "fechahora", nullable = false)
    private LocalDateTime fechaHora;

    // Getters y setters con @JsonProperty
    @JsonProperty("comentarioid")
    public Integer getComentarioID() {
        return comentarioID;
    }

    public void setComentarioID(Integer comentarioID) {
        this.comentarioID = comentarioID;
    }
    
    @JsonProperty("recetaid")
    public Integer getRecetaID() {
        return recetaID;
    }

    public void setRecetaID(Integer recetaID) {
        this.recetaID = recetaID;
    }

    @JsonProperty("userid")
    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    @JsonProperty("textocomentario")
    public String getTextoComentario() {
        return textoComentario;
    }

    public void setTextoComentario(String textoComentario) {
        this.textoComentario = textoComentario;
    }

    @JsonProperty("fechahora")
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    // Los métodos toString, equals y hashCode pueden ser agregados según sea necesario.
}
