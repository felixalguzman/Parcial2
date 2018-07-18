package modelo;

import java.sql.Blob;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

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
    private Set<Blob> foto = new HashSet<>();

    @Column
    private Date fechaCreacion;


    


}
