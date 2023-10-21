package com.doctor.appointment.services;

import com.doctor.appointment.models.Doctor;
import com.doctor.appointment.objects.DoctorObject;
import com.doctor.appointment.repositories.DoctorRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Slf4j
public class DoctorsServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;
    @Override
    public HashMap saveDoctor(DoctorObject doctor) {
        HashMap<String, String> response = new HashMap<>();
        try {
            Doctor existingDoctor = doctorRepository.findByEmail(doctor.getEmail());
            if (existingDoctor!=null){
                response.put("message", "User with that email already exist");
                return response;
            }
            Doctor newDoctor = Doctor.builder()
                    .email(doctor.getEmail())
                    .firstName(doctor.getFirstName())
                    .lastName(doctor.getLastName())
                    .phoneNumber(doctor.getPhoneNumber())
                    .build();
            doctorRepository.save(newDoctor);

            response.put("messsage", "doctor saved successfully");
            response.put("status", "200");
            return response;
        }
        catch (Exception e){
            e.printStackTrace();
            log.info(e.getMessage());
             response.put("message", "An error occurred");
            return response;
        }

    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getDoctor(long id) {
        try {
            Optional<Doctor> doctor = doctorRepository.findById(id);
            return doctor.orElse(null);
        }
        catch (Exception e){
            e.printStackTrace();
            log.info(e.getMessage());
        }
        return null;
    }
}
