package com.parking.parking.Model;


import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "driver")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="driver_id")
    private Integer id;

    /**
     * @param fullTime - full time of parking [hours]
     */
    @Column(name = "full_time")
    private long fullTime;

    /**
     * @param startTime - date and time of starting parking
     */
    @Column(name = "start_time")
    private LocalDateTime startTime;

    /**
     * @param finishTime - date and time of finishing parking
     */
    @Column(name = "finish_time")
    private LocalDateTime finishTime;

    /**
     * @param registrationNumber - registration number of parking vehicle
     */
    @Column(name = "registration_number")
    private String registrationNumber;

    /**
     * @param valueToPay - value to pay after finishing parking [zł]
     */
    @Column(name = "value_to_pay")
    private double valueToPay;

    /**
     * @param typeOfDrivers - type of Drivers : Regular or Vip
     */
    @Column
    private String typeOfDrivers;

    public Driver(){}

    public Driver(Integer id, String registrationNumber, long fullTime){
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.fullTime= fullTime;
    }

    public Driver(Integer id, long fullTime, String typeOfDrivers){
        this.id = id;
        this.fullTime = fullTime;
        this.typeOfDrivers = typeOfDrivers;
    }


    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeOfDrivers() {
        return typeOfDrivers;
    }

    public void setTypeOfDrivers(String typeOfDrivers) {
        this.typeOfDrivers = typeOfDrivers;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public long getFullTime() {
        return fullTime;
    }

    public void setFullTime(long fullTime) {
        this.fullTime = fullTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(LocalDateTime finishTime) {
        this.finishTime = finishTime;
    }

    public double getValueTopay() {
        return valueToPay;
    }

    public void setValueToPay(double valueToPay) {
        this.valueToPay = valueToPay;
    }
}
