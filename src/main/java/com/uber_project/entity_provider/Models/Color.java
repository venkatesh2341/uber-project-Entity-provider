package com.uber_project.entity_provider.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Color extends BaseModel{
    @Column(unique = true, nullable = false)
    String name;
}
