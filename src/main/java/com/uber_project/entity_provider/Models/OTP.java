package com.uber_project.entity_provider.Models;


import jakarta.persistence.Entity;
import lombok.*;

import java.util.Random;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OTP extends BaseModel {

    private String code;

    private String sentToNumber;

    public static OTP makeOTP(String phoneNumber){

        Random r = new Random();
        Integer code = r.nextInt(9000)+1000;
        return OTP.builder().code(code.toString()).sentToNumber(phoneNumber).build();
    }
}
