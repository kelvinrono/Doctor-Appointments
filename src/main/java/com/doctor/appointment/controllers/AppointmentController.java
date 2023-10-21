package com.doctor.appointment.controllers;

import com.doctor.appointment.models.Appointments;
import com.doctor.appointment.objects.AppointmentObject;
import com.doctor.appointment.repositories.AppointmentRepository;
import com.doctor.appointment.services.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;

    @PostMapping("/make-appointment")
    public HashMap makeAppointment(@RequestBody AppointmentObject appointmentObject){
        return appointmentService.makeAppointment(appointmentObject);
    }
    @GetMapping("/get-patient-appointments/{id}")
    public List<Appointments> patientsAppointments(@PathVariable("id") long id){
        return appointmentService.patientAppointments(id);
    }
    @GetMapping("/get-doctor-appointments/{id}")
    public List<Appointments> doctorsAppointment(@PathVariable("id") long id){
        return appointmentService.doctorAppointments(id);
    }
}
