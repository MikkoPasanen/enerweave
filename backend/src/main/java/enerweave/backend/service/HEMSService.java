package enerweave.backend.service;

import enerweave.backend.dto.HEMSDTO;
import enerweave.backend.entity.HEMS;
import enerweave.backend.entity.Hardware;
import enerweave.backend.repository.HEMSRepository;
import enerweave.backend.requests.FindHEMSRequest;
import enerweave.backend.responses.HEMSResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HEMSService {

    private final HEMSRepository hemsRepository;

    public HEMSResponse findHEMS(FindHEMSRequest request) {
        // Extract models from request's hardware list
        List<String> models = request.getHardwareList().stream()
                .map(Hardware::getModel)
                .collect(Collectors.toList());

        // Fetch HEMS entities that support any of the specified hardware models
        List<HEMS> hemsList = hemsRepository.findHEMSBySupportedHardwareModels(models);

        // Map HEMS entities to DTOs, calculate the supported hardware count
        List<HEMSDTO> hemsDtoList = hemsList.stream()
                .map(hems -> {
                    // Filter supported hardwares based on the requested hardware models
                    List<Hardware> supportedHardwares = hems.getSupportedHardwares().stream()
                            .filter(hw -> models.contains(hw.getModel()))
                            .collect(Collectors.toList());

                    return HEMSDTO.builder()
                            .name(hems.getName())
                            .producer(hems.getProducer())
                            .supportedHardwares(supportedHardwares)
                            .amountOfSupportedHardwares(supportedHardwares.size())
                            .build();
                })
                .sorted((hems1, hems2) -> Integer.compare(hems2.getAmountOfSupportedHardwares(), hems1.getAmountOfSupportedHardwares()))
                .collect(Collectors.toList());

        return new HEMSResponse(hemsDtoList.size(), hemsDtoList);
    }

}