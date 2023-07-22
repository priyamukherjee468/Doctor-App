package com.example.DoctorApp.Repository;

import com.example.DoctorApp.Model.AuthenticationToken;
import com.example.DoctorApp.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthTokenRepo extends JpaRepository<AuthenticationToken,Long> {
    AuthenticationToken findFirstByTokenValue(String authTokenValue);

    //AuthenticationToken findfirstbyPatient(Patient patient);

    //AuthenticationToken findfirstbyPatientId(Long patientId);
}
