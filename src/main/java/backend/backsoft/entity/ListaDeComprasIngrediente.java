package backend.backsoft.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ListasDeCompras_Ingredientes")
public class ListaDeComprasIngrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LisComprasIngredientesID")
    private Integer lisComprasIngredientesID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ListaID", referencedColumnName = "ListaID")
    private ListaDeCompras listaDeCompras;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IngredienteID", referencedColumnName = "IngredienteID")
    private Ingrediente ingrediente;

    // Getters y setters

    public Integer getLisComprasIngredientesID() {
        return lisComprasIngredientesID;
    }

    public void setLisComprasIngredientesID(Integer lisComprasIngredientesID) {
        this.lisComprasIngredientesID = lisComprasIngredientesID;
    }

    public ListaDeCompras getListaDeCompras() {
        return listaDeCompras;
    }

    public void setListaDeCompras(ListaDeCompras listaDeCompras) {
        this.listaDeCompras = listaDeCompras;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    // toString, equals y hashCode methods can be added as necessary
}
