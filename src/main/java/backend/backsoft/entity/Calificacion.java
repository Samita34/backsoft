package backend.backsoft.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "calificaciones")
public class Calificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "calificacionid")
    private Integer calificacionID;

    @Column(name = "recetaid", nullable = false)
    private Integer recetaID;

    @Column(name = "userid", nullable = false)
    private Integer userID;

    @Column(name = "puntuacion")
    private Integer puntuacion;

    @Column(name = "fechahora")
    private LocalDateTime fechaHora;

    // Getters y setters con @JsonProperty
    @JsonProperty("calificacionid")
    public Integer getCalificacionID() {
        return calificacionID;
    }

    public void setCalificacionID(Integer calificacionID) {
        this.calificacionID = calificacionID;
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

    @JsonProperty("puntuacion")
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

    @JsonProperty("fechahora")
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    // Los métodos toString, equals y hashCode pueden ser agregados según sea necesario.
}
