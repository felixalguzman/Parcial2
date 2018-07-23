package modelo;

import servicios.enums.TipoNotificacion;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column
    private TipoNotificacion tipoNotificacion;

    @OneToOne
    private Usuario origen;

    @OneToOne
    private Usuario destino;

    @Column
    private Date fecha;

    @Column
    private boolean leido;

    public Notificacion() {
    }

    public Notificacion(TipoNotificacion tipoNotificacion, Usuario origen, Usuario destino, Date fecha, boolean leido) {
        this.tipoNotificacion = tipoNotificacion;
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.leido = leido;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TipoNotificacion getTipoNotificacion() {
        return tipoNotificacion;
    }

    public void setTipoNotificacion(TipoNotificacion tipoNotificacion) {
        this.tipoNotificacion = tipoNotificacion;
    }

    public Usuario getOrigen() {
        return origen;
    }

    public void setOrigen(Usuario origen) {
        this.origen = origen;
    }

    public Usuario getDestino() {
        return destino;
    }

    public void setDestino(Usuario destino) {
        this.destino = destino;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isLeido() {
        return leido;
    }

    public void setLeido(boolean leido) {
        this.leido = leido;
    }
}
