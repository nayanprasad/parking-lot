package com.parkinglot.domain.models.payment;

import com.parkinglot.domain.enums.PaymentStatus;
import com.parkinglot.domain.models.parking.ParkingSpot;
import com.parkinglot.domain.models.vehicle.Vehicle;
import lombok.Data;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ParkingTicket {
    private UUID id;
    private LocalDateTime issuedAt;
    private LocalDateTime payedAt;
    private double amount;
    private PaymentStatus status;
    private ParkingSpot parkingSpot;
    private Vehicle vehicle;

    public ParkingTicket(UUID id, ParkingSpot parkingSpot, Vehicle vehicle) {
        this.id = id;
        this.issuedAt = LocalDateTime.now();
        this.status = PaymentStatus.PENDING;
        this.parkingSpot = parkingSpot;
        this.vehicle = vehicle;

        this.vehicle.assignTicket(id);
    }

    public boolean markAsPaid() {
        this.status = PaymentStatus.COMPLETED;
        return true;
    }

    public Duration getParkingDuration() {
        LocalDateTime endTime = this.payedAt == null ? LocalDateTime.now() : this.payedAt;
        return Duration.between(this.issuedAt, endTime);
    }
}
