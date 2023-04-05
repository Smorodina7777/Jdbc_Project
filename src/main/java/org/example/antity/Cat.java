package org.example.antity;

import lombok.Data;
import org.example.dto.Animals;
import javax.persistence.Entity;

@Entity
@Data
public class Cat  extends Animals {
    private String voice;
    private  String color;
}
