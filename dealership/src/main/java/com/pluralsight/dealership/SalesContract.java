package com.pluralsight.dealership;

public class SalesContract extends Contract{
    private final double salesTaxAmount = 0.05;
    private final double recordingFee = 100.0;
    private double processingFee;
    private boolean wantToFinance;
    private boolean monthlyPaymentIfFinancing;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
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
        return 0;
    }

    @Override
    double getMonthlyPayment() {
        // TODO ADD THE LOGIC TO GET TOTAL PRICE OF LEASE CONTRACT
        return 0;
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
