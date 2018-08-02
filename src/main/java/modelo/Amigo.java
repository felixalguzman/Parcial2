package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Date;

/**
 * Amigo
 */
@Entity
public class Amigo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column
    private boolean aceptado;

    @ManyToOne
    private Usuario usuario1;

    @ManyToOne
    private Usuario usuario2;

    @Column
    private Date date_friended;

    public Amigo(boolean aceptado, Usuario usuario1, Usuario usuario2, Date date_friended) {
        this.aceptado = aceptado;
        this.usuario1 = usuario1;
        this.usuario2 = usuario2;
        this.date_friended = date_friended;
    }

    public Amigo() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isAceptado() {
        return aceptado;
    }

    public void setAceptado(boolean aceptado) {
        this.aceptado = aceptado;
    }

    public Usuario getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(Usuario usuario1) {
        this.usuario1 = usuario1;
    }

    public Usuario getUsuario2() {
        return usuario2;
    }

    public void setUsuario2(Usuario usuario2) {
        this.usuario2 = usuario2;
    }

    public Date getDate_friended() {
        return date_friended;
    }

    public void setDate_friended(Date date_friended) {
        this.date_friended = date_friended;
    }
}