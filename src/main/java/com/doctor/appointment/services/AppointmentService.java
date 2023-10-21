package com.doctor.appointment.services;

import com.doctor.appointment.models.Appointments;
import com.doctor.appointment.objects.AppointmentObject;

import java.util.HashMap;
import java.util.List;

public interface AppointmentService {
    List<Appointments> doctorAppointments(long id);
    List<Appointments> patientAppointments(long id);
    HashMap makeAppointment(AppointmentObject appointment);
}
