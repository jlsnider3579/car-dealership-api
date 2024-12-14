package com.pluralsight.dealership;

public abstract class Contract {
    private String date;
    private String firstName;
    private String lastName;
    private String customerEmail;
    private Vehicle vehicleSold;
    private double totalPrice;
    private double monthlyPayment;

    public String getLastName() {
        return lastName;
    }

    public Contract(String date, String firstName, String lastName, String customerEmail, Vehicle vehicleSold) {
        this.date = date;
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;
    }

    public String getDate() {
        return date;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public Vehicle getVehicleSold() {
        return vehicleSold;
    }
    abstract double getTotalPrice();
    abstract double getMonthlyPayment();

    @Override
    public String toString() {
        return "com.pluralsight.dealership.Contract{" +
                "date='" + date + '\'' +
                ", customerName='" + firstName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", vehicleSold=" + vehicleSold +
                ", totalPrice=" + totalPrice +
                ", monthlyPayment=" + monthlyPayment +
                '}';
    }
}
