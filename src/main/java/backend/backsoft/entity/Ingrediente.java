package backend.backsoft.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "ingredientes")
public class Ingrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredienteid")
    private Integer ingredienteID;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "tipo", length = 50)
    private String tipo;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    // Getters y setters con @JsonProperty
    @JsonProperty("ingredienteid")
    public Integer getIngredienteID() {
        return ingredienteID;
    }

    public void setIngredienteID(Integer ingredienteID) {
        this.ingredienteID = ingredienteID;
    }

    @JsonProperty("nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @JsonProperty("tipo")
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @JsonProperty("cantidad")
    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    // Método toString() si es necesario
    @Override
    public String toString() {
        return "Ingrediente{" +
                "ingredienteID=" + ingredienteID +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }

    // Implementar equals() y hashCode() si es necesario
}
