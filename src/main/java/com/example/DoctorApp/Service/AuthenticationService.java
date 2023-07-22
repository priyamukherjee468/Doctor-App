package com.example.DoctorApp.Service;

import com.example.DoctorApp.Model.AuthenticationToken;
import com.example.DoctorApp.Repository.IAuthTokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    IAuthTokenRepo authTokenRepo;

    public boolean authenticate(String email, String authTokenValue)
    {
        AuthenticationToken authToken = authTokenRepo.findFirstByTokenValue(authTokenValue);

        if(authToken == null)
        {
            return false;
        }

        String tokenConnectedEmail = authToken.getPatient().getPatientEmail();

        return tokenConnectedEmail.equals(email);
    }

    public String sigOutPatient(String token) {
        AuthenticationToken authenticationToken=authTokenRepo.findFirstByTokenValue(token);
        authTokenRepo.delete(authenticationToken);
        return "signout successfully..";
    }
}
