package es.darcalzadilla.backend.reposiroty;

import es.darcalzadilla.backend.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByDni(String dni);
}
