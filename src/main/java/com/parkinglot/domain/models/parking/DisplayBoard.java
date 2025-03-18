package com.parkinglot.domain.models.parking;

import com.parkinglot.domain.enums.ParkingSpotType;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DisplayBoard {
    private UUID id;
    private Map<ParkingSpotType, Integer> freeSpotsCount;

    public DisplayBoard(UUID id) {
        this.id = id;
        this.freeSpotsCount = new HashMap<>();
        for (ParkingSpotType parkingSpotType : ParkingSpotType.values()) {
            freeSpotsCount.put(parkingSpotType, 0);
        }
    }

    public boolean updateFreeSpotsCount(ParkingSpotType parkingSpotType, int count) {
        freeSpotsCount.put(parkingSpotType, count);
        return true;
    }

    public void display() {
        System.out.println("Display Board: " + id);
        for (Map.Entry<ParkingSpotType, Integer> entry : freeSpotsCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
