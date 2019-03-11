//package com.parking.parking.Service;
//
//import com.parking.parking.Model.Driver;
//import com.parking.parking.Repository.DriverRepository;
//import org.junit.Test;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//
//import java.text.DecimalFormat;
//import java.text.ParseException;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//
//import static org.junit.Assert.*;
//
//public class PaymentServiceTest {
//
//
//    @Mock
//    DriverService driverService;
//
//    @Test
//    public void payRegular() {
//
//        PaymentService paymentService = new PaymentService();
//        double assertPay = paymentService.payRegular(5);
//        double expected =6.75 ;
//        assertEquals(assertPay,expected,0.0);
//    }
//
//    @Test
//    public void payVip() {
//
//        PaymentService paymentService = new PaymentService();
//        double assertPay = paymentService.payVip(5);
//        double expected = 3.46;
//        assertEquals(assertPay, expected, 0.0);
//    }
//
//    @Test
//    public void checkErned() {
//    }
//
//    @Test
//    public void peyment() throws ParseException {
//        PaymentService paymentService = new PaymentService();
////        DriverService driverService = new DriverService();
//        Mockito.when(driverService.findById(1)).thenReturn(createNewDriver());
//        Driver testDriver = driverService.findById(1);
//        double assertCount = paymentService.peyment(1);
//        double expected = 6.75;
//
//        assertEquals(assertCount, expected, 0.0);
//
//    }
//
//
//
//
//    private Driver createNewDriver() throws ParseException {
//        Driver driver = new Driver();
//        driver.setFullTime(5);
//        driver.setTypeOfDrivers("Vip");
////        DateTimeFormatter simpleFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
////
////        LocalDateTime dateTime = LocalDateTime.parse("2019-03-09 12:21:28",simpleFormat);
////        LocalDateTime dateTimeSecound = LocalDateTime.parse("2019-03-09 14:21:28",simpleFormat);
////        driver.setStartTime(dateTime);
////        driver.setFinishTime(dateTimeSecound);
//        return driver;
//
//    }
//}