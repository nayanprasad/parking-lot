# Parking Lot Management System

## Overview
A thread-safe parking lot management system simulating a multi-level facility. It supports various vehicle types, handles parking operations, ticket issuance, and payment processing while managing concurrent operations efficiently.

## Features
- **Multi-level Parking**: Floors with different parking spots.
- **Vehicle Types**: Car, Motorcycle, Bus, Truck.
- **Parking Spot Types**: Compact, Regular, Large, Handicapped.
- **Real-time Display**: Available spots per floor.
- **Entrance/Exit Management**: Thread-safe ticket processing.
- **Payment System**: Credit Card, Debit Card, Cash.
- **Pricing Strategies**: Hourly, Daily rates.
- **Observer Pattern**: Email notifications, audit logs.
- **Admin Controls**: Manage parking infrastructure.
- **Concurrency Handling**: Efficient multi-threading.

## Technical Architecture
Built with Java using:
- **Singleton Pattern**: Thread-safe ParkingLot instance.
- **Factory Pattern**: Vehicle creation.
- **Observer Pattern**: Notifications, auditing.
- **Strategy Pattern**: Flexible pricing.
- **Thread Pool**: Efficient concurrent operations.

## Core Components
- **Account Management**: Users, Admins.
- **Parking Infrastructure**: ParkingLot, Floors, Spots, Entrances, Exits.
- **Vehicles**: Abstract class with specific types.
- **Payment System**: Tickets, Receipts, Money class.
- **Concurrency Management**: Locks, thread-safe collections.

## Concurrency Handling
- **Thread-safe Collections**: CopyOnWriteArrayList.
- **Lock Mechanisms**: ReadWriteLock.
- **Synchronized Methods**: Critical operations.
- **Atomic Operations**: Parking spot assignment.
- **Thread Pool**: Manages concurrent tasks.
- **Double-checked Locking**: Singleton implementation.

## Usage Example
1. Initialize parking lot
2. Add floors, spots, entrances, exits
3. Process vehicle entry & exit
4. Issue tickets & process payments
5. Simulate concurrent vehicle entries

## Requirements
- Java 17+
- Maven

## Running the Project
```bash
git clone https://github.com/yourusername/parking-lot.git
cd parking-lot
mvn clean install
java -jar target/ParkingLot-1.0-SNAPSHOT.jar
```

## Future Enhancements
- Web UI & Mobile App
- Payment gateway integration
- Advanced reporting & analytics
- Parking spot reservations
- Load balancing for high traffic

