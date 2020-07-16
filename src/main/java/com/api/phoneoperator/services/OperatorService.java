package com.api.phoneoperator.services;

import com.api.phoneoperator.models.dao.Operator;
import com.api.phoneoperator.repositories.OperatorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperatorService {

    private final OperatorsRepository operatorsRepository;

    @Autowired
    public OperatorService(OperatorsRepository operatorsRepository) {
        this.operatorsRepository = operatorsRepository;
    }

    public Operator getOperatorDetails(String email) {
        return this.operatorsRepository.findOperatorDaoByEmail(email).orElse(null);
    }
}
