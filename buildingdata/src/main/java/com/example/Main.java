package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.List;



public class Main {
    public static void main(String[] args) {
        try {
            // Load the JSON file and parse it into the BuildingData class
            ObjectMapper mapper = new ObjectMapper();
            BuildingData building = mapper.readValue(
                new File("D:/TU Berlin/CSE/Modellierung in der Bauinformatik/Assignment 2/Building-Information-Extraction-and-Management-Application/building_elements_output.json"),

                    BuildingData.class
            );

            // Get the room and door lists
            List<Room> rooms = building.getRooms();
            List<Door> doors = building.getDoors();

            // Print rooms
            System.out.println("ROOMS:");
            for (Room room : rooms) {
                System.out.println("---------------");
                System.out.println("GUID: " + room.getGuid());
                System.out.println("Name: " + room.getName());
                System.out.println("Long Name: " + room.getLongName());
                System.out.println("Storey: " + room.getStorey());
                System.out.println("Area: " + room.getNetFloorArea());
                System.out.println("Volume: " + room.getNetVolume());
                System.out.println("AirConditioning: " + room.getAirConditioning());
                System.out.println("Connected Doors: " + room.getConnectedDoors());
            }

            // Print doors
            System.out.println("\nDOORS:");
            for (Door door : doors) {
                System.out.println("---------------");
                System.out.println("GUID: " + door.getGuid());
                System.out.println("Name: " + door.getName());
                System.out.println("Width: " + door.getOverallWidth());
                System.out.println("Height: " + door.getOverallHeight());
                System.out.println("Area: " + door.getArea());
                System.out.println("Volume: " + door.getVolume());
                System.out.println("Thermal Transmittance: " + door.getThermalTransmittance());
                System.out.println("Storey: " + door.getStorey());
            }

        } catch (Exception e) {
            System.err.println("Failed to load or parse JSON:");
            e.printStackTrace();
        }
    }
}
