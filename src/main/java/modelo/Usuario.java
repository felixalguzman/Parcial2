package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nombre;

    @Column
    private String apellido;

    @Column
    private String correo;

    @Column
    private String username;

    @Column
    private String contrasena;

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

    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Articulo> articulos = new HashSet<>();

    @Column
    private String lugarNacimiento;

    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Amigo> amigos = new HashSet<>();

    @Column(columnDefinition = "BLOB")
    private byte[] fotoPerfil;

    @Column
    private boolean admin;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String correo, String contrasena, Date fechaNacimiento, String ciudadActual, Date fechaRegistro, Set<Lugar> lugaresEstudio, Set<Lugar> lugaresTrabajo, Set<Articulo> articulos, String lugarNacimiento, Set<Amigo> amigos, byte[] fotoPerfil, boolean admin) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
        this.fechaNacimiento = fechaNacimiento;
        this.ciudadActual = ciudadActual;
        this.fechaRegistro = fechaRegistro;
        this.lugaresEstudio = lugaresEstudio;
        this.lugaresTrabajo = lugaresTrabajo;
        this.articulos = articulos;
        this.lugarNacimiento = lugarNacimiento;
        this.amigos = amigos;
        this.fotoPerfil = fotoPerfil;
        this.admin = admin;
    }

    public Usuario(String nombre, String apellido, String correo, String password, String username, Date from, boolean admin) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = password;
        this.username = username;
        this.fechaRegistro = from;
        this.admin = admin;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Set<Lugar> getLugaresEstudio() {
        return lugaresEstudio;
    }

    public void setLugaresEstudio(Set<Lugar> lugaresEstudio) {
        this.lugaresEstudio = lugaresEstudio;
    }

    public Set<Lugar> getLugaresTrabajo() {
        return lugaresTrabajo;
    }

    public void setLugaresTrabajo(Set<Lugar> lugaresTrabajo) {
        this.lugaresTrabajo = lugaresTrabajo;
    }

    public Set<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(Set<Articulo> articulos) {
        this.articulos = articulos;
    }

    public String getLugarNacimiento() {
        return lugarNacimiento;
    }

    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    public Set<Amigo> getAmigos() {
        return amigos;
    }

    public void setAmigos(Set<Amigo> amigos) {
        this.amigos = amigos;
    }

    public byte[] getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(byte[] fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}