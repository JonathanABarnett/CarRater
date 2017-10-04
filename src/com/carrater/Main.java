package com.carrater;

import com.carrater.controller.UI;

/**
 * Author: Jonathan Barnett
 * Purpose: Allows user to enter information about a used car/truck to determine the
 * best vehicle based on mileage, price, and some other attributes. Vehicles can be
 * saved in a CSV file and read from.
 * Version: 1.0
 */
public class Main {

    public static void main(String[] args) {
        UI ui = new UI();
        ui.begin();
    }
}
