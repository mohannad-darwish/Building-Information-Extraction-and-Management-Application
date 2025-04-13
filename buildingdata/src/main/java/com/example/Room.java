package com.example;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Room {
    @JsonProperty("GUID")
    private String guid;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("LongName")
    private String longName;

    @JsonProperty("NetFloorArea")
    private Double netFloorArea;

    @JsonProperty("NetVolume")
    private Double netVolume;

    @JsonProperty("ConnectedDoors")
    private List<String> connectedDoors;

    @JsonProperty("AirConditioning")
    private String airConditioning;

    // Default constructor
    public Room() {}

    // Parameterized constructor
    public Room(String guid, String name, String longName,
                Double netFloorArea, Double netVolume,
                List<String> connectedDoors, String airConditioning) {
        this.guid = guid;
        this.name = name;
        this.longName = longName;
        this.netFloorArea = netFloorArea;
        this.netVolume = netVolume;
        this.connectedDoors = connectedDoors;
        this.airConditioning = airConditioning;
    }

    // Getters
    public String getGuid() { return guid; }
    public String getName() { return name; }
    public String getLongName() { return longName; }
    public Double getNetFloorArea() { return netFloorArea; }
    public Double getNetVolume() { return netVolume; }
    public List<String> getConnectedDoors() { return connectedDoors; }
    public String getAirConditioning() { return airConditioning; }

    // Setters
    public void setGuid(String guid) { this.guid = guid; }
    public void setName(String name) { this.name = name; }
    public void setLongName(String longName) { this.longName = longName; }
    public void setNetFloorArea(Double netFloorArea) { this.netFloorArea = netFloorArea; }
    public void setNetVolume(Double netVolume) { this.netVolume = netVolume; }
    public void setConnectedDoors(List<String> connectedDoors) { this.connectedDoors = connectedDoors; }
    public void setAirConditioning(String airConditioning) { this.airConditioning = airConditioning; }
}

