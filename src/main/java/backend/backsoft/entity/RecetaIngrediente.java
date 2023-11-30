package backend.backsoft.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Recetas_Ingredientes")
public class RecetaIngrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ReceIngreID")
    private Integer receIngreID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RecetaID", referencedColumnName = "RecetaID")
    private Receta receta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IngredienteID", referencedColumnName = "IngredienteID")
    private Ingrediente ingrediente;

    // Getters y setters

    public Integer getReceIngreID() {
        return receIngreID;
    }

    public void setReceIngreID(Integer receIngreID) {
        this.receIngreID = receIngreID;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    // toString, equals y hashCode methods can be added as necessary
}
