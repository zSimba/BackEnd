package es.darcalzadilla.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@Getter
@Table (name = "Visitas")
public class Visita {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private Date fechaVisita;
    @ManyToOne
    @JoinColumn (name = "dni_cliente", referencedColumnName = "dni")
    private Cliente cliente;
}
