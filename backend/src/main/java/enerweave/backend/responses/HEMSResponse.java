package enerweave.backend.responses;

import enerweave.backend.dto.HEMSDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class HEMSResponse {
    int amountOfRecommendedHEMS;
    List<HEMSDTO> allRecommendedHEMS;
}
