package com.parkinglot.domain.models.vehicle;

import com.parkinglot.domain.enums.VehicleType;

public class Bus extends Vehicle {
    public Bus(String licenseNumber) {
        super(licenseNumber, VehicleType.BUS);
    }
}
