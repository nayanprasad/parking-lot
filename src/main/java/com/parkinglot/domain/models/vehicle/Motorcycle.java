package com.parkinglot.domain.models.vehicle;

import com.parkinglot.domain.enums.VehicleType;

public class Motorcycle extends Vehicle {
    public Motorcycle(String licenseNumber) {
        super(licenseNumber, VehicleType.MOTORCYCLE);
    }
}
