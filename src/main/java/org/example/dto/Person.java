package org.example.dto;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Person {
    private int phone;
    private  String firstName;
    private  String lastName;
    private  String middleName;
}
