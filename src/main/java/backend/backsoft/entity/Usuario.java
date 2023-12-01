package backend.backsoft.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;


@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userid;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String apellido;

    @Column(length = 50)
    private String nombreusuario;

    @Column(nullable = false, length = 255)
    private String correo;

    @Lob
    private byte[] fotoperfil;

    // Getters y setters
    @JsonProperty("userid")
    public Integer getUserID() {
        return userid;
    }
    public void setUserID(Integer userID) {
        this.userid = userID;
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

    @JsonProperty("nombreusuario")
    public String getNombreUsuario() {
        return nombreusuario;
    }

    public void setNombreUsuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @JsonProperty("fotoperfil")
    public byte[] getFotoPerfil() {
        return fotoperfil;
    }

    public void setFotoPerfil(byte[] fotoperfil) {
        this.fotoperfil = fotoperfil;
    }
}
