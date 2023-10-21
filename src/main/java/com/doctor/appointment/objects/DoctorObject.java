package com.doctor.appointment.objects;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class DoctorObject {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
