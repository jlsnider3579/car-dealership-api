package com.pluralsight.dealership;

public class LeaseContract extends Contract {
    private final double expectedEndingValuePercent = 0.05;
    private final double leaseFeePercent = 0.07;
    private double monthlyPayment;

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
    }

    public double getExpectedEndingValuePercent() {
        return expectedEndingValuePercent;
    }

    public double getLeaseFeePercent() {
        return leaseFeePercent;
    }

    @Override
    double getTotalPrice() {
        // TODO ADD LOGIC TO GET TOTAL PRICE FOR LEASE CONTRACT
        return 0;
    }

    @Override
    double getMonthlyPayment() {
        // TODO ADD LOGIC TO GET MONTHLY PAYMENT FOR LEASE Contract
        return 0;
    }
}
