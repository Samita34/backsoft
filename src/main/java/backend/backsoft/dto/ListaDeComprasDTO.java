package backend.backsoft.dto;

public class ListaDeComprasDTO {
    private Integer listaId;
    private Integer userId;
    private String nombreLista;

    // Constructor sin argumentos
    public ListaDeComprasDTO() {
    }

    // Constructor con argumentos
    public ListaDeComprasDTO(Integer listaId, Integer userId, String nombreLista) {
        this.listaId = listaId;
        this.userId = userId;
        this.nombreLista = nombreLista;
    }

    // Getters y setters
    public Integer getListaId() {
        return listaId;
    }

    public void setListaId(Integer listaId) {
        this.listaId = listaId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNombreLista() {
        return nombreLista;
    }

    public void setNombreLista(String nombreLista) {
        this.nombreLista = nombreLista;
    }

    // toString, equals y hashCode pueden ser generados automáticamente por el IDE si son necesarios.
}
