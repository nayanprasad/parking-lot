package com.parkinglot.domain.models.parking;

import java.util.UUID;

public class Exit {
    private UUID id;
    private ParkingLot parkingLot;

    public Exit(UUID id, ParkingLot parkingLot) {
        this.id = id;
        this.parkingLot = parkingLot;
    }
}
