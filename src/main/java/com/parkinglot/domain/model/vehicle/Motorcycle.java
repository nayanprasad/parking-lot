package com.parkinglot.domain.model.vehicle;

public class Motorcycle extends Vehicle {
    public Motorcycle(String licenseNumber) {
        super(licenseNumber, VehicleType.MOTORCYCLE);
    }
}
