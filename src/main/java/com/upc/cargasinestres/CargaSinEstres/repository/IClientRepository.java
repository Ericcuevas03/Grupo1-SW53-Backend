package com.upc.cargasinestres.CargaSinEstres.repository;

import com.upc.cargasinestres.CargaSinEstres.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IClientRepository extends JpaRepository<Client, Long>{
    Boolean existsByEmailAndPassword(String email, String password);

    List<Client> findByEmailAndPassword(String email, String password);

    //Client updateClient(Long id, Client client);



}
