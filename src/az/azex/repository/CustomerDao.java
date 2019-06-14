package az.azex.repository;

import az.azex.domain.Customer;

import java.util.List;

public interface CustomerDao {

    List<Customer> searchCustomers(String query);
}
