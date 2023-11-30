package backend.backsoft.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "RecetasGuardadas")
public class RecetaGuardada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RecetasGuardadasID")
    private Integer recetasGuardadasID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RecetaID", referencedColumnName = "RecetaID")
    private Receta receta;

    @Column(name = "FechaHora", nullable = false)
    private LocalDateTime fechaHora;

    // Getters y setters

    public Integer getRecetasGuardadasID() {
        return recetasGuardadasID;
    }

    public void setRecetasGuardadasID(Integer recetasGuardadasID) {
        this.recetasGuardadasID = recetasGuardadasID;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    // toString, equals y hashCode methods can be added as necessary
}
