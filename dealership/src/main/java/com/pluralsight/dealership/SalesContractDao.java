package com.pluralsight.dealership;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public interface SalesContractDao {
    ArrayList<SalesContract> findSalesContractById(int id);
    void addSalesContract(SalesContract salesContract);

}
