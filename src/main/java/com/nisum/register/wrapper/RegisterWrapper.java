package com.nisum.register.wrapper;

import com.nisum.register.model.ClientRequest;
import com.nisum.register.model.ClientResponse;
import com.nisum.register.model.PhoneRequest;
import com.nisum.register.repository.entity.Client;
import com.nisum.register.repository.entity.Phone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Set;

public abstract class RegisterWrapper {
    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterWrapper.class);

    public static Client convertClientRequestToClient(ClientRequest client){
        LOGGER.info("Init convertClientRequestToClient ::::::");
        Client clientEntity = null;
        if(clientEntity != null){
            clientEntity = new Client();
            clientEntity.setName(client.getName());
            clientEntity.setEmail(client.getEmail());
            clientEntity.setPassword(client.getPassword());
            clientEntity.setPhone(convertPhoneToPhoneEntity(client.getPhoneRequests()));
        }
        LOGGER.info("End convertClientRequestToClient ::::::");
        return clientEntity;
    }

    public static Set<Phone> convertPhoneToPhoneEntity(List<PhoneRequest> phones){
        Set<Phone> phoneSet = null;
        if(phones.size() > 0){
            for (PhoneRequest phoneRequest: phones){
                Phone phone = new Phone();
                phone.setNumber(phoneRequest.getNumber());
                phone.setCityCode(phoneRequest.getCityCode());
                phone.setCountryCode(phoneRequest.getCountryCode());
                phoneSet.add(phone);
            }
        }
        return  phoneSet;
    }

    public static ClientResponse convertClientToClientResponse(Client clientEntity) {
        LOGGER.info("Init convertClientToClientResponse ::::::");
        ClientResponse clientResponse = new ClientResponse();
        clientResponse.setId(clientEntity.getIdClient().toString());
        clientResponse.setCreated(clientEntity.getCreated());
        clientResponse.setModified(clientEntity.getModified());
        clientResponse.setLast_login(clientEntity.getLast_login());
        clientResponse.setToken(clientEntity.getToken());
        clientResponse.setIsactive(clientEntity.isActive());
        LOGGER.info("End convertClientToClientResponse ::::::");
        return clientResponse;
    }
}
