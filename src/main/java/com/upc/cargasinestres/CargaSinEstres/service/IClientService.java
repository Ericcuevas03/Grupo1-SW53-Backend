package com.upc.cargasinestres.CargaSinEstres.service;

import com.upc.cargasinestres.CargaSinEstres.model.Client;

import java.util.List;

public interface IClientService {

    //GET
    public abstract List<Client> getClientsForLogin(String email, String password);

    public abstract Client getClientById(Long id);


    //CREATE
    public abstract Client createClient(Client client);


    //UPDATE
    //public abstract Client updateClient(Long id, Client client);

    public abstract Boolean existsByEmailAndPassword(String email, String password);

}
