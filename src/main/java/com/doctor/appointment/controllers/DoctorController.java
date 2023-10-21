package com.doctor.appointment.controllers;

import com.doctor.appointment.models.Doctor;
import com.doctor.appointment.models.Patient;
import com.doctor.appointment.objects.DoctorObject;
import com.doctor.appointment.objects.PatientObject;
import com.doctor.appointment.services.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/doctor")
public class DoctorController {
    private final DoctorService doctorService;

        @PostMapping("save-doctor")
        public HashMap saveDoctor(@RequestBody DoctorObject doctorObject){
            return doctorService.saveDoctor(doctorObject);
        }
        @GetMapping("get-all-doctors")
        public List<Doctor> getAllDoctors(){
            return doctorService.getAllDoctors();
        }

        @GetMapping("get-doctor/{id}")
        public Doctor getPatient(@PathVariable("id") long id){
            return doctorService.getDoctor(id);
        }


}
