package modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

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

    @Column
    private Date fechaRegistro;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Lugar> lugaresEstudio = new HashSet<>();

    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Lugar> lugaresTrabajo = new HashSet<>();

    @OneToMany
    private Set<Articulo> articulos = new HashSet<>();

    @Column
    private String lugarNacimiento;

    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Amigo> amigos = new HashSet<>();

    @Column
    private Blob fotoPerfil;

    public Usuario() {
    }

    public Usuario(String admin, String s, Date from, String santiago) {
    }

   

 
}
