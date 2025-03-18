package com.parkinglot.domain.models.parking;

import com.parkinglot.domain.models.payment.ParkingTicket;
import com.parkinglot.domain.models.vehicle.Vehicle;

import java.util.UUID;

public class Entrance {
    private UUID id;
    private ParkingLot parkingLot;

    public Entrance(UUID id, ParkingLot parkingLot) {
        this.id = id;
        this.parkingLot = parkingLot;
    }

    public ParkingTicket issueTicket(Vehicle vehicle) {
        return this.parkingLot.issueTicket(vehicle);
    }
}
