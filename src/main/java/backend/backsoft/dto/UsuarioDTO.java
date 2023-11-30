package backend.backsoft.dto;

public class UsuarioDTO {
    private Integer userId;
    private String nombre;
    private String apellido;
    private String nombreUsuario;
    private String correo;
    // No incluyo FotoPerfil ya que es un BLOB y normalmente no se transfiere directamente en DTOs

    // Getters y setters

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    // toString, equals, hashCode si es necesario
}
