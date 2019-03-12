package com.parking.parking.Service;

import com.parking.parking.Model.Driver;
import com.parking.parking.Repository.DriverRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class PaymentServiceTest {


    @Mock
    DriverRepository driverRepository;

    @InjectMocks
    DriverService driverService;

    @Mock
    PaymentService paymentService;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldReturnValueToPayAsRegularDriver() {
        //given
        double expected = 6.75 ;
        //when
        PaymentService paymentService = new PaymentService();
        double assertPay = paymentService.payRegular(5);
        //then
        assertEquals(assertPay,expected,0.0);
    }

    @Test
    public void shouldReturnValueToPayAsVipDriver() {
        //given
        double expected = 3.46;
        //when
        PaymentService paymentService = new PaymentService();
        double assertPay = paymentService.payVip(5);
        //then
        assertEquals(assertPay, expected, 0.0);
    }

    @Test
    public void checkErned() {
    }

    @Test
    public void payment() throws ParseException {
        when(driverRepository.findById(1)).thenReturn(java.util.Optional.of(new Driver(1, 4, "Regular")));
        Double paymentTest = paymentService.payment(1);
        double expected = 4.5;

        assertEquals(4.5, paymentTest, 0.0);

    }




    private Driver createNewDriver() throws ParseException {
        Driver driver = new Driver();
        driver.setFullTime(5);
        driver.setTypeOfDrivers("Vip");
//        DateTimeFormatter simpleFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//
//        LocalDateTime dateTime = LocalDateTime.parse("2019-03-09 12:21:28",simpleFormat);
//        LocalDateTime dateTimeSecound = LocalDateTime.parse("2019-03-09 14:21:28",simpleFormat);
//        driver.setStartTime(dateTime);
//        driver.setFinishTime(dateTimeSecound);
        return driver;

    }
}