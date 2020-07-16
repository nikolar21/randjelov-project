package com.api.phoneoperator.services;

import com.api.phoneoperator.models.dao.OperatorDao;
import com.api.phoneoperator.models.rest.Operator;
import com.api.phoneoperator.repositories.OperatorsRepository;
import com.api.phoneoperator.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperatorService {

    private final OperatorsRepository operatorsRepository;

    @Autowired
    public OperatorService(OperatorsRepository operatorsRepository) {
        this.operatorsRepository = operatorsRepository;
    }

    public OperatorDao getOperatorDetails(String email) {
        return this.operatorsRepository.findOperatorDaoByEmail(email).orElse(null);
    }

    public void addNewOperator(Operator operator) {
        this.operatorsRepository.save(Converter.operatorRestModelToOperatorDao(operator));
    }
}
