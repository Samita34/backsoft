package backend.backsoft.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Calificaciones")
public class Calificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CalificacionID")
    private Integer calificacionID;

    @Column(name = "RecetaID", nullable = false)
    private Integer recetaID;

    @Column(name = "UserID", nullable = false)
    private Integer userID;

    @Column(name = "Puntuacion")
    private Integer puntuacion;

    @Column(name = "FechaHora")
    private LocalDateTime fechaHora;

    // Getters y setters

    public Integer getCalificacionID() {
        return calificacionID;
    }

    public void setCalificacionID(Integer calificacionID) {
        this.calificacionID = calificacionID;
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

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        if (puntuacion == null || (puntuacion >= 1 && puntuacion <= 5)) {
            this.puntuacion = puntuacion;
        } else {
            throw new IllegalArgumentException("La puntuación debe estar entre 1 y 5.");
        }
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    // toString, equals y hashCode methods can be added as necessary
}
