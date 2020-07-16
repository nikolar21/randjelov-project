package com.api.phoneoperator.services;

import com.api.phoneoperator.models.dao.LoginDetailsDao;
import com.api.phoneoperator.models.rest.LoginDetails;
import com.api.phoneoperator.repositories.LoginDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginDetailsService {

    private final LoginDetailsRepository loginDetailsRepository;

    @Autowired
    public LoginDetailsService(LoginDetailsRepository loginDetailsRepository) {
        this.loginDetailsRepository = loginDetailsRepository;
    }

    public boolean authenticateUser(LoginDetails loginDetails) {
        LoginDetailsDao foundUserByEmail =
                this.loginDetailsRepository.findLoginDetailsByEmail(loginDetails.getEmail()).orElse(null);

        if (foundUserByEmail != null) {
            return foundUserByEmail.getPassword().equals(loginDetails.getPassword());
        }

        return false;
    }
}
