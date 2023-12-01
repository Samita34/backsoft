package backend.backsoft.entity;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "recetas_ingredientes")
public class RecetaIngrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "receingreid")
    private Integer receIngreID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recetaid", referencedColumnName = "recetaid")
    private Receta receta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredienteid", referencedColumnName = "ingredienteid")
    private Ingrediente ingrediente;

    // Getters y setters con @JsonProperty
    @JsonProperty("receingreid")
    public Integer getReceIngreID() {
        return receIngreID;
    }

    public void setReceIngreID(Integer receIngreID) {
        this.receIngreID = receIngreID;
    }

    @JsonProperty("recetaid")
    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    @JsonProperty("ingredienteid")
    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    // Los métodos toString, equals y hashCode pueden ser agregados según sea necesario.
}
