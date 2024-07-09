package com.uber_project.entity_provider.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PassengerReview extends Review{

    @Column(nullable = false)
    private String passengerReviewContent;

    @Column(nullable = false)
    private String passengerRating;
}