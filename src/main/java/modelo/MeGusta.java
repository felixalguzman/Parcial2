package modelo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class MeGusta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany(mappedBy = "meGusta")
    private Set<Articulo> articulo = new HashSet<>();

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Foto foto;

    public MeGusta() {
    }

    public MeGusta(Set<Articulo> articulo, Usuario usuario, Foto foto) {
        this.articulo = articulo;
        this.usuario = usuario;
        this.foto = foto;
    }

    public MeGusta(Usuario usuario) {
        this.usuario = usuario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Articulo> getArticulo() {
        return articulo;
    }

    public void setArticulo(Set<Articulo> articulo) {
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
