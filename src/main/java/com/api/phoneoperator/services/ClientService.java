package com.api.phoneoperator.services;

import com.api.phoneoperator.models.dao.Client;
import com.api.phoneoperator.repositories.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientsRepository clientsRepository;

    @Autowired
    public ClientService(ClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    }

    public Client getClientDetails(String email) {
        return this.clientsRepository.findClientDaoByEmail(email).orElse(null);
    }
}
