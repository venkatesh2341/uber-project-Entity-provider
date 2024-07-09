package com.uber_project.entity_provider.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler" , "bookings"})
public class Driver extends BaseModel{

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String licenseNumber;

    @Column(nullable = true)
    private String phoneNumber;

    @Column(nullable = false)
    private String aadhaar;

    @OneToOne(mappedBy = "driver", cascade = {CascadeType.ALL})
    private Car car;

    @Enumerated(value = EnumType.STRING)
    private DriverApprovalStatus driverApprovalStatus;

    @OneToOne
    private ExactLocation lastKnownLocation;

    @OneToOne
    private ExactLocation home;

    private String activeCity;

    @DecimalMax(value="5.00", message="Rating must be less than or equal to 5.00")
    @DecimalMin(value="0.00", message="Rating must be greater than or equal to 0.00")
    private Double rating;

    private boolean isAvailable;

    // 1 : n , Driver : Booking
    @OneToMany(mappedBy = "driver", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @Fetch(FetchMode.SUBSELECT)
    private List<Booking> bookings;
}