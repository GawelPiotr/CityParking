package com.parking.parking.Service;

import com.parking.parking.Model.Driver;
import com.parking.parking.Model.Payment;
import com.parking.parking.Repository.DriverRepository;
import com.parking.parking.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@Service
public class DriverService {
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private PaymentRepository paymentRepository;

    /**
     * addNewDriver's saving a new Driver to database
     * @param newDriver - object of new driver
     * @return drivers fields
     */
    public Driver addNewDriver(Driver newDriver){
        return driverRepository.save(newDriver);
    }


    /**
     * findById's finding drivers by drivers id
     * @param driverId - driver's id
     * @return drivers fields or null when there is no driver witch such this id
     */
    public Driver findById (Integer driverId){
        try {
            Driver driver = driverRepository.findById(driverId).get();
            return driver;
        }catch (NoSuchElementException e){
            return null;
        }
    }

    /**
     * startParking's saving actual time in database as starting time of parking
     * @param driverId - driver's id
     * @return actual time
     */
    public LocalDateTime startParking(int driverId){
        try {
            Driver driver = findById(driverId);
            LocalDateTime startTime = LocalDateTime.now();
            driver.setStartTime(startTime);
            System.out.println("Local Date and Time :" + startTime);
            driverRepository.save(driver);
            return startTime;
        } catch (NullPointerException e){
            return null;
        }

    }
    /**
     * finishParking's saving actual time in database as finish time of parking. Also is saving value of pay to database
     * @param driverId - driver's id
     * @return full time of parking car
     */
    public Double finishParking(int driverId){
        try {
            Driver driver = findById(driverId);
            LocalDateTime finishTime = LocalDateTime.now();
            driver.setFinishTime(finishTime);
            double fullTime = countTime(driver.getStartTime(), driver.getFinishTime());
            driver.setFullTime((long) fullTime);
            driverRepository.save(driver);
            double payment = paymentService.peyment(driverId);
            driver.setValueToPay(payment);
            driverRepository.save(driver);
            LocalDate date = finishTime.toLocalDate();
            Payment newPayment = new Payment();
            newPayment.setDate(date);
            newPayment.setValue(payment);
            paymentRepository.save(newPayment);
            return fullTime;
        }catch (NullPointerException e){
            return null;
        }
    }


    /**
     * countTime's counting time of parking car and saving as integer number of hours
     * @param startTime - time of starting parking
     * @param finishTime - time of ending parking
     * @return full time of parking as integer of hours
     */
    public double countTime(LocalDateTime startTime, LocalDateTime finishTime){

        Duration duration = Duration.between(startTime, finishTime);
        double seconds = duration.getSeconds();
        double changeToHour;
        if (seconds <= 3600) {
            changeToHour = 1.0;
            return changeToHour;
        } else {
            changeToHour = seconds / 3600.0;
            if (changeToHour%1!=0) {
                changeToHour = (int)changeToHour + 1.0;
                return changeToHour;
            } else {
                return changeToHour;
            }
        }
    }
}
