package modelo;



import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Articulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "TEXT")
    private String cuerpo;

    @ManyToOne
    private Usuario usuario;

    @Column
    private Date fechaCreacion;

    @OneToMany(mappedBy = "articulo", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Etiqueta> etiquetaSet = new HashSet<>();

    public Articulo() {
    }

    public Articulo(String cuerpo, Usuario usuario, Date fechaCreacion, Set<Etiqueta> etiquetaSet) {
        this.cuerpo = cuerpo;
        this.usuario = usuario;
        this.fechaCreacion = fechaCreacion;
        this.etiquetaSet = etiquetaSet;
    }

    public Articulo(String cuerpo, Usuario usuario, Date fechaCreacion) {
        this.cuerpo = cuerpo;
        this.usuario = usuario;
        this.fechaCreacion = fechaCreacion;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Set<Etiqueta> getEtiquetaSet() {
        return etiquetaSet;
    }

    public void setEtiquetaSet(Set<Etiqueta> etiquetaSet) {
        this.etiquetaSet = etiquetaSet;
    }
}
