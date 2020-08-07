package com.nisum.register.service;

import com.nisum.register.model.ClientRequest;
import com.nisum.register.model.ClientResponse;
import com.nisum.register.repository.RegisterRepository;
import com.nisum.register.repository.entity.Client;
import com.nisum.register.wrapper.RegisterWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterServiceImpl.class);


    /**
     * Autowiring the Client Repository
     */
    @Autowired
    private RegisterRepository registerRepository;

    /**
     * Get All Clients.
     *
     * @return List of all clients.
     */
    @Override
    public List<ClientResponse> getAllClients() {
        List<Client> clients = (List<Client>) registerRepository.findAll();
        List<ClientResponse> clientResponseList = new ArrayList<>();

        for (Client client: clients) {
            clientResponseList.add(RegisterWrapper.convertClientToClientResponse(client));
        }

        return clientResponseList;
    }

    /**
     * Get Client By Id.
     *
     * @param id Id
     * @return Client
     */
    @Override
    public Client getClientById(final Long id) {
        return registerRepository.findById(id).get();
    }

    /**
     * Save Client.
     *
     * @param client Client to save
     * @return Saved Client
     */
    @Override
    public ClientResponse saveClient(final ClientRequest client) {
        LOGGER.info("Consuming saveUser:::RegisterServiceImpl");
        ClientResponse clientResponse = null;
        try {
            Client clientEntity = registerRepository.findByEmail(client.getEmail());
            if(clientEntity == null){
                clientEntity = RegisterWrapper.convertClientRequestToClient(client);
                registerRepository.save(clientEntity);
                clientResponse = RegisterWrapper.convertClientToClientResponse(clientEntity);
            }else{
                LOGGER.info("Email inserted have been associated with some user previously");
            }
        }catch (Exception exp){

        }
        return clientResponse;
    }

    /**
     * Update Client.
     *
     * @param id             Id
     * @param clientToUpdate Client to Update
     * @return Updated Client
     */
    @Override
    public ClientResponse updateClientById(final Long id, final ClientRequest clientToUpdate) {
        ClientResponse clientResponse = null;
        // Fetch the Client from db
        Client clientFromDb = registerRepository.findById(id).get();
        clientFromDb.setName(clientToUpdate.getName());
        //clientFromDb.setNumberOfMoons(clientToUpdate.getNumberOfMoons());
        registerRepository.save(clientFromDb);
        return clientResponse;
    }

    /**
     * Delete Client by Id.
     *
     * @param id Id
     */
    @Override
    public void deleteClientById(final Long id) {
        registerRepository.deleteById(id);
    }
}
