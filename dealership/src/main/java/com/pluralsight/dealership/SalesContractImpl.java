package com.pluralsight.dealership;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class SalesContractImpl implements SalesContractDao {
    private DataSource dataSource;

    @Autowired
    public SalesContractImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public ArrayList<SalesContract> findSalesContractById(int id) {
        ArrayList<SalesContract> salesContracts = new ArrayList<>();

        try(Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("""
                    SELECT * FROM sales_contract
                    JOIN vehicle ON sales_contract = vehicle.vin
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
                double taxAmount = resultSet.getDouble("salestax_amount");
                double totalPrice = resultSet.getDouble("total_price");
                double processingFee = resultSet.getDouble("processing_fee");
                double recordingFee = resultSet.getDouble("recording_fee");
                boolean financing = resultSet.getBoolean("finacing");
                double monthlyPayment = resultSet.getDouble("monthly_payment");

                Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
                salesContracts.add(new SalesContract(date, firstName, lastName, email, vehicle));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return salesContracts;
    }

    @Override
    public void addSalesContract(SalesContract salesContract) {
        String query = "INSERT INTO sales_contract VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, salesContract.getDate());
            statement.setString(2, salesContract.getFirstName());
            statement.setString(3, salesContract.getLastName());
            statement.setString(4, salesContract.getCustomerEmail());
            statement.setInt(5, salesContract.getVehicleSold().getVin());
            statement.setInt(6, salesContract.getVehicleSold().getYear());
            statement.setString(7, salesContract.getVehicleSold().getMake());
            statement.setString(8, salesContract.getVehicleSold().getModel());
            statement.setString(9, salesContract.getVehicleSold().getVehicleType());
            statement.setString(10, salesContract.getVehicleSold().getColor());
            statement.setInt(11, salesContract.getVehicleSold().getOdometer());
            statement.setDouble(12, salesContract.getVehicleSold().getPrice());
            statement.setDouble(13, salesContract.getSalesTaxAmount());
            statement.setDouble(14, salesContract.getTotalPrice());
            statement.setDouble(15, salesContract.getProcessingFee());
            statement.setDouble(16, salesContract.getRecordingFee());
            statement.setBoolean(17, salesContract.isWantToFinance());
            statement.setDouble(18, salesContract.getMonthlyPayment());

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

