package com.example.DoctorApp.Service;

import com.example.DoctorApp.Model.Appointment;
import com.example.DoctorApp.Model.AuthenticationToken;
import com.example.DoctorApp.Model.Dto.SignInInput;
import com.example.DoctorApp.Model.Dto.SignUpOutput;
import com.example.DoctorApp.Model.Patient;
import com.example.DoctorApp.Repository.IAppointmentRepo;
import com.example.DoctorApp.Repository.IAuthTokenRepo;
import com.example.DoctorApp.Repository.IDoctorRepo;
import com.example.DoctorApp.Repository.IPatientRepo;
import com.example.DoctorApp.Service.emailUtility.EmailHandler;
import com.example.DoctorApp.Service.hashingUtility.PasswordEncrypter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    IPatientRepo patientRepo;

@Autowired
    IAuthTokenRepo authTokenRepo;
@Autowired
    IDoctorRepo doctorRepo;
@Autowired
    IAppointmentRepo appointmentRepo;
@Autowired
AppointmentService appointmentService;

    public SignUpOutput signUpPatient(Patient patient) {
        boolean signUpStatus = true;
        String signUpStatusMessage = null;
        String newEmail = patient.getPatientEmail();
        if(newEmail == null)
        {
            signUpStatusMessage = "Invalid email";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus,signUpStatusMessage);
        }
        Patient existingPatient = patientRepo.findFirstByPatientEmail(newEmail);

        if(existingPatient != null)
        {
            signUpStatusMessage = "Email already registered!!!";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus,signUpStatusMessage);
        }

        //hash the password: encrypt the password
        try {
            String encryptedPassword = PasswordEncrypter.encryptPassword(patient.getPatientPassword());

            //saveAppointment the patient with the new encrypted password

            patient.setPatientPassword(encryptedPassword);
            patientRepo.save(patient);

            return new SignUpOutput(signUpStatus, "Patient registered successfully!!!");
        }
        catch(Exception e)
        {
            signUpStatusMessage = "Internal error occurred during sign up";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus,signUpStatusMessage);
        }
    }
    public List<Patient> getAllPatients() {
        return patientRepo.findAll();
    }


    public String signInPatient(SignInInput signInInput) {
        boolean signInStatus = true;
        String signInStatusMessage = null;
        String signInEmail = signInInput.getEmail();
        if(signInEmail == null)
        {
            signInStatusMessage = "Invalid email";
            return signInStatusMessage;


        }

        //check if this patient email already exists ??
        Patient existingPatient = patientRepo.findFirstByPatientEmail(signInEmail);

        if(existingPatient == null)
        {
            signInStatusMessage = "Email not registered!!!";
            return signInStatusMessage;

        }

        //match passwords :

        //hash the password: encrypt the password
        try {
            String encryptedPassword = PasswordEncrypter.encryptPassword(signInInput.getPassword());
            if(existingPatient.getPatientPassword().equals(encryptedPassword))
            {
                //session should be created since password matched and user id is valid
                AuthenticationToken authToken  = new AuthenticationToken(existingPatient);
                authTokenRepo.save(authToken);

                EmailHandler.sendEmail(signInEmail,"email testing",authToken.getTokenValue());
                return "Token sent to your email";
            }
            else {
                signInStatusMessage = "Invalid credentials!!!";
                return signInStatusMessage;
            }
        }
        catch(Exception e)
        {
            signInStatusMessage = "Internal error occurred during sign in";
            return signInStatusMessage;
        }

    }


    public boolean scheduleAppointment(Appointment appointment) {
        Long doctorId=appointment.getDoctor().getDoctorId();
        boolean isDoctorValid=doctorRepo.existsById(doctorId);
        Long patientId=appointment.getPatient().getPatientId();
        boolean isPatientValid=patientRepo.existsById(patientId);
        if (isDoctorValid && isPatientValid){
            appointmentRepo.save(appointment);
            return true;
        }
        return false;
    }

    public void cancelAppointment(String email) {
        Patient patient=patientRepo.findFirstByPatientEmail(email);
        Appointment appointment=appointmentService.getAppointmentForPatient(patient);
        appointmentService.cancelAppointment(appointment);
    }



}



