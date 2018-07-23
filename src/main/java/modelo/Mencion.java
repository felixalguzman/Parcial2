package modelo;

import javax.persistence.*;

@Entity
public class Mencion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Usuario origen;

    @OneToOne
    private Usuario destino;

    @ManyToOne
    private Articulo articulo;

    public Mencion() {
    }

    public Mencion(Usuario origen, Usuario destino, Articulo articulo) {
        this.origen = origen;
        this.destino = destino;
        this.articulo = articulo;
    }

    public Mencion(Usuario origen, Usuario destino) {
        this.origen = origen;
        this.destino = destino;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
}
