package com.codingtest.driverlesscar;

import com.codingtest.driverlesscar.impl.DriverlessCar;
import com.codingtest.driverlesscar.interfaces.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DriverlesscarApplicationTests {

    @Test
    public void contextLoads() {

    }

    @Test
    public void testDriverlessCarCommand1() {
        String command1 = "X:1,FACE:E,Y:1,FACE:S,X:-1,FACE:E,Y:-1";
        Car driverlessNo1 = new DriverlessCar("driverlessNo1", 1, 1, "N");
        driverlessNo1.move(command1);
    }

    @Test
    public void testDriverlessCarCommand2() {
        String command2 = "FACE:E,Y:1,FACE:N";
        Car driverlessNo2 = new DriverlessCar("driverlessNo2", 1, 1, "N");
        driverlessNo2.move(command2);
    }

    @Test
    public void testDriverlessCarCommand3() {
        String command3 = "FACE:N,X:1,FACE:E";
        Car driverlessNo3 = new DriverlessCar("driverlessNo3", 1, 1, "E");
        driverlessNo3.move(command3);
    }

    @Test
    public void testDriverlessCarCommand4() {
        String command4 = "Y:-1";
        Car driverlessNo4 = new DriverlessCar("driverlessNo4", 1, 1, "W");
        driverlessNo4.move(command4);
    }

    @Test
    public void testDriverlessCarCommand3And5() {
        String command5 = "FACE:N,X:2,FACE:E";
        Car driverlessNo5 = new DriverlessCar("driverlessNo5", 1, 1, "E");
        driverlessNo5.move(command5);
    }



}
