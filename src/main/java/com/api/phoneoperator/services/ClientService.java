package com.api.phoneoperator.services;

import com.api.phoneoperator.models.dao.ClientDao;
import com.api.phoneoperator.models.rest.Client;
import com.api.phoneoperator.repositories.ClientsRepository;
import com.api.phoneoperator.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    private final ClientsRepository clientsRepository;

    @Autowired
    public ClientService(ClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    }

    public ClientDao getClientDetails(String email) {
        return this.clientsRepository.findClientDaoByEmail(email).orElse(null);
    }

    public void addNewClient(Client client) {
        this.clientsRepository.save(Converter.clientRestModelToClientDao(client));
    }

    public List<Client> getAllClients() {
        List<Client> clientArray = new ArrayList<>();
        this.clientsRepository.findAll()
                .forEach(clientDao ->clientArray.add(Converter.clientDaoInClientRestModel(clientDao)));

        return clientArray;
    }

    public void updateClientDetails(Client client) {
        this.clientsRepository.save(Converter.clientRestModelToClientDao(client));
    }
}
