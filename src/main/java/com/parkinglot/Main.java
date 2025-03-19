package com.parkinglot;


import com.parkinglot.domain.enums.ParkingSpotType;
import com.parkinglot.domain.enums.PaymentMethod;
import com.parkinglot.domain.enums.VehicleType;
import com.parkinglot.domain.models.Account.Admin;
import com.parkinglot.domain.models.Account.Person;
import com.parkinglot.domain.models.parking.*;
import com.parkinglot.domain.models.payment.ParkingReceipt;
import com.parkinglot.domain.models.payment.ParkingTicket;
import com.parkinglot.domain.models.vehicle.Vehicle;
import com.parkinglot.domain.models.vehicle.VehicleFactory;
import com.parkinglot.domain.observer.EmailNotification;
import com.parkinglot.domain.observer.ParkingLotAudit;
import com.parkinglot.domain.strategy.HourlyPricingStrategy;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.initialize(UUID.randomUUID(), "Downtown Parking");

        Person adminPerson = new Person("Admin User", "Admin Address", "admin@example.com", "123-456-7890");
        Admin admin = new Admin("admin", "password", adminPerson);

        ParkingLotAudit audit = new ParkingLotAudit();
        EmailNotification email = new EmailNotification();
        parkingLot.addObserver(audit);
        parkingLot.addObserver(email);

        ParkingFloor parkingFloor1 = new ParkingFloor("Floor 1");

        for(int i = 0; i < 10; i++) {
            admin.addParkingSpot(parkingFloor1, new ParkingSpot("F1-C" + i , ParkingSpotType.COMPACT));
            admin.addParkingSpot(parkingFloor1, new ParkingSpot("F1-R" + i , ParkingSpotType.REGULAR));
            admin.addParkingSpot(parkingFloor1, new ParkingSpot("F1-L" + i , ParkingSpotType.LARGE));
            admin.addParkingSpot(parkingFloor1, new ParkingSpot("F1-H" + i , ParkingSpotType.HANDICAPPED));
        }

        DisplayBoard displayBoard1 = new DisplayBoard(UUID.randomUUID());
        admin.addDisplayBoard(parkingFloor1, displayBoard1);

        parkingLot.addParkingFloor(parkingFloor1);

        Entrance entrance1 = new Entrance(UUID.randomUUID(), parkingLot);
        Entrance entrance2 = new Entrance(UUID.randomUUID(), parkingLot);
        admin.addEntrance(parkingLot, entrance1);
        admin.addEntrance(parkingLot, entrance2);

        Exit exit1 = new Exit(UUID.randomUUID(), parkingLot);
        Exit exit2 = new Exit(UUID.randomUUID(), parkingLot);
        admin.addExit(parkingLot, exit1);
        admin.addExit(parkingLot, exit2);

        parkingLot.setPricingStrategy(new HourlyPricingStrategy());

        Vehicle car1 = VehicleFactory.createVehicle(VehicleType.CAR, "ABC123");
        Vehicle motorcycle1 = VehicleFactory.createVehicle(VehicleType.MOTORCYCLE, "XYZ789");
        Vehicle truck1 = VehicleFactory.createVehicle(VehicleType.TRUCK, "TRK456");

        System.out.println("\n=== Initial Display ===");
        parkingFloor1.updateDisplayBoard();

        ParkingTicket car1ParkingTicket = entrance1.issueTicket(car1);
        ParkingTicket motorcycle1ParkingTicket = entrance1.issueTicket(motorcycle1);

        parkingFloor1.updateDisplayBoard();

        ParkingReceipt car1ParkingReceipt = exit2.processTicket(car1ParkingTicket, PaymentMethod.CASH);


        parkingFloor1.updateDisplayBoard();
    }
}