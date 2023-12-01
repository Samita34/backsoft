package backend.backsoft.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "recetasguardadas")
public class RecetaGuardada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recetasguardadasid")
    private Integer recetasGuardadasID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recetaid", referencedColumnName = "recetaid")
    private Receta receta;

    @Column(name = "fechahora", nullable = false)
    private LocalDateTime fechaHora;

    // Getters y setters con @JsonProperty
    @JsonProperty("recetasguardadasid")
    public Integer getRecetasGuardadasID() {
        return recetasGuardadasID;
    }

    public void setRecetasGuardadasID(Integer recetasGuardadasID) {
        this.recetasGuardadasID = recetasGuardadasID;
    }

    @JsonProperty("userid")
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @JsonProperty("recetaid")
    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
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
