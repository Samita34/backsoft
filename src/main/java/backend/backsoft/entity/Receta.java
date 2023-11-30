package backend.backsoft.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Recetas")
public class Receta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RecetaID")
    private Integer recetaID;

    @Column(name = "UserID", nullable = false)
    private Integer userID;

    @Column(name = "NombreReceta", nullable = false, length = 255)
    private String nombreReceta;

    @Column(name = "Procedimiento", nullable = false, columnDefinition = "TEXT")
    private String procedimiento;

    @Column(name = "TiempoPreparacion", nullable = false)
    private Integer tiempoPreparacion;

    @Column(name = "Porciones", nullable = false)
    private Integer porciones;

    @Column(name = "DescripcionCorta", nullable = false, columnDefinition = "TEXT")
    private String descripcionCorta;

    @Lob
    @Column(name = "ImagenReceta", nullable = false)
    private byte[] imagenReceta;

    @Column(name = "Categoria_CategoriaID", nullable = false)
    private Integer categoriaCategoriaID;

    // Getters and setters

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

    public String getNombreReceta() {
        return nombreReceta;
    }

    public void setNombreReceta(String nombreReceta) {
        this.nombreReceta = nombreReceta;
    }

    public String getProcedimiento() {
        return procedimiento;
    }

    public void setProcedimiento(String procedimiento) {
        this.procedimiento = procedimiento;
    }

    public Integer getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public void setTiempoPreparacion(Integer tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public Integer getPorciones() {
        return porciones;
    }

    public void setPorciones(Integer porciones) {
        this.porciones = porciones;
    }

    public String getDescripcionCorta() {
        return descripcionCorta;
    }

    public void setDescripcionCorta(String descripcionCorta) {
        this.descripcionCorta = descripcionCorta;
    }

    public byte[] getImagenReceta() {
        return imagenReceta;
    }

    public void setImagenReceta(byte[] imagenReceta) {
        this.imagenReceta = imagenReceta;
    }

    public Integer getCategoriaCategoriaID() {
        return categoriaCategoriaID;
    }

    public void setCategoriaCategoriaID(Integer categoriaCategoriaID) {
        this.categoriaCategoriaID = categoriaCategoriaID;
    }

    // toString, equals and hashCode methods can be added as necessary
}
