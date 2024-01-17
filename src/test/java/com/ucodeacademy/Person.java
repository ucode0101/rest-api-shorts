package com.ucodeacademy;

import lombok.*;

@Getter // Generates getters for all fields
@Setter // Generates setters for all fields
@NoArgsConstructor // Generate No arg Constructor
@AllArgsConstructor // generate all arg constructor
@ToString // adds/overrides toString Method

public class Person {

    private String firstName;
    private String lastName;
    private String birthdate;
    private String email;
    private String phone;


}
