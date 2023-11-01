package com.upc.cargasinestres.CargaSinEstres.service.Impl;

import com.upc.cargasinestres.CargaSinEstres.exception.ResourceNotFoundException;
import com.upc.cargasinestres.CargaSinEstres.model.Client;
import com.upc.cargasinestres.CargaSinEstres.repository.IClientRepository;
import com.upc.cargasinestres.CargaSinEstres.service.IClientService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientServiceImpl implements IClientService{


    private final IClientRepository clientRepository;

    //inyeccion de dependencias
    public ClientServiceImpl(IClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }


    @Override
    public List<Client> getClientsForLogin(String email, String password) {
        return clientRepository.findByEmailAndPassword(email,password);
    }


    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No se encontro el cliente con id: "+id));
    }

    /*
    @Override
    public Client updateClient(Long id, Client client) {
        return clientRepository.updateClient(id, client);
    }
    */


    @Override
    public Boolean existsByEmailAndPassword(String email, String password) {
        return clientRepository.existsByEmailAndPassword(email, password);
    }


}
