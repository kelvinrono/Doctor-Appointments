package com.doctor.appointment.repositories;

import com.doctor.appointment.models.Appointments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointments, Long> {
//    List<Appointments> findByDoctor_Id(long id);
    List<Appointments> findByPatient_Id(long id);
    List<Appointments> findByDoctor_Id(long id);

}
