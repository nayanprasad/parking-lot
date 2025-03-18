package com.parkinglot.domain.models.parking;

import com.parkinglot.domain.enums.ParkingSpotType;
import com.parkinglot.domain.enums.VehicleType;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class ParkingFloor {
    private String name;
    private List<ParkingSpot> parkingSpots;
    private DisplayBoard displayBoard;

    public ParkingFloor(String name) {
        this.name = name;
        this.parkingSpots = new ArrayList<>();
    }

    public boolean addParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpots.add(parkingSpot);
        return true;
    }

    public boolean removeParkingSpot(ParkingSpot parkingSpot) {
        return this.parkingSpots.remove(parkingSpot);
    }

    public void updateDisplayBoard() {
        if(displayBoard == null) return;

        Map<ParkingSpotType, Integer> freeSpotsCount = new HashMap<>();
        for(ParkingSpotType parkingSpotType : ParkingSpotType.values()) {
            freeSpotsCount.put(parkingSpotType, 0);
        }

        for(ParkingSpot parkingSpot : parkingSpots) {
            if(parkingSpot.isFree()) {
                ParkingSpotType parkingSpotType = parkingSpot.getParkingSpotType();
                freeSpotsCount.put(parkingSpotType, freeSpotsCount.get(parkingSpotType) + 1);
            }
        }

        for(Map.Entry<ParkingSpotType, Integer> entry: freeSpotsCount.entrySet()) {
            displayBoard.updateFreeSpotsCount(entry.getKey(), entry.getValue());
        }

        displayBoard.display();
    }

    public ParkingSpot findAvailableSpot(VehicleType vehicleType) {
        ParkingSpotType requiredParkingSpotType = getRequiredSpotType(vehicleType);
        for(ParkingSpot parkingSpot : parkingSpots) {
            if(parkingSpot.isFree() && parkingSpot.getParkingSpotType().equals(requiredParkingSpotType)) {
                return parkingSpot;
            }
        }
        return null;
    }

    public ParkingSpotType getRequiredSpotType(VehicleType vehicleType) {
        switch (vehicleType) {
            case MOTORCYCLE:
                return ParkingSpotType.COMPACT;
            case TRUCK:
            case BUS:
                return ParkingSpotType.LARGE;
            case CAR:
                return ParkingSpotType.REGULAR;
            default:
                return ParkingSpotType.REGULAR;
        }
    }

}
