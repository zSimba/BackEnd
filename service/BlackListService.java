package es.darcalzadilla.backend.service;

import es.darcalzadilla.backend.entities.BlackList;
import es.darcalzadilla.backend.entities.Cliente;
import es.darcalzadilla.backend.reposiroty.IBlackListRespository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BlackListService {

    private final IBlackListRespository blackListRespository;

    public BlackListService(IBlackListRespository blackListRespository) {
        this.blackListRespository = blackListRespository;
    }

    public boolean isValid (String dni){
        return blackListRespository.findByDni(dni) != null;
    }


    public void addToBlackList (Cliente cliente, String motivo){
        String dni  = cliente.getDni();
        Date today = new Date();
        BlackList nuevo = new BlackList();
        nuevo.setDni(dni);
        nuevo.setFechaInclusion(today);
        nuevo.setMotivo(motivo);
        blackListRespository.save(nuevo);
    }

    public void deleteFromList (String dni){
        blackListRespository.deleteByDni(dni);
    }

}
