package com.parkinglot.domain.models.vehicle;

import com.parkinglot.domain.enums.VehicleType;

public class Car extends Vehicle {
    public Car(String licenseNumber) {
        super(licenseNumber, VehicleType.CAR);
    }
}
