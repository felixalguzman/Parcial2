package modelo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Foto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String foto;

    @ManyToOne
    private Album album;

    @OneToMany
    private Set<Comentario> comentarioSet = new HashSet<>();

    public Foto() {
    }

    public Foto(String foto, Album album, Set<Comentario> comentarioSet) {
        this.foto = foto;
        this.album = album;
        this.comentarioSet = comentarioSet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Set<Comentario> getComentarioSet() {
        return comentarioSet;
    }

    public void setComentarioSet(Set<Comentario> comentarioSet) {
        this.comentarioSet = comentarioSet;
    }
}
