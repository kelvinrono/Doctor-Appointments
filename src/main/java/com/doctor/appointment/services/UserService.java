package com.doctor.appointment.services;

import com.doctor.appointment.models.User;
import com.doctor.appointment.objects.UserObject;

import java.util.HashMap;
import java.util.List;

public interface UserService {
    HashMap saveUser(UserObject doctor);
    List<User> getAllDoctors(String roleName);
    User getUser(long id);
    List<User> getAllPatients(String roleName);

}
