package com.carrater.vehicles;

/**
 * Vehicle abstract class is the basic template that each vehicle must have in order to be critiqued
 */
public abstract class Vehicle {

    private static int counter = 1;
    private int id;

    private String price;
    private String make;
    private String model;
    private String year;
    private String miles;
    private String mpg;
    private String distanceAway;
    private String location;

    public Vehicle (String price, String make, String model, String year, String miles, String mpg, String distanceAway, String location) {
        this.price = price;
        this.make = make;
        this.model = model;
        this.mpg = mpg;
        this.year = year;
        this.miles = miles;
        this.distanceAway = distanceAway;
        this.location = location;
        id = counter++;
    }

    public int getID() {
        return id;
    }

    public String getPrice() {
        return price;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    public String getMiles() {
        return miles;
    }

    public String getMpg() {
        return mpg;
    }

    public String getDistanceAway() {
        return distanceAway;
    }

    public String getLocation() {
        return location;
    }

    public abstract String getVehicleType();

    public void setPrice(String price) {
        this.price = price;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setMiles(String miles) {
        this.miles = miles;
    }

    public void setMpg(String mpg) {
        this.mpg = mpg;
    }

    public void setDistanceAway(String distanceAway) {
        this.distanceAway = distanceAway;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
