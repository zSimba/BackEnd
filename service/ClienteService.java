package es.darcalzadilla.backend.service;

import es.darcalzadilla.backend.entities.Cliente;
import es.darcalzadilla.backend.reposiroty.IClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final IClienteRepository clienteRepository;

    public ClienteService(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void saveCliente (Cliente cliente){
        clienteRepository.save(cliente);
    }

    public Cliente findByDni (String dni){
        return clienteRepository.findByDni(dni);
    }

    public void deleteCliente (String dni){
        Cliente cliente = findByDni(dni);
        clienteRepository.delete(cliente);
    }

    public void updateCliente (String dni, String new_direccion, String new_tlf){
        Cliente cliente = findByDni(dni);

        if (new_direccion != null){
            cliente.setDireccion(new_direccion);
        }
        if (new_tlf != null){
            cliente.setTlf(new_tlf);
        }

    }
}
