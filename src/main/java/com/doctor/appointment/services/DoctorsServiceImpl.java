package com.doctor.appointment.services;

import com.doctor.appointment.models.Doctor;
import com.doctor.appointment.objects.DoctorObject;
import com.doctor.appointment.repositories.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class DoctorsServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;
    @Override
    public HashMap saveDoctor(DoctorObject doctor) {
        HashMap<String, String> response = new HashMap<>();
        Doctor _doctor = Doctor.builder()
                .email(doctor.getEmail())
                .firstName(doctor.getFirstName())
                .lastName(doctor.getLastName())
                .phoneNumber(doctor.getPhoneNumber())
                .build();
        doctorRepository.save(_doctor);

        response.put("messsage", "doctor saved successfully");
        response.put("status", "200");
        return response;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getDoctor(long id) {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        return doctor.orElse(null);
    }
}
