package com.carrater.controller;

import com.carrater.vehicles.Car;
import com.carrater.vehicles.Truck;
import com.carrater.vehicles.Vehicle;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class VehicleReader {

    private String filePath = "";
    private List<Vehicle> vehicleList = new ArrayList<>();
    private Map<Integer, Vehicle> vehicleMap = new HashMap<>();
    private UI ui = new UI();


    public VehicleReader(String filePath) {
        this.filePath = filePath;
    }

    public Map<Integer, Vehicle> readContents() {

        String line;
        String splitBy = ",";

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(this.filePath))) {

            while ((line = bufferedReader.readLine()) != null ) {
                String[] readInVehicle = line.split(splitBy);

                if ("truck".equals(readInVehicle[0].toLowerCase())) {
                    Vehicle truck = new Truck(readInVehicle[1], readInVehicle[2], readInVehicle[3], readInVehicle[4],
                    readInVehicle[5], readInVehicle[6], readInVehicle[7], readInVehicle[8], ui.yesNo(readInVehicle[9]), readInVehicle[10]);
                    vehicleList.add(truck);
                } else if ("car".equals(readInVehicle[0].toLowerCase())) {
                    Vehicle car = new Car(readInVehicle[1], readInVehicle[2], readInVehicle[3], readInVehicle[4],
                            readInVehicle[5], readInVehicle[6], readInVehicle[7], readInVehicle[8], readInVehicle[9]);
                    vehicleList.add(car);
                } else {
                    System.out.println("You have not specified a car or truck. Please check your file.");
                    break;
                }

            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        System.out.println("Read vehicles successfully.");

        for (Vehicle vehicle : vehicleList) {
            vehicleMap.put(vehicle.getID(), vehicle);
            System.out.println(vehicle);
        }
        return vehicleMap;
    }

}
