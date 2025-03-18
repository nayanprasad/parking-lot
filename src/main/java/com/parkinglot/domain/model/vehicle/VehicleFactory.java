package com.parkinglot.domain.model.vehicle;

public class VehicleFactory {
    public static Vehicle createVehicle(VehicleType vehicleType, String licenceNumber) {
        switch (vehicleType) {
            case BUS -> {
                return new Bus(licenceNumber);
            }
            case CAR -> {
                return new Car(licenceNumber);
            }
            case TRUCK -> {
                return new Truck(licenceNumber);
            }
            case MOTORCYCLE -> {
                return new Motorcycle(licenceNumber);
            }
            default -> {
                return null;
            }
        }
    }
}
