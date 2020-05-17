//package com.example.demo;
//
//import com.example.demo.entity.Baggage;
//import com.example.demo.exception.ExceptionTwo;
//import com.example.demo.service.CalFreeBaggageMax;
//import org.omg.CORBA.ExceptionList;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.Map;
//
//public class testCase {
//
//
//
//
//
//
//    class Passenger1{
//        String region;
//        String passengerType;
//        String passengerLevel;
//        String cabin;
//        ArrayList<Baggage> baggages = new ArrayList<>();
//        void addBaggage(Baggage baggage){
//            baggages.add(baggage);
//        }
//    }
//
//    @DataProvider(name="test2")
//    public Iterator<Object[]> Numbers() throws IOException {
//        return (Iterator<Object[]>)new CSVData("data1.csv");
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        if (ExceptionList.size()==0){
//            System.out.println("该乘客的行李可以免费托运");
//        }else {
//            for (ExceptionTwo e:ExceptionList){
//                System.out.println(e.getDesc()+",数量超出"+e.getNum_excess()+
//                        ",尺寸超出"+e.getSieze_excess()+",重量超出"+e.getWeight_excess());
//            }
//        }
//    }
//    @Test(dataProvider = "test2")
//    public void testCheck1(Map<String,String> map) {
//        Passenger1 passenger1=new Passenger1();
//        passenger1.region="AreaZero";
//        passenger1.passengerType=map.get("PassengerType");
//        passenger1.passengerLevel=map.get("PassengerLevel");
//        passenger1.cabin=map.get("Cabin");
//        passenger1.addBaggage(new Baggage(Double.valueOf(map.get("weight")),Double.valueOf(map.get("length")),Double.valueOf(map.get("width")),Double.valueOf(map.get("height"))));
//        ExceptionList = CalFreeBaggageMax.Check(
//                passenger1.baggages,
//                passenger1.region,
//                passenger1.passengerType,
//                passenger1.passengerLevel,
//                passenger1.cabin);
//    }
//
//}
//
//@DataProvider(name = "test1")
//public Object[][]getPassenger(){
//        Passenger passenger = new Passenger();
//        passenger.region="AreaZero";
//        passenger.passengerType ="TypeOne";
//        passenger.passengerLevel ="Normal";
//        passenger.cabin ="EconomyClass";
//        passenger.addBaggage(new Baggage(40,100,60,40));
//
//        Passenger passenger1 = new Passenger();
//        passenger1.region="AreaZero";
//        passenger1.passengerType ="TypeOne";
//        passenger1.passengerLevel ="Normal";
//        passenger1.cabin ="EconomyClass";
//        passenger1.addBaggage(new Baggage(40,100,80,40));
//
//        Passenger passenger2 = new Passenger();
//        passenger2.region="AreaZero";
//        passenger2.passengerType ="TypeOne";
//        passenger2.passengerLevel ="Normal";
//        passenger2.cabin ="EconomyClass";
//        passenger2.addBaggage(new Baggage(23,100,80,40));
//
//        Passenger passenger3 = new Passenger();
//        passenger3.region="AreaZero";
//        passenger3.passengerType ="TypeOne";
//        passenger3.passengerLevel ="Normal";
//        passenger3.cabin ="EconomyClass";
//        passenger3.addBaggage(new Baggage(23,100,50,30));
//
//        Passenger passenger4 = new Passenger();
//        passenger4.region="AreaZero";
//        passenger4.passengerType ="TypeTwo";
//        passenger4.passengerLevel ="Normal";
//        passenger4.cabin ="EconomyClass";
//        passenger4.addBaggage(new Baggage(23,100,60,30));
//
//        Passenger passenger5 = new Passenger();
//        passenger5.region="AreaZero";
//        passenger5.passengerType ="TypeOne";
//        passenger5.passengerLevel ="F";
//        passenger5.cabin ="FirstClass";
//        passenger5.addBaggage(new Baggage(40,100,60,30));
//
//        Passenger passenger6 = new Passenger();
//        passenger6.region="AreaZero";
//        passenger6.passengerType ="TypeOne";
//        passenger6.passengerLevel ="classOne";
//        passenger6.cabin ="FirstClass";
//        passenger6.addBaggage(new Baggage(70,100,60,30));
//
//        Passenger passenger7 = new Passenger();
//        passenger7.region="AreaZero";
//        passenger7.passengerType ="TypeOne";
//        passenger7.passengerLevel ="classTwo";
//        passenger7.cabin ="BusinessClass";
//        passenger7.addBaggage(new Baggage(70,100,60,30));
//
//        Passenger passenger8 = new Passenger();
//        passenger8.region="AreaZero";
//        passenger8.passengerType ="TypeOne";
//        passenger8.passengerLevel ="classOne";
//        passenger8.cabin ="FirstClass";
//        passenger8.addBaggage(new Baggage(95,100,60,30));
//
//        Passenger passenger9 = new Passenger();
//        passenger9.region="AreaZero";
//        passenger9.passengerType ="TypeOne";
//        passenger9.passengerLevel ="classThree";
//        passenger9.cabin ="EconomyClass";
//        passenger9.addBaggage(new Baggage(55,100,60,30));
//
//        Passenger passenger10 = new Passenger();
//        passenger10.region="AreaZero";
//        passenger10.passengerType ="TypeOne";
//        passenger10.passengerLevel ="classThree";
//        passenger10.cabin ="EconomyClass";
//        passenger10.addBaggage(new Baggage(40,100,60,30));
//
//        return new Object[][]{{passenger},{passenger1},{passenger2},{passenger3},{passenger4},
//        {passenger5},{passenger6},{passenger7},{passenger8},{passenger9},{passenger10}};
//        }
//
//
//
//@AfterMethod
//public void tearDown() {
//        if (ExceptionList.size()==0){
//        System.out.println("该乘客的行李可以免费托运");
//        }else {
//        for (ExceptionTwo e:ExceptionList){
//        System.out.println(e.getDesc()+",数量超出"+e.getNum_excess()+
//        ",尺寸超出"+e.getSieze_excess()+",重量超出"+e.getWeight_excess());
//        }
//        }
//        }
