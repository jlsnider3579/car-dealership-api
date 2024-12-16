package com.pluralsight.dealership;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleDaoSqlImpl implements VehicleDao {
    private DataSource dataSource;

    public VehicleDaoSqlImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Vehicle> findAllVehicles() {
        ArrayList<Vehicle> showAllVehicles = new ArrayList<>();
        int vin;
        int year;
        String make;
        String model;
        String vehicleType;
        String color;
        int odometer;
        double price;


        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("""
                    SELECT * FROM vehicle
                    """);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                vin = resultSet.getInt("vin");
                year = resultSet.getInt("year");
                make = resultSet.getString("make");
                model = resultSet.getString("model");
                vehicleType = resultSet.getString("type");
                color = resultSet.getString("color");
                odometer = resultSet.getInt("odometer");
                price = resultSet.getDouble("price");

                Vehicle v = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                showAllVehicles.add(v);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return List.of();
    }

    @Override
    public List<Vehicle> findVehiclesByVin(int userVin) {
        ArrayList<Vehicle> showVehiclesByVin = new ArrayList<>();
        int vin;
        int year;
        String make;
        String model;
        String vehicleType;
        String color;
        int odometer;
        double price;

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("""
                     SELECT * FROM vehicle WHERE vin = ?;
                    """);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                vin = resultSet.getInt("vin");
                year = resultSet.getInt("year");
                make = resultSet.getString("make");
                model = resultSet.getString("model");
                vehicleType = resultSet.getString("type");
                color = resultSet.getString("color");
                odometer = resultSet.getInt("odometer");
                price = resultSet.getDouble("price");

                Vehicle v = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                showVehiclesByVin.add(v);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return List.of();
    }

    @Override
    public List<Vehicle> findVehiclesByYear(int min, int max) {
        ArrayList<Vehicle> showVehiclesByYear = new ArrayList<>();
        int vin;
        int year;
        String make;
        String model;
        String vehicleType;
        String color;
        int odometer;
        double price;

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("""
                     SELECT * FROM vehicle WHERE year = ?;
                    """);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                vin = resultSet.getInt("vin");
                year = resultSet.getInt("year");
                make = resultSet.getString("make");
                model = resultSet.getString("model");
                vehicleType = resultSet.getString("type");
                color = resultSet.getString("color");
                odometer = resultSet.getInt("odometer");
                price = resultSet.getDouble("price");

                Vehicle v = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                showVehiclesByYear.add(v);

            }

            return List.of();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Vehicle> findVehicleByMakeModel(String userMake, String userModel) {
        ArrayList<Vehicle> showVehiclesByModel = new ArrayList<>();
        int vin;
        int year;
        String make;
        String model;
        String vehicleType;
        String color;
        int odometer;
        double price;

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("""
                     SELECT * FROM vehicle WHERE model = ?;
                    """);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                vin = resultSet.getInt("vin");
                year = resultSet.getInt("year");
                make = resultSet.getString("make");
                model = resultSet.getString("model");
                vehicleType = resultSet.getString("type");
                color = resultSet.getString("color");
                odometer = resultSet.getInt("odometer");
                price = resultSet.getDouble("price");

                Vehicle v = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                showVehiclesByModel.add(v);

            }

            return List.of();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Vehicle> findVehiclesByType(String userType) {
        ArrayList<Vehicle> showVehiclesByType = new ArrayList<>();
        int vin;
        int year;
        String make;
        String model;
        String vehicleType;
        String color;
        int odometer;
        double price;

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("""
                     SELECT * FROM vehicle WHERE Vehicle_type = ?;
                    """);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                vin = resultSet.getInt("vin");
                year = resultSet.getInt("year");
                make = resultSet.getString("make");
                model = resultSet.getString("model");
                vehicleType = resultSet.getString("type");
                color = resultSet.getString("color");
                odometer = resultSet.getInt("odometer");
                price = resultSet.getDouble("price");

                Vehicle v = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                showVehiclesByType.add(v);

            }

            return List.of();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Vehicle> findVehiclesByColor(String userColor) {
        ArrayList<Vehicle> showVehiclesByColor = new ArrayList<>();
        int vin;
        int year;
        String make;
        String model;
        String vehicleType;
        String color;
        int odometer;
        double price;

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("""
                     SELECT * FROM vehicle WHERE color = ?;
                    """);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                vin = resultSet.getInt("vin");
                year = resultSet.getInt("year");
                make = resultSet.getString("make");
                model = resultSet.getString("model");
                vehicleType = resultSet.getString("type");
                color = resultSet.getString("color");
                odometer = resultSet.getInt("odometer");
                price = resultSet.getDouble("price");

                Vehicle v = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                showVehiclesByColor.add(v);

            }

            return List.of();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Vehicle> findVehiclesByOdometer(int min, int max) {
        ArrayList<Vehicle> showVehiclesByOdometer = new ArrayList<>();
        int vin;
        int year;
        String make;
        String model;
        String vehicleType;
        String color;
        int odometer;
        double price;

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("""
                     SELECT * FROM vehicle WHERE odometer BETWEEN ? AND ?;
                    """);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                vin = resultSet.getInt("vin");
                year = resultSet.getInt("year");
                make = resultSet.getString("make");
                model = resultSet.getString("model");
                vehicleType = resultSet.getString("type");
                color = resultSet.getString("color");
                odometer = resultSet.getInt("odometer");
                price = resultSet.getDouble("price");

                Vehicle v = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                showVehiclesByOdometer.add(v);

            }

            return List.of();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Vehicle> findVehiclesByPrice(double min, double max) {
        ArrayList<Vehicle> showVehiclesByPrice = new ArrayList<>();
        int vin;
        int year;
        String make;
        String model;
        String vehicleType;
        String color;
        int odometer;
        double price;

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("""
                    SELECT * FROM vehicle WHERE price BETWEEN ? AND ?;
                    """);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                vin = resultSet.getInt("vin");
                year = resultSet.getInt("year");
                make = resultSet.getString("make");
                model = resultSet.getString("model");
                vehicleType = resultSet.getString("type");
                color = resultSet.getString("color");
                odometer = resultSet.getInt("odometer");
                price = resultSet.getDouble("price");

                Vehicle v = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                showVehiclesByPrice.add(v);

            }

            return List.of();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addVehicle(Vehicle v) {
        try (Connection connection = dataSource.getConnection()) {
            int vin = 0;
            int year = 0;
            String make = "";
            String model = "";
            String vehicleType = "";
            String color = "";
            int odometer = 0;
            double price = 0.0;


            PreparedStatement statement = connection.prepareStatement("""
                    INSERT INTO vehicles VALUES (?, ?, ?, ?, ?, ?, ?, ?);
                    """);


            statement.setInt(2, v.getVin());
            statement.setInt(3, v.getYear());
            statement.setString(4, v.getMake());
            statement.setString(5, v.getModel());
            statement.setString(6, v.getVehicleType());
            statement.setString(7, v.getColor());
            statement.setInt(8, v.getOdometer());
            statement.setDouble(9, v.getPrice());

            int rowsAffected = statement.executeUpdate();
            System.out.println(rowsAffected + "rows inserted");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeVehicle(int vin) {

        try (Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement("""
                    DELETE FROM vehicles WHERE vin = ?;
                    """);

            statement.setInt(1, vin);

            int rowsAffected = statement.executeUpdate();
            System.out.println(rowsAffected + "rows affected");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}