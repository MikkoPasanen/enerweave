package enerweave.backend.dto;

import enerweave.backend.entity.HEMS;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HardwareDTO {

    private String model;

    private String category;

    private String producer;

    private List<HEMS> hemsProviders;
}
