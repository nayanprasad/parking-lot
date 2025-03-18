package com.parkinglot.domain.models.payment;

import com.parkinglot.domain.enums.PaymentMethod;
import com.parkinglot.domain.enums.PaymentStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public class ParkingReceipt {
    private UUID id;
    private ParkingTicket parkingTicket;
    private LocalDateTime issuedAt;
    private double amount;
    private PaymentMethod paymentMethod;
    private PaymentStatus status;

    public ParkingReceipt(UUID id, ParkingTicket parkingTicket, PaymentMethod paymentMethod) {
        this.id = id;
        this.parkingTicket = parkingTicket;
        this.issuedAt = LocalDateTime.now();
        this.amount = parkingTicket.getAmount();
        this.status = PaymentStatus.COMPLETED;
        this.paymentMethod = paymentMethod;
    }

    public void print() {
        System.out.println("Receipt Number: " + id);
        System.out.println("Issued At: " + issuedAt);
        System.out.println("Amount: " + amount);
        System.out.println("Payment Status: " + status);
    }

}
