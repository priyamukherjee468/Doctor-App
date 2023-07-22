package com.example.DoctorApp.Controller;

import com.example.DoctorApp.Model.Appointment;
import com.example.DoctorApp.Model.Dto.SignInInput;
import com.example.DoctorApp.Model.Dto.SignUpOutput;
import com.example.DoctorApp.Model.Patient;
import com.example.DoctorApp.Service.AuthenticationService;
import com.example.DoctorApp.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
 public class PatientController {
@Autowired
    PatientService patientService;
@Autowired
 AuthenticationService authenticationService;
 @GetMapping("patients")
 List<Patient> getAllPatients()
 {
  return patientService.getAllPatients();
 }
 @PostMapping("patient/signup")
 public SignUpOutput signUpPatient(@RequestBody Patient patient)
 {

  return patientService.signUpPatient(patient);
 }
 @PostMapping("patient/signIn")
 public String signInPatient(@RequestBody SignInInput signInInput)
 {

  return patientService.signInPatient(signInInput);
 }
 @DeleteMapping("patient/signOut")
 public String sigOutPatient(String email, String token) {
  if (authenticationService.authenticate(email, token)) {
   return authenticationService.sigOutPatient(token);
  } else {
   return "Sign out not allowed for non authenticated user.";
  }
 }
  @PostMapping("appointment/schedule")
 public String  scheduleAppointment(@RequestBody Appointment appointment, String email, String token)
 {

  if(authenticationService.authenticate(email,token)) {
   boolean status = patientService.scheduleAppointment(appointment);
   return status ? "appointment scheduled":"error occurred during scheduling appointment";
  }
  else
  {
   return "Scheduling failed because invalid authentication";
  }
 }
 @DeleteMapping("appointment/cancel")
 public String cancelAppointment(String email, String token){
  if(authenticationService.authenticate(email, token)){
   patientService.cancelAppointment(email);
   return "cancel Appointment Successfully.";
  }else{
   return "Scheduling failed because invalid authentication";
  }

 }

}
