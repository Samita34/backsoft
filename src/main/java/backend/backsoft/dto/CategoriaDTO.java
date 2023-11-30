package backend.backsoft.dto;

public class CategoriaDTO {
    private Integer id;
    private String nombreCategoria;

    // Constructor sin argumentos
    public CategoriaDTO() {
    }

    // Constructor con argumentos
    public CategoriaDTO(Integer id, String nombreCategoria) {
        this.id = id;
        this.nombreCategoria = nombreCategoria;
    }

    // Getters y setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    // toString, equals y hashCode pueden ser generados automáticamente por el IDE si son necesarios.
}
