package com.pluralsight.dealership;

import java.util.List;

public interface VehicleDao {
    List<Vehicle> findAllVehicles();
    List<Vehicle> findVehiclesByVin(int userVin);
    List<Vehicle> findVehiclesByYear(int min, int max);
    List<Vehicle> findVehicleByMakeModel(String userMake, String userModel);
    List<Vehicle> findVehiclesByType(String userType);
    List<Vehicle> findVehiclesByColor(String userColor);
    List<Vehicle> findVehiclesByOdometer(int min, int max);
    List<Vehicle> findVehiclesByPrice(double min, double max);
    void addVehicle(Vehicle v);
    void removeVehicle(int vin);
}
