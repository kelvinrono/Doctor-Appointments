package com.doctor.appointment.objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserObject {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private long role;
}
