package modelo;


import javax.persistence.*;
import java.util.Date;

/**
 * Comentario
 */
@Entity
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String foto;

    @OneToOne
    private Usuario autor;

    @Column(columnDefinition = "TEXT")
    private String comentario;

    @Column(nullable = false)
    private Date fecha;

    @OneToOne
    private Articulo articulo;

    public Comentario() {
    }

    public Comentario(Usuario autor, String comentario, Date fecha) {
        this.autor = autor;
        this.comentario = comentario;
        this.fecha = fecha;
    }

    public Comentario(Usuario autor, String comentario, Date fecha, Articulo articulo) {
        this.autor = autor;
        this.comentario = comentario;
        this.fecha = fecha;
        this.articulo = articulo;
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

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
}