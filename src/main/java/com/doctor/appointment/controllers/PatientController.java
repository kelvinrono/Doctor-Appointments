package com.doctor.appointment.controllers;

import com.doctor.appointment.models.Patient;
import com.doctor.appointment.objects.PatientObject;
import com.doctor.appointment.services.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/patient")
public class PatientController {
    private final PatientService patientService;

    @PostMapping("save-patient")
    public HashMap savePatient(@RequestBody PatientObject patientObject){
        return patientService.savePatient(patientObject);
    }
    @GetMapping("get-all-patients")
    public List<Patient> getAllPatients(){
       return patientService.allPatients();
    }

    @GetMapping("get-patient/{id}")
    public Patient getPatient(@PathVariable("id") long id){
        return patientService.getPatient(id);
    }

}
