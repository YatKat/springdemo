package mate.academy.springdemo.service;

import mate.academy.springdemo.model.Customer;
import mate.academy.springdemo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.getOne(id);
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("CustomerServiceImpl is done");
        System.out.println("=============================================");
    }
}
