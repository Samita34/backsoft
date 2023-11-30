package backend.backsoft.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Comentarios")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ComentarioID")
    private Integer comentarioID;

    /* 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RecetaID", referencedColumnName = "RecetaID")
    private Receta receta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    private Usuario usuario;*/

    @Column(name = "RecetaID", nullable = false)
    private Integer recetaID;

    @Column(name = "UserID", nullable = false)
    private Integer userID;

    @Column(name = "TextoComentario", nullable = false, columnDefinition = "TEXT")
    private String textoComentario;

    @Column(name = "FechaHora", nullable = false)
    private LocalDateTime fechaHora;

    // Getters y setters

    public Integer getComentarioID() {
        return comentarioID;
    }

    public void setComentarioID(Integer comentarioID) {
        this.comentarioID = comentarioID;
    }

    public Integer getRecetaID() {
        return recetaID;
    }

    public void setRecetaID(Integer recetaID) {
        this.recetaID = recetaID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getTextoComentario() {
        return textoComentario;
    }

    public void setTextoComentario(String textoComentario) {
        this.textoComentario = textoComentario;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    // toString, equals y hashCode methods can be added as necessary
}
