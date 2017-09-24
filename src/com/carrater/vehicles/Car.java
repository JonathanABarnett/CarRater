package com.carrater.vehicles;

public class Car extends Vehicle {

    private String type;
    private String car = "CAR";

    public Car(String price, String make, String model, String year, String miles, String mpg, String distanceAway, String location, String type) {
        super(price, make, model, year, miles, mpg, distanceAway, location);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String getVehicleType() {
        return car;
    }

    @Override
    public String toString() {
        return "ID: " + getID() + " | Car | $" + getPrice() + ".00 | " + getMake() + " | " + getModel() + " | " + getYear() + " | " +
                getMiles() + " | MPG: " + getMpg() + " | " + getDistanceAway() + " | " + getLocation() +
                " | Type of Car: " + getType();
    }
}
