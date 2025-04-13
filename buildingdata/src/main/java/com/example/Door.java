package com.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Door {
    @JsonProperty("GUID")
    private String guid;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("OverallWidth")
    private Double overallWidth;

    @JsonProperty("OverallHeight")
    private Double overallHeight;

    @JsonProperty("Area")
    private Double area;

    @JsonProperty("Volume")
    private Double volume;

    @JsonProperty("ThermalTransmittance")
    private Double thermalTransmittance;

    @JsonProperty("Storey")
    private String storey;

    // Default constructor
    public Door() {}

    // Parameterized constructor
    public Door(String guid, String name, Double overallWidth, Double overallHeight,
                Double area, Double volume, Double thermalTransmittance, String storey) {
        this.guid = guid;
        this.name = name;
        this.overallWidth = overallWidth;
        this.overallHeight = overallHeight;
        this.area = area;
        this.volume = volume;
        this.thermalTransmittance = thermalTransmittance;
        this.storey = storey;
    }

    // Getters
    public String getGuid() { return guid; }
    public String getName() { return name; }
    public Double getOverallWidth() { return overallWidth; }
    public Double getOverallHeight() { return overallHeight; }
    public Double getArea() { return area; }
    public Double getVolume() { return volume; }
    public Double getThermalTransmittance() { return thermalTransmittance; }
    public String getStorey() { return storey; }

    // Setters
    public void setGuid(String guid) { this.guid = guid; }
    public void setName(String name) { this.name = name; }
    public void setOverallWidth(Double overallWidth) { this.overallWidth = overallWidth; }
    public void setOverallHeight(Double overallHeight) { this.overallHeight = overallHeight; }
    public void setArea(Double area) { this.area = area; }
    public void setVolume(Double volume) { this.volume = volume; }
    public void setThermalTransmittance(Double thermalTransmittance) { this.thermalTransmittance = thermalTransmittance; }
    public void setStorey(String storey) { this.storey = storey; }
}

