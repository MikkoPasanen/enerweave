package enerweave.backend.mapper;

import enerweave.backend.dto.HEMSDTO;
import enerweave.backend.entity.HEMS;
import org.mapstruct.Mapper;


// This interface maps entities to dtos, and other way around
@Mapper(componentModel = "spring")
public interface HEMSMapper {

    // maps HEMS object into HEMSDTO object
    HEMSDTO toDTO(HEMS hems);

    // maps HEMSDTO object into HEMS object
    HEMS toEntity(HEMSDTO hemsDTO);
}
