package com.pluralsight.dealership;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RequestMapping(path = "/vehicle")
public class VehicleController {
    private  VehicleDaoSqlImpl vehicleDaoSql;

    public VehicleController(VehicleDaoSqlImpl vehicleDaoSql) {
        this.vehicleDaoSql = vehicleDaoSql;
    }
    @RequestMapping
    public List<Vehicle> getAll(){
        return vehicleDaoSql.findAllVehicles();
    }
    // This will be used to create the vehicle
    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Vehicle addVehicle(@RequestBody Vehicle vehicle){
        vehicleDaoSql.addVehicle(vehicle);
        return vehicle;
    }
    //This method will be used to delete a vehicle
    @RequestMapping(method = RequestMethod.DELETE,path = "/delete/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable(name = "id") Integer vin){
        vehicleDaoSql.removeVehicle(vin);
    }

    // GET method for searching vehicles based on various parameters (with optional filters)
    @GetMapping("/search")
    public List<Vehicle> searchByAll(@RequestParam(required = false) String make,
                                     @RequestParam(required = false) String model,
                                     @RequestParam(required = false) String type,
                                     @RequestParam(required = false) String color,
                                     @RequestParam(required = false) Integer year,
                                     @RequestParam(required = false) Integer vin,
                                     @RequestParam(required = false) Double minPrice,
                                     @RequestParam(required = false) Double maxPrice,
                                     @RequestParam(required = false, defaultValue = "0") Integer minMileage,
                                     @RequestParam(required = false, defaultValue = "500000") Integer maxMileage){

        // Fetches all vehicles from the database
        List<Vehicle> vehicleList = vehicleDaoSql.findAllVehicles();
        return vehicleList.stream()
                .filter(vehicle -> vin == null || vin == vehicle.getVin())
                .filter(vehicle -> make == null || make.equalsIgnoreCase(vehicle.getMake()))
                .filter(vehicle -> model == null || model.equalsIgnoreCase(vehicle.getModel()))
                .filter(vehicle -> type == null || type.equalsIgnoreCase(vehicle.getVehicleType()))
                .filter(vehicle -> color == null || color.equalsIgnoreCase(vehicle.getColor()))
                .filter(vehicle -> year == null || year == vehicle.getYear())
                .filter(vehicle -> minPrice == null || minPrice <= vehicle.getPrice())
                .filter(vehicle -> maxPrice == null || maxPrice >= vehicle.getPrice())
                .filter(vehicle -> minMileage == null || minMileage <= vehicle.getOdometer())
                .filter(vehicle -> maxMileage == null || maxMileage >= vehicle.getOdometer()).toList();
    }
}
