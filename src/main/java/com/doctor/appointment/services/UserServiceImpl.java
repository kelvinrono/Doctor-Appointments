package com.doctor.appointment.services;

import com.doctor.appointment.models.User;
import com.doctor.appointment.models.Roles;
import com.doctor.appointment.objects.UserObject;
import com.doctor.appointment.repositories.UserRepository;
import com.doctor.appointment.repositories.RoleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    @Override
    public HashMap saveUser(UserObject user) {
        HashMap<String, String> response = new HashMap<>();
        try {
            User existingUser = userRepository.findByEmail(user.getEmail());
            Optional<Roles> role = roleRepository.findById(user.getRole());


            if (existingUser !=null){
                response.put("message", "User with that email already exist");
                return response;
            }
            if(role.isEmpty()){
                 response.put("message", "role does not exist");
                return response;
            }
            User newUser = User.builder()
                    .email(user.getEmail())
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .phoneNumber(user.getPhoneNumber())
                    .role(role.get())
                    .build();
            userRepository.save(newUser);


            response.put("message", "user saved successfully");
            response.put("status", "200");
            return response;
        }
        catch (Exception e){
            e.printStackTrace();
            log.info(e.getMessage());
             response.put("message", "An error occurred");
            return response;
        }

    }

    @Override
    public List<User> getAllDoctors(String role) {
        List<User> doctors = userRepository.findByRole_Name(role);
        return doctors;
    }

    @Override
    public User getUser(long id) {
        try {
            Optional<User> user = userRepository.findById(id);
            return user.orElseThrow(()-> new IllegalArgumentException("User does not exist"));
        }
        catch (Exception e){
            e.printStackTrace();
            log.info(e.getMessage());
        }
        return null;
    }

    @Override
    public List<User> getAllPatients(String roleName) {
        return userRepository.findByRole_Name(roleName);
    }
}
