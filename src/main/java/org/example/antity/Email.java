package org.example.antity;

import lombok.Data;
import org.example.dto.Person;

import javax.persistence.*;

@Entity
@Data
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String address;
    @Embedded
    private Person person;
}
