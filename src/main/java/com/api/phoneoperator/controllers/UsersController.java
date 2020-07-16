package com.api.phoneoperator.controllers;

import com.api.phoneoperator.models.User;
import com.api.phoneoperator.models.dao.Client;
import com.api.phoneoperator.models.rest.AuthentificationResponse;
import com.api.phoneoperator.models.rest.LoginDetails;
import com.api.phoneoperator.services.ClientService;
import com.api.phoneoperator.services.LoginDetailsService;
import com.api.phoneoperator.services.OperatorService;
import com.api.phoneoperator.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
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
        Client clientDetails = this.clientService.getClientDetails(email);
        if (clientDetails != null) {
            return clientDetails;
        }

        return this.operatorService.getOperatorDetails(email);
    }
}
