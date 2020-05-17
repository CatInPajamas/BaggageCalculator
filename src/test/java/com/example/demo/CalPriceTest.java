package com.example.demo;

import com.example.demo.entity.*;
import com.example.demo.service.CalPrice;
import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;
import org.testng.annotations.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CalPriceTest {
    class Passenger{
        String region;
        String passengerType;
        String passengerLevel;
        String cabin;
        ArrayList<Baggage> baggages = new ArrayList<>();
        void addBaggage(Baggage baggage){
            baggages.add(baggage);
        }
        double ticketPrice;
    }
    private double price = 0;
    @DataProvider(name = "test1")
    public Iterator<Object[]> Numbers() throws IOException{
        return (Iterator<Object[]>)new CSVData("data.csv");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("额外价格："+price);
    }
    @Test(dataProvider = "test1")
    public void testCheck(Map<String,String> map){
        Passenger passenger=new Passenger();
        passenger.region=map.get("Region");
        passenger.passengerType="TypeOne";
        passenger.passengerLevel="Normal";
        passenger.cabin=map.get("Cabin");
        passenger.addBaggage(new Baggage(Double.valueOf(map.get("weight")),Double.valueOf(map.get("length")),Double.valueOf(map.get("width")),Double.valueOf(map.get("height"))));
        //System.out.println(passenger.region+passenger.passengerType+passenger.passengerLevel+passenger.cabin);
        price=CalPrice.getPrice(passenger.baggages,passenger.region,passenger.passengerType,passenger.passengerLevel,passenger.cabin,1000.0);
    }


}
