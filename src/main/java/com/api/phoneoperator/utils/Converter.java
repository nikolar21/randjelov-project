package com.api.phoneoperator.utils;

import com.api.phoneoperator.models.dao.ClientDao;
import com.api.phoneoperator.models.dao.OperatorDao;
import com.api.phoneoperator.models.rest.Client;
import com.api.phoneoperator.models.rest.Operator;
import org.springframework.stereotype.Service;

public class Converter {
    public static OperatorDao operatorRestModelToOperatorDao(Operator operator) {
        OperatorDao operatorDao = new OperatorDao();
        operatorDao.setFirstName(operator.getFirstName());
        operatorDao.setLastName(operator.getLastName());
        operatorDao.setAccountType(operator.getAccountType());
        operatorDao.setPositionName(operator.getPositionName());
        operatorDao.setAge(operator.getAge());
        operatorDao.setEmail(operator.getEmail());
        operatorDao.setPassword(operator.getPassword());

        return operatorDao;
    }

    public static ClientDao clientRestModelToClientDao(Client client) {
        ClientDao clientDao = new ClientDao();
        clientDao.setFirstName(client.getFirstName());
        clientDao.setLastName(client.getLastName());
        clientDao.setHasPayed(client.isHasPayed());
        clientDao.setMegabytesLeft(client.getMegabytesLeft());
        clientDao.setMessagesLeft(client.getMessagesLeft());
        clientDao.setMinutesLeft(client.getMinutesLeft());
        clientDao.setPaymentAmount(client.getPaymentAmount());
        clientDao.setAccountType(client.getAccountType());
        clientDao.setAge(client.getAge());
        clientDao.setPassword(client.getPassword());
        clientDao.setEmail(client.getEmail());

        return clientDao;
    }
}
