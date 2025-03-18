package com.parkinglot.domain.models.parking;

import com.parkinglot.domain.enums.ParkingSpotType;
import com.parkinglot.domain.models.vehicle.Vehicle;
import lombok.Data;

@Data
public class ParkingSpot {
    private String  number;
    private boolean isFree;
    private Vehicle vehicle;
    private ParkingSpotType parkingSpotType;

    public ParkingSpot(String  number, ParkingSpotType parkingSpotType) {
        this.number = number;
        this.parkingSpotType = parkingSpotType;
        this.isFree = true;
    }

    public boolean assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isFree = false;
        return true;
    }

    public boolean removeVehicle() {
        this.isFree = true;
        this.vehicle = null;
        return true;
    }
}
