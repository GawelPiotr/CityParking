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

    @Column(name = "full_time")
    private long fullTime;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "finish_time")
    private LocalDateTime finishTime;

    @Column(name = "registration_number")
    private String registrationNumber;

    @Column(name = "value_to_pay")
    private double valueToPay;

    @Column
    private String typeOfDrivers;

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
