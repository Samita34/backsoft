package backend.backsoft.dto;

public class RecetasIngredientesDTO {
    private Integer receIngreID;
    private Integer recetaId;
    private Integer ingredienteId;

    // Constructor sin argumentos
    public RecetasIngredientesDTO() {
    }

    // Constructor con argumentos
    public RecetasIngredientesDTO(Integer receIngreID, Integer recetaId, Integer ingredienteId) {
        this.receIngreID = receIngreID;
        this.recetaId = recetaId;
        this.ingredienteId = ingredienteId;
    }

    // Getters y setters
    public Integer getReceIngreID() {
        return receIngreID;
    }

    public void setReceIngreID(Integer receIngreID) {
        this.receIngreID = receIngreID;
    }

    public Integer getRecetaId() {
        return recetaId;
    }

    public void setRecetaId(Integer recetaId) {
        this.recetaId = recetaId;
    }

    public Integer getIngredienteId() {
        return ingredienteId;
    }

    public void setIngredienteId(Integer ingredienteId) {
        this.ingredienteId = ingredienteId;
    }

    // toString, equals y hashCode pueden ser generados automáticamente por el IDE si son necesarios.
}
