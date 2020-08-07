package com.nisum.register.controller;

import com.nisum.register.model.ClientRequest;
import com.nisum.register.model.ClientResponse;
import com.nisum.register.service.RegisterService;
import com.nisum.register.wrapper.RegisterWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Client Rest Controller.
 */
@RestController
@RequestMapping("/client")
public class RegisterController {
    /**
     * Autowiring the Client Service.
     */
    @Autowired
    private RegisterService registerService;

    /**
     * get Api to return list of all planets.
     * @return List of Clients
     */
    @GetMapping()
    public ResponseEntity<List<ClientResponse>> getAllClients() {
        List<ClientResponse> clientResponseList = registerService.getAllClients();
        return new ResponseEntity<>(clientResponseList, HttpStatus.OK);
    }

    /**
     * get Api to return the Client by Id.
     * @param id Id
     * @return Clients
     */
    @GetMapping("/{id}")
    public ResponseEntity<ClientResponse> getClientById(@PathVariable("id") final Long id) {
        ClientResponse clientResponse = RegisterWrapper.
                convertClientToClientResponse(registerService.getClientById(id));
        return new ResponseEntity<>(clientResponse, HttpStatus.OK);
    }

    /**
     * Api to save new Client.
     * @param clientRequest Client to add
     * @return Saved Client
     */
    @PostMapping()
    public ResponseEntity<ClientResponse> saveClient(@RequestBody final ClientRequest clientRequest) {
        ClientResponse savedClientResponse = registerService.saveClient(clientRequest);
        return new ResponseEntity<>(savedClientResponse, HttpStatus.CREATED);
    }

    /**
     * Api to update an existing Client.
     * @param id Id to update
     * @param clientRequestToUpdate Client to update
     * @return Updated Client
     */
    @PutMapping("/{id}")
    public ResponseEntity<ClientResponse> updateClientById(@PathVariable("id") final Long id,
                                                          @RequestBody final ClientRequest clientRequestToUpdate) {
        ClientResponse updatedClientResponse = registerService.updateClientById(id, clientRequestToUpdate);
        return new ResponseEntity<>(updatedClientResponse, HttpStatus.OK);
    }

    /**
     * Api to delete a client.
     * @param id Id to delete
     * @return Success Message
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClientById(@PathVariable("id") final Long id) {
        registerService.deleteClientById(id);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

}
