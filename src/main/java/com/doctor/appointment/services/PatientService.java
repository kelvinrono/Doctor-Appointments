package com.doctor.appointment.services;

import com.doctor.appointment.models.Patient;
import com.doctor.appointment.objects.PatientObject;

import java.util.HashMap;
import java.util.List;

public interface PatientService {
    Patient getPatient(long id);
    List<Patient> allPatients();
    HashMap savePatient(PatientObject patient);
}
