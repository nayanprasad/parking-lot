package com.parkinglot.domain.strategy;

import com.parkinglot.domain.enums.VehicleType;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class DayPricingStrategy implements IPricingStrategy{
    private Map<VehicleType, Double> dailyRates;

    public DayPricingStrategy() {
        dailyRates = new HashMap<>();
        dailyRates.put(VehicleType.CAR, 20.0);
        dailyRates.put(VehicleType.MOTORCYCLE, 10.0);
        dailyRates.put(VehicleType.BUS, 50.0);
        dailyRates.put(VehicleType.TRUCK, 60.0);
    }

    @Override
    public double calculatePrice(Duration parkingDuration, VehicleType vehicleType) {
        long day = parkingDuration.toDays();
        return day * dailyRates.get(vehicleType);
    }
}
