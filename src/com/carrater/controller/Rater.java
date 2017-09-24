package com.carrater.controller;

import com.carrater.vehicles.Vehicle;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Rater {

    private Map<Integer, Vehicle> vehicleMap;

    private Map<Integer, Vehicle> ratedVehicles = new HashMap<>();

    private Calendar calendar = Calendar.getInstance();
    private int thisYear = calendar.get(Calendar.YEAR);
    //private String thisYearString = String.valueOf(thisYear);


    public Rater(Map<Integer, Vehicle> vehicleLibrary) {

        this.vehicleMap = vehicleLibrary;
/*
        Map<Integer, Vehicle> ratedVehicles = rateVehicles(vehicleMap);

        for (Map.Entry<Integer, Vehicle> entry : ratedVehicles.entrySet()) {
            System.out.println("Rating: " + entry.getKey() + " " + entry.getValue());
        }
        */

    }

    //         Value,  Vehicle
    public Map<Integer, Vehicle> rateVehicles(Map<Integer, Vehicle> toRateVehicles) {
        //Map<Integer, Vehicle> ratedVehicles = new HashMap<>();

        Vehicle currentVehicle = null;

        for (Map.Entry<Integer, Vehicle> entry : toRateVehicles.entrySet()) {
            Integer value = 100;
            value -= calculateYearValue(entry.getValue().getYear());
            value -= calculatePriceValue(entry.getValue().getPrice());
            value -= calculateMileageValue(entry.getValue().getMiles());
            value -= calculateMPGValue(entry.getValue().getMpg());
            System.out.println("Car ID: " + entry.getValue().getID() + " Value: " + value);
            ratedVehicles.put(value, entry.getValue());

        }

        return ratedVehicles;
    }

    public int calculateYearValue(String year) {
        int intYear = Integer.parseInt(year);
        return thisYear - intYear;
    }

    public int calculatePriceValue(String price) {
        int intPrice = Integer.parseInt(price);
        return intPrice / 1000;
    }

    public int calculateMileageValue(String miles) {
        int intMiles = Integer.parseInt(miles);
        return intMiles / 10000;
    }

    public int calculateMPGValue(String mpg) {
        int intMPG = Integer.parseInt(mpg);
        return 30 - intMPG;
    }

    public void printRatedVehicles() {
        for (Map.Entry<Integer, Vehicle> entry : ratedVehicles.entrySet()) {
            System.out.println("Rating: " + entry.getKey() + " " + entry.getValue());
        }
    }

}
