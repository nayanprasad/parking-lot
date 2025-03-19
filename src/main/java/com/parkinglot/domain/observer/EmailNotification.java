package com.parkinglot.domain.observer;

public class EmailNotification implements IParkingObserver{
    @Override
    public void update(String message) {
        System.out.println("EMAIL: " + message);
    }
}
