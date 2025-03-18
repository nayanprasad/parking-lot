package com.parkinglot.domain.models.parking;

import com.parkinglot.domain.enums.PaymentMethod;
import com.parkinglot.domain.models.payment.ParkingReceipt;
import com.parkinglot.domain.models.payment.ParkingTicket;

import java.util.UUID;

public class Exit {
    private UUID id;
    private ParkingLot parkingLot;

    public Exit(UUID id, ParkingLot parkingLot) {
        this.id = id;
        this.parkingLot = parkingLot;
    }

    public ParkingReceipt processTicket(ParkingTicket parkingTicket, PaymentMethod paymentMethod) {
        return this.parkingLot.processTicket(parkingTicket, paymentMethod);
    }
}
