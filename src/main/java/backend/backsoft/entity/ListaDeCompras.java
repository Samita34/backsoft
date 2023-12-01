package backend.backsoft.entity;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "listasdecompras")
public class ListaDeCompras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "listaid")
    private Integer listaID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    private Usuario usuario;

    @Column(name = "nombrelista", length = 255)
    private String nombreLista;

    // Getters y setters con @JsonProperty
    @JsonProperty("listaid")
    public Integer getListaID() {
        return listaID;
    }

    public void setListaID(Integer listaID) {
        this.listaID = listaID;
    }

    @JsonProperty("usuario")
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @JsonProperty("nombrelista")
    public String getNombreLista() {
        return nombreLista;
    }

    public void setNombreLista(String nombreLista) {
        this.nombreLista = nombreLista;
    }

    // Los métodos toString, equals y hashCode pueden ser agregados según sea necesario.
}
