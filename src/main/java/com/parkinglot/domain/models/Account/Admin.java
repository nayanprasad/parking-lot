package com.parkinglot.domain.models.Account;

import com.parkinglot.domain.models.parking.*;

public class Admin extends Account {
    public Admin(String username, String password, Person person) {
        super(username, password, person);
    }

    public boolean addEntrance(ParkingLot parkingLot, Entrance entrance) {
        return parkingLot.addEntrance(entrance);
    }

    public boolean addExit(ParkingLot parkingLot, Exit exit) {
        return parkingLot.addExits(exit);
    }

    public boolean addParkingSpot(ParkingFloor parkingFloor, ParkingSpot parkingSpot) {
        return parkingFloor.addParkingSpot(parkingSpot);
    }

    public boolean removeParkingSpot(ParkingFloor parkingFloor, ParkingSpot parkingSpot) {
        return parkingFloor.removeParkingSpot(parkingSpot);
    }

    public boolean addDisplayBoard(ParkingFloor parkingFloor, DisplayBoard displayBoard) {
        parkingFloor.setDisplayBoard(displayBoard);
        return true;
    }
}
