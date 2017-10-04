package com.carrater.vehicles;

/**
 * Truck based off of the vehicle class.
 */

public class Truck extends Vehicle {

    private boolean fwd;
    private String doors;
    private String truck = "TRUCK";

    public Truck(String price, String make, String model, String year, String miles, String mpg, String distanceAway, String location, boolean fwd, String doors) {
        super(price, make, model, year, miles, mpg, distanceAway, location);
        this.fwd = fwd;
        this.doors = doors;
    }

    public boolean getFwd() {
        return fwd;
    }

    public String getDoors() {
        return doors;
    }

    @Override
    public String getVehicleType() {
        return truck;
    }

    public void setFwd(boolean fwd) {
        this.fwd = fwd;
    }

    public void setDoors(String doors) {
        this.doors = doors;
    }

    @Override
    public String toString() {
        return "ID: " + getID() + " | Truck | $" + getPrice() + ".00 | " + getMake() + " | " + getModel() + " | " + getYear() + " | " +
                getMiles() + " | MPG: " + getMpg() + " | " + getDistanceAway() + " | " + getLocation() +
                " | Number of Doors: " + getDoors() + " | 4WD: " + getFwd();
    }

}
