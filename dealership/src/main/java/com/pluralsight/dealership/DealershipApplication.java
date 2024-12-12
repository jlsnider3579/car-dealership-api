package com.pluralsight.dealership;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DealershipApplication {

    public static void main(String[] args) {
        SpringApplication.run(DealershipApplication.class, args);
        BasicDataSource ds = new BasicDataSource();
        ds.setUsername("root");
        ds.setPassword("yearup");
        ds.setUrl("jdbc:mysql://localhost:3306/dealership");

        UserInterFace ui = new UserInterFace(ds);
        ui.display();
    }

}

