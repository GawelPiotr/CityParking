//package com.parking.parking.Service;
//
//import com.parking.parking.Model.Driver;
//import com.parking.parking.Repository.DriverRepository;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//
//import java.text.ParseException;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.Optional;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.core.IsNull.notNullValue;
//import static org.junit.Assert.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//public class DriverServiceTest {
//    @Mock
//    DriverRepository driverRepository;
//
//    @InjectMocks
//    DriverService driverService;
//
//    @Before
//    public void setUp() throws Exception {
//
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void addNewDriver() {
//        when(driverRepository.save(any(Driver.class))).thenReturn(new Driver());
//        Driver driver = new Driver();
//        assertThat(driverService.addNewDriver(driver), is(notNullValue()));
//    }
//
//    @Test
//    public void findById() throws ParseException {
//        Mockito.when(driverRepository.findById(1).get()).thenReturn(createNewDriver());
//        Driver driver = driverService.findById(1);
//
//        Assert.assertEquals(5, driver.getFullTime());
//        Mockito.verify(driverRepository).findById(1);
//
//    }
//
//
//
//
//    private Driver createNewDriver() throws ParseException {
//        Driver driver = new Driver();
//        driver.setId(1);
//        driver.setFullTime(5);
//        driver.setTypeOfDrivers("Vip");
////        DateTimeFormatter simpleFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
////
////        LocalDateTime dateTime = LocalDateTime.parse("2019-03-09 12:21:28",simpleFormat);
////        LocalDateTime dateTimeSecound = LocalDateTime.parse("2019-03-09 14:21:28",simpleFormat);
////        driver.setStartTime(dateTime);
////        driver.setFinishTime(dateTimeSecound);
//        return driver;
//    }
//
//    @Test
//    public void startParking() {
//    }
//
//    @Test
//    public void finishParking() {
//    }
//
//    @Test
//    public void countTime() {
//        DriverService driverService = new DriverService();
//        DateTimeFormatter simpleFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        LocalDateTime startingTime = LocalDateTime.parse("2019-03-09 12:21:28",simpleFormat);
//        LocalDateTime finishTime = LocalDateTime.parse("2019-03-09 14:22:28",simpleFormat);
//        double countTime = driverService.countTime(startingTime, finishTime);
//        double actual = 3;
//
//        assertEquals(countTime, actual, 0.0);
//
//    }
//}