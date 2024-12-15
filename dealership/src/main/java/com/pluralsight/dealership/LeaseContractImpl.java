package com.pluralsight.dealership;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Component
public class LeaseContractImpl implements LeaseContractDao{
    private DataSource dataSource;

    @Autowired
    public LeaseContractImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public ArrayList<LeaseContract> findLeaseContractById(int id) {
        ArrayList<LeaseContract> leaseContracts = new ArrayList<>();

        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement("""
                    SELECT *
                    FROM sales_contract
                    JOIN vehicles
                    ON sales_contract.vin = vehicles.vin
                    WHERE contract_id = ?;
                    
                    """);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                String date = resultSet.getString("vehicle_date");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                int dealershipId = resultSet.getInt("dealership_id");
                int vin = resultSet.getInt("vin");
                int year = resultSet.getInt("year");
                String make = resultSet.getString("make");
                String model = resultSet.getString("model");
                String type = resultSet.getString("type");
                String color = resultSet.getString("color");
                int odometer = resultSet.getInt("odometer");
                double price = resultSet.getDouble("price");
                boolean isSold = resultSet.getBoolean("sold");
                double taxAmount = resultSet.getDouble("expected_endingValue");
                double totalPrice = resultSet.getDouble("leasing_fee");
                double monthlyPayment = resultSet.getDouble("monthly_payment");

                Vehicle v = new Vehicle(vin, year, make, model, type, color, odometer, price);
                leaseContracts.add(new LeaseContract(date, firstName, lastName, email, v));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return leaseContracts;
    }

    @Override
    public void addLeaseContract(LeaseContract leaseContract) {

    }

}



