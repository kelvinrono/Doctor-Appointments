package com.doctor.appointment.controllers;

import com.doctor.appointment.models.User;
import com.doctor.appointment.objects.UserObject;
import com.doctor.appointment.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;

        @PostMapping("save-user")
        public HashMap saveDoctor(@RequestBody UserObject userObject){
            return userService.saveUser(userObject);
        }
        @GetMapping("get-all-doctors")
        public List<User> getAllDoctors(@RequestParam("role") String role){
            return userService.getAllDoctors(role);
        }
    @GetMapping("get-all-patients")
    public List<User> getAllPatients(@RequestParam("role") String role){
        return userService.getAllPatients(role);
    }

    @GetMapping("get-user/{id}")
    public User getPatient(@PathVariable("id") long id){
        return userService.getUser(id);
    }
    @PostMapping("/login-user")
    public HashMap login(@RequestBody UserObject userObject){
            return userService.loginUser(userObject);
    }

}
