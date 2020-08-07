package com.nisum.register.service;

import com.nisum.register.model.ClientRequest;
import com.nisum.register.model.ClientResponse;
import com.nisum.register.repository.entity.Client;
import java.util.List;

public interface RegisterService {
    /**
     * Get All Clients.
     * @return List of all planets.
     */
    List<ClientResponse> getAllClients();
    /**
     * Get Client By Id.
     * @param id Id
     * @return Client
     */
    Client getClientById(Long id);
    /**
     * Save Client.
     * @param client Client to save
     * @return Saved Client
     */
    ClientResponse saveClient(ClientRequest client);
    /**
     * Update Client.
     * @param id Id
     * @param clientToUpdate Client to Update
     * @return Updated Client
     */
    ClientResponse updateClientById(Long id, ClientRequest clientToUpdate);
    /**
     * Delete Client by Id.
     * @param id Id
     */
    void deleteClientById(Long id);
    /**
     * Search Client by name containing.
     * @param searchString SearchString
     * @return Search result
     */
    //List<Client> getClientByNameContaining(String searchString);
    /**
     * Search Client by name like.
     * @param searchString SearchString
     * @return Search result
     */
    //List<Client> getClientByNameLike(String searchString);
}
