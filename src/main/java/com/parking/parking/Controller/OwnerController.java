package com.parking.parking.Controller;


import com.parking.parking.Model.Payment;
import com.parking.parking.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

/** OwnerController is dedicated for Owners. This controller lets to owners find out how much many was earned during a day
 */

@RestController
@RequestMapping("/owner")
public class OwnerController {

    @Autowired
    private PaymentService paymentService;

    /**
     * checkEarnedDuringDay's checking how much much money was earned during a given day
     * @param date - date of day witch Owner wants to check
     * @return - value of earned during a given day
     */
    @PostMapping("/checkEarned")
    public double checkEarnedDuringDay(@RequestBody Payment date){
       LocalDate date1 = date.getDate();
        return paymentService.checkEarned(date1);
    }
}
