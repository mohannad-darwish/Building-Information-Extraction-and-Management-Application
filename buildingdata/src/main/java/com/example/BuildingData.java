package com.example;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BuildingData {
    @JsonProperty("Rooms")
    private List<Room> rooms;

    @JsonProperty("Doors")
    private List<Door> doors;

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Door> getDoors() {
        return doors;
    }

    public void setDoors(List<Door> doors) {
        this.doors = doors;
    }
}
