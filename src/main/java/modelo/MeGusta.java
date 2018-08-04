package modelo;

import javax.persistence.*;

@Entity
public class MeGusta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Articulo articulo;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Foto foto;
    public MeGusta() {
    }

    public MeGusta(Articulo articulo, Usuario usuario, Foto foto) {
        this.articulo = articulo;
        this.usuario = usuario;
        this.foto = foto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Foto getFoto() {
        return foto;
    }

    public void setFoto(Foto foto) {
        this.foto = foto;
    }
}
