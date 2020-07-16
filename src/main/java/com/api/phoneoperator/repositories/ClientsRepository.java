package com.api.phoneoperator.repositories;

import com.api.phoneoperator.models.dao.ClientDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientsRepository extends CrudRepository<ClientDao, String> {
    Optional<ClientDao> findClientDaoByEmail(String email);
}
