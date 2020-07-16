package com.api.phoneoperator.repositories;

import com.api.phoneoperator.models.dao.OperatorDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OperatorsRepository extends CrudRepository<OperatorDao, String> {
    Optional<OperatorDao> findOperatorDaoByEmail(String email);
}
