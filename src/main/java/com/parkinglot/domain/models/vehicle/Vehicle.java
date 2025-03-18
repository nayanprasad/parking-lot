package com.parkinglot.domain.models.vehicle;

import com.parkinglot.domain.enums.VehicleType;
import lombok.Data;

import java.util.UUID;

@Data
public class Vehicle {
    private String licenseNumber;
    private VehicleType vehicleType;
    private UUID ticketId;

    public Vehicle(String licenseNumber, VehicleType vehicleType) {
        this.licenseNumber = licenseNumber;
        this.vehicleType = vehicleType;
    }
}
