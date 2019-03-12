package com.parking.parking.Service;


import com.parking.parking.Model.Driver;
import com.parking.parking.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import java.util.NoSuchElementException;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private DriverService driverService;


    /**
     * payRegular's counting value of pay as regular driver
     * @param parkingTime - is full time of parking car
     * @return value of pay as regular driver
     */
    public double payRegular(double parkingTime){

        double howMuchToPay = 0;

        if(parkingTime <= 1){
            howMuchToPay = 1;
            return howMuchToPay;
        }else if(parkingTime > 1 && parkingTime <= 2) {
            howMuchToPay = 2;
        }else {
           double howToPay = 2*Math.pow(1.5,(parkingTime-2));
            double sto = howToPay*100;
        double dwa = Math.round(sto);
        howMuchToPay = dwa/100;
        }
        return  howMuchToPay;
    }

    /**
     * payVip's counting value of pay as vip driver
     * @param parkingTime - is full time of parking car
     * @return value of pay as vip driver
     */
    public double payVip(double parkingTime){

        double howMuchToPay = 0;

        if(parkingTime <= 1){
            howMuchToPay = 0;
            return howMuchToPay;
        }else if(parkingTime > 1 && parkingTime <= 2) {
            howMuchToPay = 2;
        }else {
            double mathFunction = 2*Math.pow(1.2,(parkingTime-2));
            double multi = mathFunction*100;
            double round = Math.round(multi);
            howMuchToPay = round/100;
        }
        return  howMuchToPay;
    }

    /**
     * checkEarned's counting how much money was earned during a given day
     * @param date - is selected day
     * @return value of earned during a given day
     */
    public Double checkEarned(LocalDate date){
        try {
            return paymentRepository.findAllByDate(date);
        }catch (NullPointerException e){
            return null;
        }
    }

    /**
     * payment's counting how much money driver has to pay
     * @param driverId - driver's id
     * @return how much money driver has to pay
     */
    public Double payment(int driverId){
        try {
        Driver driver = driverService.findById(driverId);
            if (driver.getTypeOfDrivers().equals("Regular")) {
                double payment = payRegular(driver.getFullTime());
                return payment;
            } else  {
                double payment = payVip(driver.getFullTime());
                return payment;
            }
        }catch (NoSuchElementException e){
            return null;
        }

    }

}
