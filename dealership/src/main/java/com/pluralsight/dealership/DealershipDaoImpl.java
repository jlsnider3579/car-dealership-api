package com.pluralsight.dealership;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DealershipDaoImpl implements DealershipDao{
    private final String url;
    private final String usr;
    private final String password;

    public DealershipDaoImpl(String url, String usr, String password) {
        this.url = url;
        this.usr = usr;
        this.password = password;
    }


    @Override
    public List<Dealership> findAllDealerships() {
        List<Dealership> dealerships = new ArrayList<>();
        String query = "SELECT * FROM dealerships";

        try (Connection connection = DatabaseConfig.getConnection(url,usr,password);
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Dealership dealership = new Dealership(
                        resultSet.getString("name"),
                        resultSet.getString("address"),
                        resultSet.getString("phone"),
                        resultSet.getInt("dealership_id")
                );
                dealerships.add(dealership);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dealerships;
    }
}

