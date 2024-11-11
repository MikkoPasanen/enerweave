package enerweave.backend.controller;

import enerweave.backend.requests.FindHEMSRequest;
import enerweave.backend.responses.HEMSResponse;
import enerweave.backend.service.HEMSService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class HEMSController {

    private final HEMSService service;

    @GetMapping("/hello")
    @CrossOrigin(origins = {"http://localhost:5173", "http://frontend-696896399.eu-north-1.elb.amazonaws.com", "*"})
    public ResponseEntity<String> getHello() {
        return new ResponseEntity<>("Hello from the backend!", HttpStatus.OK);
    }

    @PostMapping("/find-hems")
    public ResponseEntity<HEMSResponse> findHEMS(@RequestBody FindHEMSRequest request) {
        HEMSResponse hemsResponse = service.findHEMS(request);

        return new ResponseEntity<>(hemsResponse, HttpStatus.OK);
    }
}
