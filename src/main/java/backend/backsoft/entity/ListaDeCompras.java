package backend.backsoft.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ListasDeCompras")
public class ListaDeCompras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ListaID")
    private Integer listaID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    private Usuario usuario;

    @Column(name = "NombreLista", length = 255)
    private String nombreLista;

    // Getters y setters

    public Integer getListaID() {
        return listaID;
    }

    public void setListaID(Integer listaID) {
        this.listaID = listaID;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNombreLista() {
        return nombreLista;
    }

    public void setNombreLista(String nombreLista) {
        this.nombreLista = nombreLista;
    }

    // toString, equals y hashCode methods can be added as necessary
}
