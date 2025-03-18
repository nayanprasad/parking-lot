package com.parkinglot.domain.models.parking;

import java.util.UUID;

public class Entrance {
    private UUID id;
    private ParkingLot parkingLot;

    public Entrance(UUID id, ParkingLot parkingLot) {
        this.id = id;
        this.parkingLot = parkingLot;
    }

}
