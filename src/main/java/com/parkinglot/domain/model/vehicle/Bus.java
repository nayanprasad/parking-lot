package com.parkinglot.domain.model.vehicle;

public class Bus extends Vehicle {
    public Bus(String licenseNumber) {
        super(licenseNumber, VehicleType.BUS);
    }
}
