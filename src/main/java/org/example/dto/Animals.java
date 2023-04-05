package org.example.dto;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Animals {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private  int id;
    private  String name;
    private  String type;
}
