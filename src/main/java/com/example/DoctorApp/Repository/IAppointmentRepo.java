package com.example.DoctorApp.Repository;

import com.example.DoctorApp.Model.Appointment;
import com.example.DoctorApp.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppointmentRepo extends JpaRepository<Appointment,Long> {
    Appointment findFirstByPatient(Patient patient);
}
