package com.api.phoneoperator.repositories;

import com.api.phoneoperator.models.dao.LoginDetailsDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginDetailsRepository extends CrudRepository<LoginDetailsDao, String> {
    Optional<LoginDetailsDao> findLoginDetailsByEmail(String email);
}
