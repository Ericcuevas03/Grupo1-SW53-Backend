package com.upc.cargasinestres.CargaSinEstres.controller;

import com.upc.cargasinestres.CargaSinEstres.exception.ValidationException;
import com.upc.cargasinestres.CargaSinEstres.model.Client;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;

import com.upc.cargasinestres.CargaSinEstres.service.IClientService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ClientController {

    private final IClientService clientService;

    public ClientController(IClientService clientService) {

        this.clientService = clientService;
    }

    //Method: GET
    @GetMapping("/clients/login")
    public ResponseEntity<List<Client>> getClientsForLogin(@RequestParam(name="email") String email, @RequestParam(name="password")String password){
        return new ResponseEntity<List<Client>>(clientService.getClientsForLogin(email, password), HttpStatus.OK);
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> getClientById(@RequestParam(name="id") Long id){
        return new ResponseEntity<Client>(clientService.getClientById(id), HttpStatus.OK);
    }


    //Method: POST
    @PostMapping("/clients")
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        validateClientCreated(client);
        existClientByEmailAndPassword(client);
        var res = clientService.createClient(client);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";

        return email.matches(emailRegex);
    }


    private void validateClientCreated(Client client){
        if(client.getEmail() == null || client.getEmail().isEmpty()){
            throw new ValidationException("El email del cliente debe ser obligatorio"); //ERROR 400
        }

        if (!isValidEmail(client.getEmail())) {
            throw new ValidationException("El email del cliente no tiene un formato válido");
        }


        if(client.getPassword() == null || client.getPassword().isEmpty()){
            throw new ValidationException("La contraseña del cliente debe ser obligatorio");
        }

        if(client.getName() == null || client.getName().isEmpty()){
            throw new ValidationException("El nombre del cliente debe ser obligatorio");
        }

        if(client.getApellidoMaterno() == null || client.getApellidoMaterno().isEmpty()){
            throw new ValidationException("El apellido del cliente debe ser obligatorio");
        }

        if(client.getApellidoPaterno() == null || client.getApellidoPaterno().isEmpty()){
            throw new ValidationException("El apellido del cliente debe ser obligatorio");
        }

        if(client.getDireccion() == null || client.getDireccion().isEmpty()){
            throw new ValidationException("La direccion del cliente debe ser obligatorio");
        }

        if(client.getCelular().length() > 9){
            throw new ValidationException("El celular del cliente no debe exceder los 9 caracteres");
        }

        if (!client.getCelular().matches("\\d+")) {
            throw new ValidationException("El celular debe contener solo dígitos enteros");
        }

        if(client.getUserType()== null || client.getUserType().isEmpty()){
            throw new ValidationException("El tipo de usuario debe ser obligatorio");
        }
    }

    private void existClientByEmailAndPassword(Client client){
        if(clientService.existsByEmailAndPassword(client.getEmail(), client.getPassword())){
            throw new ValidationException("No se puede registrar el cliente porque ya existe uno " +
                    "con el mismo email y contraseña");
        }
    }

    /*
    //URL: http://localhost:8080/api/clients/v1/clients?id=cliente_id
    @PatchMapping("/clients/{id}")
    public ResponseEntity<Client> partialUpdateClient(@RequestParam(name = "id") Long id, @RequestBody Client clientUpdate){

        // Buscar el cliente por su ID
        Client existingClient = clientService.getClientById(id);

        if(existingClient == null){
            //El cliente no  se encontro
            throw new ValidationException("No existe el cliente con el id: " + id);
        }

        //El cliente se encontro
        if (clientUpdate.getName() != null && !clientUpdate.getName().isEmpty()) {
            existingClient.setName(clientUpdate.getName());
        }

        if (clientUpdate.getApellidoMaterno() != null && !clientUpdate.getApellidoMaterno().isEmpty()) {
            existingClient.setApellidoMaterno(clientUpdate.getApellidoMaterno());
        }

        if (clientUpdate.getApellidoPaterno() != null && !clientUpdate.getApellidoPaterno().isEmpty()) {
            existingClient.setApellidoPaterno(clientUpdate.getApellidoPaterno());
        }

        if (clientUpdate.getCelular() != null && !clientUpdate.getCelular().isEmpty()) {
            if (!clientUpdate.getCelular().matches("\\d+")) {
                throw new ValidationException("El celular debe contener solo dígitos enteros");
            }
            if (clientUpdate.getCelular().length() > 9) {
                throw new ValidationException("El celular no debe exceder los 9 caracteres");
            }
            existingClient.setCelular(clientUpdate.getCelular());
        }

        if (clientUpdate.getDireccion() != null && !clientUpdate.getDireccion().isEmpty()) {
            existingClient.setDireccion(clientUpdate.getDireccion());
        }

        if (clientUpdate.getEmail() != null && !clientUpdate.getEmail().isEmpty()) {
            if (!isValidEmail(clientUpdate.getEmail())) {
                throw new ValidationException("El email del cliente no tiene un formato válido");
            }
            existingClient.setEmail(clientUpdate.getEmail());
        }

        if (clientUpdate.getPassword() != null && !clientUpdate.getPassword().isEmpty()) {
            existingClient.setPassword(clientUpdate.getPassword());
        }

        Client updatedClient = clientService.updateClient(id, existingClient);

        return new ResponseEntity<>(updatedClient, HttpStatus.OK);
    }
    */

}

