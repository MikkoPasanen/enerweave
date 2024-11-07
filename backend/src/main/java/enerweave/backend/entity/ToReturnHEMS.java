package enerweave.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

// Contains all the necessary info from the HEMS that will be returned to the frontend
@Data
@AllArgsConstructor
public class ToReturnHEMS {
    String name;
    String producer;

    // contains only the hardwares that the customer has and this HEMS supports
    List<Hardware> supportedHardwares;
    int amountOfSupportedHardwares;
}
