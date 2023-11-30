package backend.backsoft.dto;

public class IngredienteDTO {
    private Integer id;
    private String nombre;
    private String tipo;
    private Integer cantidad;

    // Constructor sin argumentos
    public IngredienteDTO() {
    }

    // Constructor con argumentos
    public IngredienteDTO(Integer id, String nombre, String tipo, Integer cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    // Getters y setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    // toString, equals y hashCode pueden ser generados automáticamente por el IDE si son necesarios.
}
