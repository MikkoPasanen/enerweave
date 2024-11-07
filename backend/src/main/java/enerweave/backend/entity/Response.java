package enerweave.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class Response {
    int amountOfRecommendedHEMS;
    List<ToReturnHEMS> allRecommendedHEMS;
}
