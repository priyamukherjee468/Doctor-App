package com.example.DoctorApp.Service;

import com.example.DoctorApp.Model.Appointment;
import com.example.DoctorApp.Model.Patient;
import com.example.DoctorApp.Repository.IAppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    IAppointmentRepo appointmentRepo;
    public List<Appointment> getAllAppointments() {
        return appointmentRepo.findAll();
    }
    public void saveAppointment(Appointment appointment) {

        appointment.setAppointmentCreationTime(LocalDateTime.now());
        appointmentRepo.save(appointment);
    }
    public Appointment getAppointmentForPatient(Patient patient) {
        return appointmentRepo.findFirstByPatient(patient);
    }
    public void cancelAppointment(Appointment appointment) {
        appointmentRepo.delete(appointment);

    }


}
