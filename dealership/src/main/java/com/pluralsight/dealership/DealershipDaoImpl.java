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
public class DealershipDaoImpl implements DealershipDao{
    private DataSource dataSource;

    @Autowired
    public DealershipDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public List<Dealership> findAllDealerships() {
        List<Dealership> dealerships = new ArrayList<>();
        String query = "SELECT * FROM dealerships";

        try (Connection connection = dataSource.getConnection();
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

