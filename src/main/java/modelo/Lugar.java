package modelo;

import servicios.enums.TipoLugar;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Lugar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String lugar;

    @Column
    private Date fechaInicio;

    @Column
    private Date fechaFin;

    @ManyToOne
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    @Column
    private TipoLugar tipoLugar;

    public Lugar() {
    }

    public Lugar(String lugar, Date fechaInicio, Date fechaFin, Usuario usuario, TipoLugar tipoLugar) {
        this.lugar = lugar;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.usuario = usuario;
        this.tipoLugar = tipoLugar;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TipoLugar getTipoLugar() {
        return tipoLugar;
    }

    public void setTipoLugar(TipoLugar tipoLugar) {
        this.tipoLugar = tipoLugar;
    }
}
