package com.parkinglot.domain.observer;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class ParkingLotAudit implements IParkingObserver{
    private List<String> auditLogs;

    public ParkingLotAudit() {
        auditLogs = new ArrayList<>();
    }

    @Override
    public void update(String message) {
        String logMessage = LocalDateTime.now() + ": " + message;
        auditLogs.add(logMessage);
        System.out.println("AUDIT: " + logMessage);
    }
}
