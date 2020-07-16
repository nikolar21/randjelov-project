package com.api.phoneoperator.repositories;

import com.api.phoneoperator.models.dao.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientsRepository extends CrudRepository<Client, String> {
    Optional<Client> findClientDaoByEmail(String email);
}
