package com.parkinglot.domain.strategy;

import com.parkinglot.domain.enums.VehicleType;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class HourlyPricingStrategy implements IPricingStrategy {
    private Map<VehicleType, Double> hourlyRates;

    public HourlyPricingStrategy() {
        hourlyRates = new HashMap<>();
        hourlyRates.put(VehicleType.CAR, 2.0);
        hourlyRates.put(VehicleType.MOTORCYCLE, 1.0);
        hourlyRates.put(VehicleType.BUS, 5.0);
        hourlyRates.put(VehicleType.TRUCK, 6.0);
    }


    @Override
    public double calculatePrice(Duration parkingTime, VehicleType vehicleType) {
        long hours = parkingTime.toHours();
        return hours * hourlyRates.get(vehicleType);
    }
}
