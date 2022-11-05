package lk.babyland.babyland.service;

import lk.babyland.babyland.dto.CreateCustomerDto;
import lk.babyland.babyland.entity.Customer;
import java.util.Optional;

public interface CustomerService {
    Iterable<Customer> allCustomers();

    Optional<Customer> getCustomerByUsername(final String usernameCustomer);

    Optional<Customer> saveCustomer(final CreateCustomerDto customer);
    
}
