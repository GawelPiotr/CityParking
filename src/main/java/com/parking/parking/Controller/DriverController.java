package com.parking.parking.Controller;


import com.parking.parking.Model.Driver;
import com.parking.parking.Service.DriverService;
import com.parking.parking.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/** DriverController has all endpoints of drivers. This controller lets to save new driver,
 * saving starting time of parking car,
 * saving ending time of parking car,
 * showing how much driver's to pay for parking
 */
@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @Autowired
    private PaymentService paymentService;


    /**
     * addDriver's saving new Driver
     * @param newDriver - Object Driver from body
     * @return driver's fields
     */

    @PostMapping("/addDriver")
    public Driver addDriver(@RequestBody Driver newDriver){
        return driverService.addNewDriver(newDriver);
    }


    /**
     * startParking's starting count time for the selected driver
     * @param driverId - driver's id
     * @return - shows time of starting parking
     */
    @PostMapping("/startParking/{driverId}")
    public LocalDateTime startParking(@PathVariable int driverId){
        try {
            return driverService.startParking(driverId);
        }catch (NullPointerException e){
            return null;
        }
    }

    /**
     * finishParking's finishing count time for the selected driver
     * @param driverId - driver's id
     * @return - shows the full time of parking car
     */
    @PostMapping("/finishParking/{driverId}")
    public Double finishParking(@PathVariable int driverId){
        try {
            return driverService.finishParking(driverId);
        }catch (NullPointerException e){
            return null;
        }
    }

    /**
     * payment's generate value to pay for the selected driver
     * @param driverId - driver's id
     * @return - shows vale to pay
     */
    @PostMapping("/payment/{driverId}")
    public Double payment(@PathVariable int driverId){
        try {
            return paymentService.peyment(driverId);
        }catch (NullPointerException e){
            return null;
        }

    }
}
