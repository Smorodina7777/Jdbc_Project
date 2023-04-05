package org.example.antity;

import lombok.Data;
import org.example.dto.Animals;

import javax.persistence.Entity;

@Entity
@Data
public class Fish extends Animals {
    private  String test;
    private  String test2;

}
