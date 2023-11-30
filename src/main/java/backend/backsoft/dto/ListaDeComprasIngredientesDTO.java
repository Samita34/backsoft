package backend.backsoft.dto;

public class ListaDeComprasIngredientesDTO {
    private Integer lisComprasIngredientesId;
    private Integer listaId;
    private Integer ingredienteId;

    // Constructor sin argumentos
    public ListaDeComprasIngredientesDTO() {
    }

    // Constructor con argumentos
    public ListaDeComprasIngredientesDTO(Integer lisComprasIngredientesId, Integer listaId, Integer ingredienteId) {
        this.lisComprasIngredientesId = lisComprasIngredientesId;
        this.listaId = listaId;
        this.ingredienteId = ingredienteId;
    }

    // Getters y setters
    public Integer getLisComprasIngredientesId() {
        return lisComprasIngredientesId;
    }

    public void setLisComprasIngredientesId(Integer lisComprasIngredientesId) {
        this.lisComprasIngredientesId = lisComprasIngredientesId;
    }

    public Integer getListaId() {
        return listaId;
    }

    public void setListaId(Integer listaId) {
        this.listaId = listaId;
    }

    public Integer getIngredienteId() {
        return ingredienteId;
    }

    public void setIngredienteId(Integer ingredienteId) {
        this.ingredienteId = ingredienteId;
    }

    // toString, equals y hashCode pueden ser generados automáticamente por el IDE si son necesarios.
}
