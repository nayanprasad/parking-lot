package com.parkinglot.domain.strategy;

import com.parkinglot.domain.enums.VehicleType;

import java.time.Duration;

public interface IPricingStrategy {
    double calculatePrice(Duration parkingTime, VehicleType vehicleType);
}
