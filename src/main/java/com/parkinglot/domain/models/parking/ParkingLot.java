package com.parkinglot.domain.models.parking;

import com.parkinglot.domain.enums.VehicleType;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class ParkingLot {

    private static ParkingLot instance = null;

    private UUID id;
    private String name;
    private List<ParkingFloor> parkingFloors;
    private List<Entrance> entrances;
    private List<Exit> exits;

    public ParkingLot() {
        this.parkingFloors = new ArrayList<>();
        this.entrances = new ArrayList<>();
        this.exits = new ArrayList<>();
    }

    public static ParkingLot getInstance() {
        if(instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }

    public void initialize(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public boolean addParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloors.add(parkingFloor);
        return true;
    }

    public boolean addEntrance(Entrance entrance) {
        this.entrances.add(entrance);
        return true;
    }

    public boolean addExits(Exit exit) {
        this.exits.add(exit);
        return true;
    }


    public ParkingSpot findAvailableSpot(VehicleType vehicleType) {
        for(ParkingFloor parkingFloor : parkingFloors) {
            ParkingSpot parkingSpot = parkingFloor.findAvailableSpot(vehicleType);
            if(parkingSpot != null) {
                return parkingSpot;
            }
        }
        return null;
    }


}
