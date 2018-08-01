package modelo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Usuario usuario;

    @Column
    private String descripcion;

    @OneToMany
    private Set<Foto> fotoSet = new HashSet<>();

    public Album() {
    }

    public Album(Usuario usuario, String descripcion, Set<Foto> fotoSet) {
        this.usuario = usuario;
        this.descripcion = descripcion;
        this.fotoSet = fotoSet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Foto> getFotoSet() {
        return fotoSet;
    }

    public void setFotoSet(Set<Foto> fotoSet) {
        this.fotoSet = fotoSet;
    }
}
