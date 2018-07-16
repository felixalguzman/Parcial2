package modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private Date fechaNacimiento;

    @Column
    private String ciudadActual;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Lugar> lugares = new HashSet<>();

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, Date fechaNacimiento, String ciudadActual, Set<Lugar> lugares) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.ciudadActual = ciudadActual;
        this.lugares = lugares;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCiudadActual() {
        return ciudadActual;
    }

    public void setCiudadActual(String ciudadActual) {
        this.ciudadActual = ciudadActual;
    }

    public Set<Lugar> getLugares() {
        return lugares;
    }

    public void setLugares(Set<Lugar> lugares) {
        this.lugares = lugares;
    }
}
