package backend.backsoft.dto;

public class RecetaDTO {
    private Integer id;
    private Integer userId;
    private String nombreReceta;
    private String procedimiento;
    private Integer tiempoPreparacion;
    private Integer porciones;
    private String descripcionCorta;
    // La propiedad ImagenReceta se omitirá para simplificar el DTO.

    // Constructor sin argumentos
    public RecetaDTO() {
    }

    // Constructor con argumentos
    public RecetaDTO(Integer id, Integer userId, String nombreReceta, String procedimiento,
                     Integer tiempoPreparacion, Integer porciones, String descripcionCorta) {
        this.id = id;
        this.userId = userId;
        this.nombreReceta = nombreReceta;
        this.procedimiento = procedimiento;
        this.tiempoPreparacion = tiempoPreparacion;
        this.porciones = porciones;
        this.descripcionCorta = descripcionCorta;
    }

    // Getters y setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNombreReceta() {
        return nombreReceta;
    }

    public void setNombreReceta(String nombreReceta) {
        this.nombreReceta = nombreReceta;
    }

    public String getProcedimiento() {
        return procedimiento;
    }

    public void setProcedimiento(String procedimiento) {
        this.procedimiento = procedimiento;
    }

    public Integer getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public void setTiempoPreparacion(Integer tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public Integer getPorciones() {
        return porciones;
    }

    public void setPorciones(Integer porciones) {
        this.porciones = porciones;
    }

    public String getDescripcionCorta() {
        return descripcionCorta;
    }

    public void setDescripcionCorta(String descripcionCorta) {
        this.descripcionCorta = descripcionCorta;
    }

    // toString, equals y hashCode pueden ser generados automáticamente por el IDE si son necesarios.
}
