package es.darcalzadilla.backend.reposiroty;

import es.darcalzadilla.backend.entities.BlackList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlackListRespository extends JpaRepository<BlackList, Long> {

    BlackList findByDni (String dni);
    BlackList deleteByDni (String dni);
}
