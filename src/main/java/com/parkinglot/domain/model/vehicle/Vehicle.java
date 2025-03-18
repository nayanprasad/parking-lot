package com.parkinglot.domain.model.vehicle;

import lombok.AllArgsConstructor;
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
