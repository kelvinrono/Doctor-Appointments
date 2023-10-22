package com.doctor.appointment.services;

import com.doctor.appointment.models.Appointments;
import com.doctor.appointment.models.User;
import com.doctor.appointment.models.Patient;
import com.doctor.appointment.objects.AppointmentObject;
import com.doctor.appointment.repositories.AppointmentRepository;
import com.doctor.appointment.repositories.UserRepository;
import com.doctor.appointment.repositories.PatientRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class AppointmentServiceImpl implements AppointmentService{
    private final AppointmentRepository appointmentRepository;
    private final UserRepository userRepository;
    private final PatientRepository patientRepository;

    @Override
    public HashMap makeAppointment(AppointmentObject appointment) {
        HashMap<String, String> response = new HashMap<>();

        try {

            User patient = userRepository.findById(appointment.getPatient()).orElseThrow(()-> new IllegalArgumentException("User does not exist"));
            User doctor = userRepository.findById(appointment.getDoctor()).orElseThrow(()-> new IllegalArgumentException("User does not exist"));
            Appointments newAppointment = Appointments.builder()
                    .appointmentDate(appointment.getAppointmentDate())
                    .description(appointment.getDescription())
                    .patient(patient)
                    .doctor(doctor)
                    .build();
            appointmentRepository.save(newAppointment);
            log.info("user saved!");
            response.put("message", "Appointment saved successfully at "+newAppointment.getAppointmentDate());
            response.put("status", "200");
            return response;
        }
        catch (Exception e){
            e.printStackTrace();
            log.info(e.getMessage());
            response.put("message", "An error occurred!");
            return response;
        }

    }


    @Override
    public List<Appointments> patientAppointments(long id) {
        try {
            log.info("..Querying patient information...");
            return appointmentRepository.findByPatient_Id(id);
        }
        catch (Exception e){
            e.printStackTrace();
            log.info(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Appointments> doctorAppointment(long id) {
        return appointmentRepository.findByDoctor_Id(id);
    }

}
