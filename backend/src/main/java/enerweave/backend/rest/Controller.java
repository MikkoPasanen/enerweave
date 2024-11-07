package enerweave.backend.rest;

import enerweave.backend.entity.HEMS;
import enerweave.backend.entity.Hardware;
import enerweave.backend.entity.Response;
import enerweave.backend.entity.ToReturnHEMS;
import enerweave.backend.service.ControllerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class Controller {

    ControllerService service = new ControllerService();

    @GetMapping("/hello")
    @CrossOrigin(origins = {"http://localhost:5173", "http://frontend-696896399.eu-north-1.elb.amazonaws.com", "*"})
    public ResponseEntity<String> getHello() {
        return new ResponseEntity<>("Hello from the backend!", HttpStatus.OK);
    }


    @PostMapping("/find-hems")
    public ResponseEntity<Response> findHEMS(@RequestBody List<Hardware> hardwares) {
        List<HEMS> availableHEMS = service.generateListOfHEMS();

        // Place to store all the recommended HEMS
        List<ToReturnHEMS> toReturnHEMSList = new ArrayList<>();

        // Iterate each available HEMS to check if they support the users hardwares
        availableHEMS.forEach(hems -> {
            List<Hardware> supportedHardwares = hardwares.stream()
                    .filter(hw -> hems.getSupportedHardwares().stream()
                            .anyMatch(supportedHardware -> supportedHardware.getModel().equals(hw.getModel())))
                    .collect(Collectors.toList());

            // If the HEMS supports at least one hardware, create a ToReturnHEMS object and store it
            if (!supportedHardwares.isEmpty()) {
                toReturnHEMSList.add(new ToReturnHEMS(hems.getName(), hems.getProducer(), supportedHardwares, supportedHardwares.size()));
            }
        });

        // Sort the HEMS list into descending order based on how many hardwares they support
        toReturnHEMSList.sort((hems1, hems2) -> Integer.compare(hems2.getAmountOfSupportedHardwares(), hems1.getAmountOfSupportedHardwares()));

        return new ResponseEntity<>(new Response(toReturnHEMSList.size(), toReturnHEMSList), HttpStatus.OK);
    }
}
