package enerweave.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class HEMS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String producer;

    @ManyToMany
    @JoinTable(
            name = "HEMS_Hardware",
            joinColumns = @JoinColumn(name = "hems_id"),
            inverseJoinColumns = @JoinColumn(name = "hardware_id")
    )
    private List<Hardware> supportedHardwares;
}
