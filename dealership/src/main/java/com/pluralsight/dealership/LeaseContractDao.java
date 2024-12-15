package com.pluralsight.dealership;

import java.util.ArrayList;

public interface LeaseContractDao {
    ArrayList<LeaseContract> findLeaseContractById(int id);
    void addLeaseContract(LeaseContract leaseContract);
}
