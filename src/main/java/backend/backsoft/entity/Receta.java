package backend.backsoft.entity;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "recetas")
public class Receta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recetaid")
    private Integer recetaID;

    @Column(name = "userid", nullable = false)
    private Integer userID;

    @Column(name = "nombrereceta", nullable = false, length = 255)
    private String nombreReceta;

    @Column(name = "procedimiento", nullable = false, columnDefinition = "TEXT")
    private String procedimiento;

    @Column(name = "tiempopreparacion", nullable = false)
    private Integer tiempoPreparacion;

    @Column(name = "porciones", nullable = false)
    private Integer porciones;

    @Column(name = "descripcioncorta", nullable = false, columnDefinition = "TEXT")
    private String descripcionCorta;

    @Lob
    @Column(name = "imagenreceta", nullable = false)
    private byte[] imagenReceta;

    @Column(name = "categoria_categoriaid", nullable = false)
    private Integer categoriaCategoriaID;

    // Getters y setters con @JsonProperty
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

    @JsonProperty("nombrereceta")
    public String getNombreReceta() {
        return nombreReceta;
    }

    public void setNombreReceta(String nombreReceta) {
        this.nombreReceta = nombreReceta;
    }

    @JsonProperty("procedimiento")
    public String getProcedimiento() {
        return procedimiento;
    }

    public void setProcedimiento(String procedimiento) {
        this.procedimiento = procedimiento;
    }

    @JsonProperty("tiempopreparacion")
    public Integer getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public void setTiempoPreparacion(Integer tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }

    @JsonProperty("porciones")
    public Integer getPorciones() {
        return porciones;
    }

    public void setPorciones(Integer porciones) {
        this.porciones = porciones;
    }

    @JsonProperty("descripcioncorta")
    public String getDescripcionCorta() {
        return descripcionCorta;
    }

    public void setDescripcionCorta(String descripcionCorta) {
        this.descripcionCorta = descripcionCorta;
    }

    @JsonProperty("imagenreceta")
    public byte[] getImagenReceta() {
        return imagenReceta;
    }

    public void setImagenReceta(byte[] imagenReceta) {
        this.imagenReceta = imagenReceta;
    }

    @JsonProperty("categoria_categoriaid")
    public Integer getCategoriaCategoriaID() {
        return categoriaCategoriaID;
    }

    public void setCategoriaCategoriaID(Integer categoriaCategoriaID) {
        this.categoriaCategoriaID = categoriaCategoriaID;
    }

    // Los métodos toString, equals y hashCode pueden ser agregados según sea necesario.
}
