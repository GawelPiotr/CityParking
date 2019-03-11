package com.parking.parking.Repository;

import com.parking.parking.Model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    @Query(value = "SELECT SUM(payment.value) FROM Payment payment WHERE payment.date = ?1 ")
    Double findAllByDate(LocalDate date);
}