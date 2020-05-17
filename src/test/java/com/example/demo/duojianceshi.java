package com.example.demo;

import com.example.demo.entity.Baggage;
import com.example.demo.service.CalPrice;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class duojianceshi {
    class Passenger{
        String region;
        String passengerType;
        String passengerLevel;
        String cabin;
        ArrayList<Baggage> baggages = new ArrayList<>();
        void addBaggage(Baggage baggage){
            baggages.add(baggage);
        }

    }
    @DataProvider(name = "test1")
    public Object[][]getPassenger() {
        Passenger passenger = new Passenger();
        passenger.passengerType = "TypeOne";
        passenger.passengerLevel = "Normal";
        passenger.region = "AreaFive";
        passenger.cabin = "SuperEconomyClass";
        passenger.addBaggage(new Baggage(22, 30, 50, 40));
        passenger.addBaggage(new Baggage(15, 50, 50, 60));
        passenger.addBaggage(new Baggage(22, 70, 50, 40));
        passenger.addBaggage(new Baggage(23, 50, 50, 50));
        passenger.addBaggage(new Baggage(18, 70, 50, 40));
        passenger.addBaggage(new Baggage(20, 40, 30, 40));

        Passenger passenger1 = new Passenger();
        passenger1.passengerType = "TypeOne";
        passenger1.passengerLevel = "classThree";
        passenger1.region = "AreaFour";
        passenger1.cabin = "SuperEconomyClass";
        passenger1.addBaggage(new Baggage(24, 30, 50, 40));
        passenger1.addBaggage(new Baggage(31, 50, 50, 40));
        passenger1.addBaggage(new Baggage(22, 50, 50, 40));
        passenger1.addBaggage(new Baggage(27, 50, 50, 50));
        passenger1.addBaggage(new Baggage(18, 30, 50, 40));
        passenger1.addBaggage(new Baggage(25, 40, 30, 40));


        Passenger passenger2 = new Passenger();
        passenger2.passengerType = "TypeOne";
        passenger2.passengerLevel = "classThree";
        passenger2.region = "AreaThree";
        passenger2.cabin = "BusinessClass";
        passenger2.addBaggage(new Baggage(24, 30, 50, 40));
        passenger2.addBaggage(new Baggage(31, 50, 50, 40));
        passenger2.addBaggage(new Baggage(22, 50, 50, 40));
        passenger2.addBaggage(new Baggage(27, 50, 50, 50));
        passenger2.addBaggage(new Baggage(18, 30, 50, 40));
        passenger2.addBaggage(new Baggage(25, 40, 30, 40));

        Passenger passenger3 = new Passenger();
        passenger3.passengerType = "TypeOne";
        passenger3.passengerLevel = "classOne";
        passenger3.region = "AreaThree";
        passenger3.cabin = "FirstClass";
        passenger3.addBaggage(new Baggage(24, 60, 50, 50));
        passenger3.addBaggage(new Baggage(26, 50, 50, 50));
        passenger3.addBaggage(new Baggage(30, 50, 50, 40));
        passenger3.addBaggage(new Baggage(27, 50, 50, 50));

        Passenger passenger4 = new Passenger();
        passenger4.passengerType = "TypeOne";
        passenger4.passengerLevel = "classOne";
        passenger4.region = "AreaTwo";
        passenger4.cabin = "FirstClass";
        passenger4.addBaggage(new Baggage(24, 30, 50, 40));
        passenger4.addBaggage(new Baggage(31, 50, 50, 40));
        passenger4.addBaggage(new Baggage(22, 50, 50, 40));
        passenger4.addBaggage(new Baggage(27, 50, 50, 50));
        passenger4.addBaggage(new Baggage(18, 30, 50, 40));
        passenger4.addBaggage(new Baggage(25, 40, 30, 40));

        Passenger passenger5 = new Passenger();
        passenger5.passengerType = "TypeOne";
        passenger5.passengerLevel = "classThree";
        passenger5.region = "AreaOne";
        passenger5.cabin = "FirstClass";
        passenger5.addBaggage(new Baggage(24, 30, 50, 40));
        passenger5.addBaggage(new Baggage(31, 50, 50, 40));
        passenger5.addBaggage(new Baggage(22, 50, 50, 40));
        passenger5.addBaggage(new Baggage(27, 50, 50, 50));
        passenger5.addBaggage(new Baggage(32, 30, 50, 40));

        return new Object[][]{{passenger},{passenger1},{passenger2},{passenger3},{passenger4},{passenger5}};

    }
    private double price=0;

    @AfterMethod
    public void tearDown(){
        System.out.println("额外价格："+price);
    }
    @Test(dataProvider = "test1")
    public void testCheck(Passenger passenger){
        price = CalPrice.getPrice(
                passenger.baggages,
                passenger.region,
                passenger.passengerType,
                passenger.passengerLevel,
                passenger.cabin,
                1000.0);
    }
}
