package com.doctor.appointment.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "appointments")
@Builder
public class Appointments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "appointment_date")
    private LocalDateTime appointmentDate;
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "doctor_id"
    )
    private Doctor doctor;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "patient_id"
    )
    private Patient patient;
}
