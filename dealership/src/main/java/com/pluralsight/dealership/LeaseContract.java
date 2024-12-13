package com.pluralsight.dealership;

public class LeaseContract extends Contract {
    private double expectedEndingValuePercent = 0.05;
    private double leaseFeePercent = 0.07;
    private double monthlyPayment;

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
    }

    public double getExpectedEndingValuePercent() {
        return expectedEndingValuePercent;
    }

    public double getLeaseFeePercent() {
        leaseFeePercent = Math.round(getVehicleSold().getPrice() * 0.07);
        return leaseFeePercent;
    }

    @Override
    double getTotalPrice() {
        // TODO ADD LOGIC TO GET TOTAL PRICE FOR LEASE CONTRACT
        return  (getVehicleSold().getPrice() + leaseFeePercent) + (getVehicleSold().getPrice() * 0.04);
    }

    @Override
    double getMonthlyPayment() {
        // TODO ADD LOGIC TO GET MONTHLY PAYMENT FOR LEASE Contract
        return  Math.round((getTotalPrice() / 36) * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return "LeaseContract{" +
                "expectedEndingValuePercent=" + expectedEndingValuePercent +
                ", leaseFeePercent=" + leaseFeePercent +
                ", monthlyPayment=" + monthlyPayment +
                '}';
    }
}
