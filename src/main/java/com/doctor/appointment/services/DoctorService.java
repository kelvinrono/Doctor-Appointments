package com.doctor.appointment.services;

import com.doctor.appointment.models.Doctor;
import com.doctor.appointment.objects.DoctorObject;

import java.util.HashMap;
import java.util.List;

public interface DoctorService {
    HashMap saveDoctor(DoctorObject doctor);
    List<Doctor> getAllDoctors();
    Doctor getDoctor(long id);

}
