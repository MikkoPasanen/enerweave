package enerweave.backend.dto;

import enerweave.backend.entity.Hardware;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

// Contains all the necessary info from the HEMS that will be returned to the frontend
@Data
@AllArgsConstructor
@Builder
public class HEMSDTO {
    String name;
    String producer;

    // contains only the hardwares that the customer has and this HEMS supports
    List<Hardware> supportedHardwares;
    int amountOfSupportedHardwares;
}
