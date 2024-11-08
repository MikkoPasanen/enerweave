package enerweave.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Hardware {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String model;

    String category;

    String producer;
}
