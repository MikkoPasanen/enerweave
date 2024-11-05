package enerweave.backend.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {

    @GetMapping("/hello")
    @CrossOrigin(origins = {"http://localhost:5173", "http://frontend-696896399.eu-north-1.elb.amazonaws.com"})
    public ResponseEntity<String> getHello() {
        return new ResponseEntity<>("Hello from the backend!", HttpStatus.OK);
    }
}
