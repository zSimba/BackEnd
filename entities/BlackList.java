package es.darcalzadilla.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table (name = "Lista_Negra")
public class BlackList {

    @Id
    private String dni;
    private Date fechaInclusion;
    private String motivo;
    @OneToOne
    @JoinColumn (name = "dni", referencedColumnName = "dni")
    private Cliente cliente;

}
