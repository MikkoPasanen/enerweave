package enerweave.backend.mapper;

import enerweave.backend.dto.HardwareDTO;
import enerweave.backend.entity.Hardware;
import org.mapstruct.Mapper;


// This interface maps entities to dtos, and other way around
@Mapper(componentModel = "spring")
public interface HardwareMapper {

    // maps Hardware object into HardwareDTO object
    HardwareDTO toDTO(Hardware hardware);

    // maps HardwareDTO object into Hardware object
    Hardware toEntity(HardwareDTO hardwareDTO);
}
