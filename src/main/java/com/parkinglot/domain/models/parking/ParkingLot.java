package com.parkinglot.domain.models.parking;

import com.parkinglot.domain.enums.PaymentMethod;
import com.parkinglot.domain.enums.VehicleType;
import com.parkinglot.domain.models.payment.ParkingReceipt;
import com.parkinglot.domain.models.payment.ParkingTicket;
import com.parkinglot.domain.models.vehicle.Vehicle;
import com.parkinglot.domain.observer.IParkingObserver;
import com.parkinglot.domain.strategy.IPricingStrategy;
import lombok.Data;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class ParkingLot {

    private static ParkingLot instance = null;

    private UUID id;
    private String name;
    private List<ParkingFloor> parkingFloors;
    private List<Entrance> entrances;
    private List<Exit> exits;
    private IPricingStrategy pricingStrategy;
    private List<IParkingObserver> parkingObservers;

    public ParkingLot() {
        this.parkingFloors = new ArrayList<>();
        this.entrances = new ArrayList<>();
        this.exits = new ArrayList<>();
        this.parkingObservers = new ArrayList<>();
    }

    public static ParkingLot getInstance() {
        if(instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }

    public void initialize(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public boolean addParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloors.add(parkingFloor);
        return true;
    }

    public boolean addEntrance(Entrance entrance) {
        this.entrances.add(entrance);
        return true;
    }

    public boolean addExits(Exit exit) {
        this.exits.add(exit);
        return true;
    }

    public boolean addObserver(IParkingObserver parkingObserver) {
        this.parkingObservers.add(parkingObserver);
        return true;
    }

    public boolean removeObserver(IParkingObserver parkingObserver) {
        return this.parkingObservers.remove(parkingObserver);
    }

    public void notifyObservers(String message) {
        for(IParkingObserver observer : parkingObservers) {
            observer.update(message);
        }
    }


    public ParkingSpot findAvailableSpot(VehicleType vehicleType) {
        for(ParkingFloor parkingFloor : parkingFloors) {
            ParkingSpot parkingSpot = parkingFloor.findAvailableSpot(vehicleType);
            if(parkingSpot != null) {
                return parkingSpot;
            }
        }
        return null;
    }

    public ParkingTicket issueTicket(Vehicle vehicle) {
        ParkingSpot parkingSpot = findAvailableSpot(vehicle.getVehicleType());

        if (parkingSpot == null) {
            throw new RuntimeException("No parking spot available for " + vehicle.getVehicleType());
        }

        parkingSpot.assignVehicle(vehicle);

        ParkingTicket ticket = new ParkingTicket(UUID.randomUUID(), parkingSpot, vehicle);;

        notifyObservers("Ticket issued: " + ticket.getId() + " for vehicle: " + vehicle.getLicenseNumber());

        return ticket;
    }

    public ParkingReceipt processTicket(ParkingTicket ticket, PaymentMethod paymentMethod) {
        Duration parkingDuration = ticket.getParkingDuration();
        VehicleType vehicleType = ticket.getVehicle().getVehicleType();
        double amount = pricingStrategy.calculatePrice(parkingDuration, vehicleType);
        ticket.setAmount(amount);

        ticket.markAsPaid();

        ParkingSpot parkingSpot = ticket.getParkingSpot();
        parkingSpot.removeVehicle();

        notifyObservers("Payment processed: " + ticket.getId() + " amount: $" + amount);


        for(ParkingFloor parkingFloor : parkingFloors) {
            parkingFloor.updateDisplayBoard();
        }

        return new ParkingReceipt(UUID.randomUUID(), ticket, paymentMethod);
    }

}
