package com.example.demo;

import com.example.demo.entity.*;
import com.example.demo.exception.ExceptionTwo;
import com.example.demo.service.CalFreeBaggageMax;
import com.example.demo.service.CalPrice;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class CalFreeBaggageMaxTest {
    private ArrayList<ExceptionTwo> ExceptionList;

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

    @DataProvider(name="test2")
    public Iterator<Object[]> Numbers() throws IOException {
        return (Iterator<Object[]>)new CSVData("data1.csv");
    }

    @AfterMethod
    public void tearDown() {
        if (ExceptionList.size()==0){
            System.out.println("该乘客的行李可以免费托运");
        }else {
            for (ExceptionTwo e:ExceptionList){
                System.out.println(e.getDesc()+",数量超出"+e.getNum_excess()+
                        ",尺寸超出"+e.getSieze_excess()+",重量超出"+e.getWeight_excess());
            }
        }
    }
    @Test(dataProvider = "test2")
    public void testCheck1(Map<String,String> map) {
        Passenger passenger=new Passenger();
        passenger.region=map.get("Region");
        passenger.passengerType=map.get("PassengerType");
        passenger.passengerLevel=map.get("PassengerLevel");
        passenger.cabin=map.get("Cabin");
        passenger.addBaggage(new Baggage(Double.valueOf(map.get("weight")),Double.valueOf(map.get("length")),Double.valueOf(map.get("width")),Double.valueOf(map.get("height"))));
        ExceptionList = CalFreeBaggageMax.Check(
                passenger.baggages,
                passenger.region,
                passenger.passengerType,
                passenger.passengerLevel,
                passenger.cabin);
    }


}
