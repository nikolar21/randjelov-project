package com.api.phoneoperator.repositories;

import com.api.phoneoperator.models.dao.Operator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OperatorsRepository extends CrudRepository<Operator, String> {
    Optional<Operator> findOperatorDaoByEmail(String email);
}
