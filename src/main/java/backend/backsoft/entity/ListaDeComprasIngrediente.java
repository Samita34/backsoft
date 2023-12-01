package backend.backsoft.entity;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "listasdecompras_ingredientes")
public class ListaDeComprasIngrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "liscomprasingredientesid")
    private Integer lisComprasIngredientesID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "listaid", referencedColumnName = "listaid")
    private ListaDeCompras listaDeCompras;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredienteid", referencedColumnName = "ingredienteid")
    private Ingrediente ingrediente;

    // Getters y setters con @JsonProperty
    @JsonProperty("liscomprasingredientesid")
    public Integer getLisComprasIngredientesID() {
        return lisComprasIngredientesID;
    }

    public void setLisComprasIngredientesID(Integer lisComprasIngredientesID) {
        this.lisComprasIngredientesID = lisComprasIngredientesID;
    }

    @JsonProperty("listaid")
    public ListaDeCompras getListaDeCompras() {
        return listaDeCompras;
    }

    public void setListaDeCompras(ListaDeCompras listaDeCompras) {
        this.listaDeCompras = listaDeCompras;
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
