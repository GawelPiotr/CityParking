package com.parking.parking.Service;

import com.parking.parking.Model.Driver;
import com.parking.parking.Repository.DriverRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class DriverServiceTest {
    @Mock
    DriverRepository driverRepository;

    @InjectMocks
    DriverService driverService;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldCreateNewDriver() {
        //when
        when(driverRepository.save(any(Driver.class))).thenReturn(new Driver());
        Driver driver = new Driver();
        //then
        assertThat(driverService.addNewDriver(driver), is(notNullValue()));
    }

    @Test
    public void shouldFindDriversById() throws ParseException {
        //given
        int expected = 3;
        //when
        when(driverRepository.findById(1)).thenReturn(Optional.of(new Driver(1, "drftrf", 3)));
        Driver driver = driverService.findById(1);
        //then
        assertEquals(expected, driver.getFullTime(),0.0);
    }


//    private Driver createNewDriver() throws ParseException {
//        Driver driver = new Driver();
//        driver.setId(1);
//        driver.setFullTime(5);
//        driver.setTypeOfDrivers("Vip");
//        DateTimeFormatter simpleFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//
//        LocalDateTime dateTime = LocalDateTime.parse("2019-03-09 12:21:28",simpleFormat);
//        LocalDateTime dateTimeSecound = LocalDateTime.parse("2019-03-09 14:21:28",simpleFormat);
//        driver.setStartTime(dateTime);
//        driver.setFinishTime(dateTimeSecound);
//        return driver;
//    }


    @Test
    public void shouldCountFullTimeOfParking() {
        //given
        DateTimeFormatter simpleFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime startingTime = LocalDateTime.parse("2019-03-09 12:21:28",simpleFormat);
        LocalDateTime finishTime = LocalDateTime.parse("2019-03-09 14:22:28",simpleFormat);
        double expected = 3;
        //when
        double countTime = driverService.countTime(startingTime, finishTime);
        //then
        assertEquals(expected, countTime, 0.0);

    }
}