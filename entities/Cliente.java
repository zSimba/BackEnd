package es.darcalzadilla.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
@Table (name = "Clientes")
public class Cliente {


    @Id
    private String dni;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String tlf;
    @OneToOne (mappedBy = "cliente", cascade = CascadeType.ALL)
    private BlackList blackList;
    @OneToMany (mappedBy = "cliente", cascade = CascadeType.ALL)
    private Set<Visita> visitas;



}
