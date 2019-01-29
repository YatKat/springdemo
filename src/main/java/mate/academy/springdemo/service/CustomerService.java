package mate.academy.springdemo.service;

import mate.academy.springdemo.model.Customer;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    Customer getCustomerById(Long id);
}
