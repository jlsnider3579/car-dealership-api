package com.pluralsight.dealership;

public class SalesContract extends Contract{
    private final double salesTaxAmount = 0.05;
    private final double recordingFee = 100.0;
    private double processingFee;
    private boolean wantToFinance;
    private boolean monthlyPaymentIfFinancing;

    public SalesContract(String date, String firstName, String lastName, String customerEmail, Vehicle vehicleSold) {
        super(date, firstName, lastName, customerEmail, vehicleSold);
        this.processingFee = processingFee;
        this.wantToFinance = wantToFinance;
        this.monthlyPaymentIfFinancing = monthlyPaymentIfFinancing;
    }

    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public boolean isWantToFinance() {
        return wantToFinance;
    }

    @Override
    double getTotalPrice() {
        // TODO ADD THE LOGIC TO GET TOTAL PRICE OF SALES CONTRACT
        Vehicle vehicleSold = getVehicleSold();
        double total = vehicleSold.getPrice() + vehicleSold.getPrice() * salesTaxAmount + recordingFee + processingFee;
        return total;
    }

    @Override
    double getMonthlyPayment() {
        // TODO ADD THE LOGIC TO GET TOTAL PRICE OF LEASE CONTRACT
        Vehicle vehicleSold = getVehicleSold();
        double monthlyLoanRate = vehicleSold.getPrice() > 10000 ? .0425 : .0525;
        return -1;
    }

    @Override
    public String toString() {
        return "SalesContract{" +
                "salesTaxAmount=" + salesTaxAmount +
                ", recordingFee=" + recordingFee +
                ", processingFee=" + processingFee +
                ", wantToFinance=" + wantToFinance +
                ", monthlyPaymentIfFinancing=" + monthlyPaymentIfFinancing +
                '}';
    }
}
