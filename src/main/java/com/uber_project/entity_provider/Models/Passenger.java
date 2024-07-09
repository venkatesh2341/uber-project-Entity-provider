package com.uber_project.entity_provider.Models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler" , "bookings"})
public class Passenger extends BaseModel {

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phoneNumber;


    @OneToMany(mappedBy = "passenger", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @Fetch(FetchMode.SUBSELECT)
    private List<Booking> bookings = new ArrayList<>();

    @OneToOne
    private Booking activeBooking;

    @DecimalMax(value="5.00", message="Rating must be less than or equal to 5.00")
    @DecimalMin(value="0.00", message="Rating must be greater than or equal to 0.00")
    private Double rating;

    @OneToOne
    private ExactLocation lastKnownLocation;

    @OneToOne
    private ExactLocation home;
}