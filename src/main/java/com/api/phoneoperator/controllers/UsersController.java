package com.api.phoneoperator.controllers;

import com.api.phoneoperator.models.User;
import com.api.phoneoperator.models.dao.ClientDao;
import com.api.phoneoperator.models.dao.LoginDetailsDao;
import com.api.phoneoperator.models.rest.*;
import com.api.phoneoperator.services.ClientService;
import com.api.phoneoperator.services.LoginDetailsService;
import com.api.phoneoperator.services.OperatorService;
import com.api.phoneoperator.utils.Constants;
import com.api.phoneoperator.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/v1/users")
public class UsersController {

    private final LoginDetailsService loginDetailsService;
    private final OperatorService operatorService;
    private final ClientService clientService;

    @Autowired
    public UsersController(LoginDetailsService loginDetailsService,
                           OperatorService operatorService,
                           ClientService clientService) {
        this.loginDetailsService = loginDetailsService;
        this.operatorService = operatorService;
        this.clientService = clientService;
    }

    @PostMapping(value = "/register-operator")
    public ResponseEntity<String> registerOperator(@RequestBody Operator operator) {
        if (operator != null) {
            operator.setAccountType(Constants.OPERATOR);
           operatorService.addNewOperator(operator);
           final LoginDetailsDao loginDetailsDao = new LoginDetailsDao(operator.getEmail(), operator.getPassword());
           loginDetailsService.addNewUser(loginDetailsDao);
           return ResponseEntity.ok(Constants.SUCCESS_RESPONSE);
        }

        return ResponseEntity.ok(Constants.FAIL_RESPONSE);
    }

    @PostMapping(value = "/register-client")
    public ResponseEntity<String> registerClient(@RequestBody Client client) {
        if (client != null) {
            client.setAccountType(Constants.CLIENT);
            clientService.addNewClient(client);
            final LoginDetailsDao loginDetailsDao = new LoginDetailsDao(client.getEmail(), client.getPassword());
            loginDetailsService.addNewUser(loginDetailsDao);
            return ResponseEntity.ok(Constants.SUCCESS_RESPONSE);
        }

        return ResponseEntity.ok(Constants.FAIL_RESPONSE);
    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity<AuthentificationResponse> authenticateUser(@RequestBody LoginDetails loginDetails) {
        boolean foundUser = this.loginDetailsService.authenticateUser(loginDetails);
        if (foundUser) {
            return ResponseEntity.ok(
                    new AuthentificationResponse(
                            getUserDetailsFromDatabase(loginDetails.getEmail()),
                            Constants.SUCCESS_RESPONSE));
        } else {
            return ResponseEntity.ok(new AuthentificationResponse(null, Constants.FAIL_RESPONSE));
        }
    }

    private User getUserDetailsFromDatabase(String email) {
        ClientDao clientDaoDetails = this.clientService.getClientDetails(email);
        if (clientDaoDetails != null) {
            return clientDaoDetails;
        }

        return this.operatorService.getOperatorDetails(email);
    }

    @GetMapping(value = "/get-clients")
    public ResponseEntity<AllClientsResponse> getAllClients() {
        List<Client> clients = this.clientService.getAllClients();
        if (clients != null) {
            return ResponseEntity.ok(new AllClientsResponse(Constants.SUCCESS_RESPONSE, clients));
        }

        return ResponseEntity.ok(new AllClientsResponse(Constants.FAIL_RESPONSE, null));
    }

    @PostMapping(value = "/add-resources")
    public ResponseEntity<String> addResourcesForGivenClient(@RequestBody ResourcesInfo resourcesInfo) {
        Client client = Converter.clientDaoInClientRestModel(
                this.clientService.getClientDetails(resourcesInfo.getClientEmail()));
        client.setMinutesLeft(client.getMinutesLeft() + resourcesInfo.getMinutesToAdd());
        client.setMegabytesLeft(client.getMegabytesLeft() + resourcesInfo.getMegabytesToAdd());
        client.setMessagesLeft(client.getMessagesLeft() + resourcesInfo.getMessagesToAdd());
        double paymentAmount = client.getMinutesLeft() + client.getMegabytesLeft() + client.getMessagesLeft();
        client.setPaymentAmount(paymentAmount);
        this.clientService.updateClientDetails(client);

        return ResponseEntity.ok(Constants.SUCCESS_RESPONSE);

    }
}
