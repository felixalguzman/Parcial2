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
}