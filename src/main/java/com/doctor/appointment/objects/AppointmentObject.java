package com.doctor.appointment.objects;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class AppointmentObject {
    private LocalDateTime appointmentDate;
    private String description;
    private long doctor;
    private long patient;
}
