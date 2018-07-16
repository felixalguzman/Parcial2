package modelo;

import javax.persistence.*;

@Entity
public class Articulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String titulo;

    @Column
    private String cuerpo;

    @Column
    private byte[] foto;


}
