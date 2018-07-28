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

    @Column
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String cuerpo;

    @ManyToOne
    private Usuario usuario;

    @Column
    private Date fechaCreacion;

    @Column
    private  boolean publico;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Etiqueta> etiquetaSet = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Notificacion> notificacionSet = new HashSet<>();

    public Articulo() {
    }

    public Articulo(String titulo, String cuerpo, Usuario usuario, Date fechaCreacion, boolean publico) {
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.usuario = usuario;
        this.fechaCreacion = fechaCreacion;
        this.publico = publico;
    }

    public Articulo(String titulo, String cuerpo, Usuario usuario, Date fechaCreacion, boolean publico, Set<Etiqueta> etiquetaSet, Set<Notificacion> notificacionSet) {
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.usuario = usuario;
        this.fechaCreacion = fechaCreacion;
        this.publico = publico;
        this.etiquetaSet = etiquetaSet;
        this.notificacionSet = notificacionSet;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isPublico() {
        return publico;
    }

    public void setPublico(boolean publico) {
        this.publico = publico;
    }

    public Set<Notificacion> getNotificacionSet() {
        return notificacionSet;
    }

    public void setNotificacionSet(Set<Notificacion> notificacionSet) {
        this.notificacionSet = notificacionSet;
    }
}
