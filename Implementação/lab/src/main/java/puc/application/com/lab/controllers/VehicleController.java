package puc.application.com.lab.controllers;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan(basePackageClasses = VehicleController.class)
public class VehicleController {

    @GetMapping("/vehicles")
    String getVehicle() {
        String vehicle = "retornou kraiooo";
        return vehicle;
    }
}
