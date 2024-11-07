package enerweave.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HEMS {
    String name;
    String producer;
    List<Hardware> supportedHardwares;
}
