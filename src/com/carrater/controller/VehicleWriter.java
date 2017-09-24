package com.carrater.controller;

import com.carrater.vehicles.Vehicle;
import org.apache.commons.io.FileUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VehicleWriter {

    private String splitBy = ",";
    private String fileName = "src\\com\\carrater\\data\\vehicles.txt";
    private Map<Integer, Vehicle> vehicleMap;

    public VehicleWriter(Map<Integer, Vehicle> vehicleMaps) {

        this.vehicleMap = vehicleMaps;

    }

    public VehicleWriter() {};

    public void writeVehicles() {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {

            for (Map.Entry<Integer, Vehicle> entry : vehicleMap.entrySet()) {
                if (entry.getValue().getVehicleType().toLowerCase().equals("truck")) {
                    bufferedWriter.write (entry.getValue().getVehicleType() + splitBy + entry.getValue().getPrice() + splitBy +
                            entry.getValue().getMake() + splitBy + entry.getValue().getMake() + splitBy + entry.getValue().getYear() + splitBy +
                            entry.getValue().getMiles() + splitBy + entry.getValue().getMpg() + splitBy + entry.getValue().getDistanceAway() + splitBy +
                            entry.getValue().getLocation() + splitBy + "yes" + splitBy + "4\n");
                } else {
                    bufferedWriter.write (entry.getValue().getVehicleType() + splitBy + entry.getValue().getPrice() + splitBy +
                            entry.getValue().getMake() + splitBy + entry.getValue().getMake() + splitBy + entry.getValue().getYear() + splitBy +
                            entry.getValue().getMiles() + splitBy + entry.getValue().getMpg() + splitBy + entry.getValue().getDistanceAway() + splitBy +
                            entry.getValue().getLocation() + splitBy + "Sedan\n");
                }
                System.out.println("Vehicles saved.");
            }

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

}
