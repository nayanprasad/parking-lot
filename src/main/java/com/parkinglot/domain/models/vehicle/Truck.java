package com.parkinglot.domain.models.vehicle;

import com.parkinglot.domain.enums.VehicleType;

public class Truck extends Vehicle {
    public Truck(String licenseNumber) {
        super(licenseNumber, VehicleType.TRUCK);
    }
}
