package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.List;
import java.io.PrintWriter;



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

            // Create a writer for the output file
            PrintWriter writer = new PrintWriter("version_summary.txt");
            
            writer.println("ROOMS:");
            for (Room room : rooms) {
                writer.println("---------------");
                writer.println("GUID: " + room.getGuid());
                writer.println("Name: " + room.getName());
                writer.println("Long Name: " + room.getLongName());
                writer.println("Area: " + room.getNetFloorArea());
                writer.println("Volume: " + room.getNetVolume());
                writer.println("AirConditioning: " + room.getAirConditioning());
                writer.println("Connected Doors: " + room.getConnectedDoors());
            }

            // Print doors
            writer.println("\nDOORS:");
            for (Door door : doors) {
                writer.println("---------------");
                writer.println("GUID: " + door.getGuid());
                writer.println("Name: " + door.getName());
                writer.println("Width: " + door.getOverallWidth());
                writer.println("Height: " + door.getOverallHeight());
                writer.println("Thermal Transmittance: " + door.getThermalTransmittance());
                writer.println("Storey: " + door.getStorey());
            }

            // Close the writer to save the file
            writer.close();

            System.out.println("✅ Summary exported to version_summary.txt");

        } catch (Exception e) {
            System.err.println("Failed to load or parse JSON:");
            e.printStackTrace();
        }
    }
}
