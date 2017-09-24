package com.carrater.controller;

import com.carrater.controller.Rater;
import com.carrater.vehicles.Car;
import com.carrater.vehicles.Truck;
import com.carrater.vehicles.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Vehicle User Interface
 */
public class UI {

    private Scanner reader = new Scanner(System.in);
    private Map<Integer, Vehicle> vehicleLibrary = new HashMap<>();
    //private Vehicle vehicle;

    private String userInput;
    private final String breaker = "**********************";
    private final String dots = "...";
    private final String addVehicle = "ADD";
    private final String listVehicles = "LIST";
    private final String removeVehicle = "REMOVE";
    private final String editVehicle = "EDIT";
    private final String rateVehicles = "RATE";
    private final String importVehicles = "IMPORT";
    private final String saveVehicles = "SAVE";
    private final String quit = "QUIT";
    private final String main = "MAIN";
    private final String car = "CAR";
    private final String truck = "TRUCK";
    private final String yes = "YES";
    private final String no = "NO";

    // private final String editId = "ID";
    private final String editPrice = "1";
    private final String editMake = "2";
    private final String editModel = "3";
    private final String editYear = "4";
    private final String editMileage = "5";
    private final String editDistanceAway = "6";
    private final String editLocation = "7";
    private final String editNumberOfDoors = "8";
    private final String edit4WD = "9";
    private final String editType = "10";

    private boolean cont = false;

    private String price = "0";
    private String make = "";
    private String model = "";
    private String year = "2017";
    private String miles = "0";
    private String mpg = "0";
    private String distanceAway = "0";
    private String location = "";
    private boolean fwd = false;
    private String doors = "2";
    private String type = "";


    public void begin() {
        System.out.println("Welcome to the Vehicle Rating Program!\nWe're very glad you have decided to try out our " +
                "rating program and hope it serves you well in finding a new car.\n" +
                "Please follow the prompts to ensure a positive experience.\n");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        prompt();
    }

    public void prompt() {
        while (!cont) {
            System.out.println("\n" + breaker);
            System.out.println("Please select from the following prompts to continue... \n");
            System.out.println(addVehicle + dots + "to add a new vehicle.");
            System.out.println(removeVehicle + dots + "to remove a vehicle.");
            System.out.println(editVehicle + dots + "to edit one of your vehicles.");
            System.out.println(importVehicles + dots + "to import a CSV of cars.");
            System.out.println(listVehicles + dots + "to list the vehicles you have added.");
            System.out.println(rateVehicles + dots + "to rate the vehicles you have added.");
            System.out.println(saveVehicles + dots + "to save your list of vehicles.");
            System.out.println(quit + dots + "to exit the program.");
            System.out.println(breaker + "\n");
            getInput();
        }
    }

    public void getInput() {
        userInput = reader.nextLine();
        userInput = userInput.toUpperCase().trim();
        cont = true;
        if (addVehicle.equals(userInput)) {
            add();
        } else if (listVehicles.equals(userInput)) {
            listVehicles();
        } else if (editVehicle.equals(userInput)) {
            edit();
        } else if (removeVehicle.equals(userInput)) {
            remove();
        } else if (rateVehicles.equals(userInput)) {
            rate();
        } else if (importVehicles.equals(userInput)) {
            importVehicles();
        } else if (saveVehicles.equals(userInput)) {
            saveVehicles();
        }else if (quit.equals(userInput)) {
            quitProgram();
        } else {
            cont = false;
            prompt();
        }
    }

    public void add() {
        System.out.println("\nLet's go ahead and add a vehicle.\nWould you like to add a new car or truck?\n");
        userInput = reader.nextLine();
        userInput = userInput.toUpperCase().trim();
        if (car.equals(userInput)) {
            newCar();
        } else if (truck.equals(userInput)) {
            newTruck();
        } else if (main.equals(userInput)) {
            cont = false;
            prompt();
        } else {
            System.out.println("Sorry, I didn't catch that.");
            add();
        }
    }

    public void newCar() {
        Vehicle vehicle;
        System.out.println("\nLet's add a new car.\n");
        System.out.println("What is the price of the car to the nearest dollar?");
        price = reader.nextLine();
        System.out.println("What is the make of the car? i.e. Ford, Toyota, Honda, etc.");
        make = reader.nextLine();
        System.out.println("What is the model of the car? i.e. Escape, Corolla, Civic etc.");
        model = reader.nextLine();
        System.out.println("What is the type of the car? i.e. Sedan, Hatchback, Convertible etc.");
        type = reader.nextLine();
        System.out.println("What is the year of the car?");
        year = reader.nextLine();
        System.out.println("How many miles does the car have?");
        miles = reader.nextLine();
        System.out.println("What is the average MPG of the car? Hwy and Cty combined.");
        mpg = reader.nextLine();
        System.out.println("How far away is the car located? (in miles)");
        distanceAway = reader.nextLine();
        System.out.println("Where is the car located at?");
        location = reader.nextLine();

        vehicle = new Car(price, make, model, year, miles, mpg, distanceAway, location, type);
        vehicleLibrary.put(vehicle.getID(), vehicle);

        cont = false;
        prompt();
    }

    public void newTruck() {
        Vehicle vehicle;
        System.out.println("\nLet's add a new truck.\n");
        System.out.println("What is the price of the truck to the nearest dollar?");
        price = reader.nextLine();

        System.out.println("What is the make of the truck? i.e. Ford, Toyota, Dodge, etc.");
        make = reader.nextLine();
        System.out.println("What is the model of the truck? i.e. F-150, Tundra, Ram etc.");
        model = reader.nextLine();
        System.out.println("What is the year of the truck?");
        year = reader.nextLine();
        System.out.println("How many miles does the truck have?");
        miles = reader.nextLine();
        System.out.println("What is the average MPG of the truck? Hwy and Cty combined.");
        mpg = reader.nextLine();
        System.out.println("Does the truck have 4WD?");
        userInput = reader.nextLine();
        fwd = yesNo(userInput);
        System.out.println("How many doors does the truck have?");
        doors = reader.nextLine();
        System.out.println("How far away is the truck located? (in miles)");
        distanceAway = reader.nextLine();
        System.out.println("Where is the truck located at?");
        location = reader.nextLine();

        vehicle = new Truck(price, make, model, year, miles, mpg, distanceAway, location, fwd, doors);
        vehicleLibrary.put(vehicle.getID(), vehicle);
/*
Not needed right now.
        System.out.println("Does this look correct?");
        System.out.println(truck);
        userInput = reader.nextLine();
        userInput = userInput.toLowerCase().trim();
        if ("yes".equals(userInput) || "y".equals(userInput)) {
            vehicleLibrary.put(vehicle.getID(), vehicle);
        } else {
            edit(vehicle);
        }
   */
        cont = false;
        prompt();
    }

    public boolean yesNo(String answer) {
        answer.toLowerCase().trim();
        if ("yes".equals(answer) || "y".equals(answer)) {
            return true;
        } else {
            return false;
        }
    }

    public void edit() {
        if (!vehicleLibrary.isEmpty()) {
            Vehicle toEditVehicle = null;
            System.out.println("Do you know the ID of the vehicle you would like to edit?");
            userInput = reader.nextLine();
            userInput = userInput.toLowerCase().trim();
            if (yesNo(userInput)) {
                System.out.println("What is the ID?");
                Integer getId = Integer.parseInt(reader.nextLine());
                for (Integer key : this.vehicleLibrary.keySet()) {
                    if (key.equals(getId)) {
                        toEditVehicle = vehicleLibrary.get(key);
                        System.out.println(toEditVehicle);
                    }
                }
            } else {
                listVehicles();
                edit();
            }
            toEdit(toEditVehicle);
        } else {
            System.out.println("You do not have any vehicles to edit.");
            cont = false;
            prompt();
        }
    }

    public void listVehicles() {
        if (vehicleLibrary.isEmpty()) {
            System.out.println("You have not added any vehicles yet.\n");
        } else {
            for (Map.Entry<Integer, Vehicle> entry : vehicleLibrary.entrySet()) {
                System.out.println(entry.getValue());
            }
        }
        cont = false;
        prompt();
        //wouldYouLikeToContinue();
    }

    public void toEdit(Vehicle vehicleToEdit) {
        Vehicle vehicleEdit = vehicleToEdit;
        System.out.println("What would you like to edit?");
        System.out.println(editPrice + dots + "to edit the price.");
        System.out.println(editMake + dots + "to edit the make.");
        System.out.println(editModel + dots + "to edit the model.");
        System.out.println(editYear + dots + "to edit the year.");
        System.out.println(editMileage + dots + "to edit the distance away.");
        System.out.println(editLocation + dots + "to edit the location.");
        System.out.println(editNumberOfDoors + dots + "to edit the number of doors (Truck Only).");
        System.out.println(edit4WD + dots + "to edit if 4WD (Truck Only).");
        System.out.println(editType + dots + "to edit vehicle type (Car Only).");
        userInput = reader.nextLine();
        if (editPrice.equals(userInput)) {
            System.out.println("What is the price of the truck to the nearest dollar?");
            userInput = reader.nextLine();
            vehicleEdit.setPrice(userInput);
        }
        vehicleLibrary.put(vehicleEdit.getID(), vehicleEdit);
        cont = false;
        prompt();
    }

    public void remove() {
        if (!vehicleLibrary.isEmpty()) {
            Vehicle toEditVehicle = null;
            System.out.println("Do you know the ID of the vehicle you would like to remove?");
            userInput = reader.nextLine();
            userInput = userInput.toLowerCase().trim();
            if (yesNo(userInput)) {
                System.out.println("What is the ID?");
                Integer getId = Integer.parseInt(reader.nextLine());
                for (Integer key : this.vehicleLibrary.keySet()) {
                    if (key == getId) {
                        toEditVehicle = vehicleLibrary.get(key);
                        System.out.println(toEditVehicle);
                    }
                }
            } else {
                listVehicles();
            }
            try {
                vehicleLibrary.remove(toEditVehicle.getID(), toEditVehicle);
                System.out.println("Vehicle was deleted.");
                listVehicles();
            } catch (Exception e) {
                System.out.println("Error: Vehicle was not deleted. " + e);
            }
        } else {
            System.out.println("You do not have any vehicles to edit.");
            cont = false;
            prompt();
        }
        cont = false;
        prompt();
    }

    public void importVehicles() {
        VehicleReader vehicleReader = new VehicleReader("src\\com\\carrater\\data\\vehicles.txt");
        if (vehicleLibrary.isEmpty()) {
            vehicleLibrary = vehicleReader.readContents();
        } else {
            for (Map.Entry<Integer, Vehicle> entry : vehicleReader.readContents().entrySet()) {
                vehicleLibrary.put(entry.getKey(), entry.getValue());
            }
        }
        cont = false;
        prompt();
    }

    public void rate() {
        if(!vehicleLibrary.isEmpty()) {
            Rater rater = new Rater(vehicleLibrary);
            vehicleLibrary = rater.rateVehicles(vehicleLibrary);
            rater.printRatedVehicles();
        } else {
            System.out.println("There are no vehicles to rate.");
        }
        cont = false;
        prompt();
    }

    public void wouldYouLikeToContinue() {
        System.out.println("Would you like to go back to the main menu or quit?\n");
        System.out.println(main + dots + "to go back to the main menu.");
        System.out.println(quit + dots + "to go ahead and exit the program.");
        userInput = reader.nextLine();
        userInput = userInput.toUpperCase().trim();
        if (main.equals(userInput)) {
            cont = false;
            prompt();
        } else if (quit.equals(userInput)) {
            quitProgram();
        } else {
            System.out.println("Sorry I didn't catch that.\n");
            wouldYouLikeToContinue();
        }
    }

    public void saveVehicles() {
        if (this.vehicleLibrary.isEmpty()) {
            System.out.println("You have no vehicles to save.");
        } else {
            VehicleWriter vehicleWriter = new VehicleWriter(vehicleLibrary);
            vehicleWriter.writeVehicles();
        }
        cont = false;
        prompt();
    }

    public void quitProgram() {
        System.out.println("Thank you for using our Vehicle Rating Program! We hope we were able to help you " +
                "find the vehicle you are looking for.");
    }

}
