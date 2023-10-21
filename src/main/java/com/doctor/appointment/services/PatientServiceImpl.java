package com.doctor.appointment.services;

import com.doctor.appointment.models.Patient;
import com.doctor.appointment.objects.PatientObject;
import com.doctor.appointment.repositories.PatientRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    @Override
    public Patient getPatient(long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        return patient.orElseThrow(()-> new IllegalArgumentException("patient with that id could not be found"));
    }

    @Override
    public List<Patient> allPatients() {
        return patientRepository.findAll();
    }
    @Override
    public HashMap savePatient(PatientObject patient) {
        HashMap <String, String> response = new HashMap<>();
        try {
            Patient patient_ = Patient.builder()
                    .email(patient.getEmail())
                    .firstName(patient.getFirstName())
                    .lastName(patient.getLastName())
                    .phoneNumber(patient.getPhoneNumber())
                    .build();
            patientRepository.save(patient_);
            response.put("message", "Patient saved successfully");
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
}
