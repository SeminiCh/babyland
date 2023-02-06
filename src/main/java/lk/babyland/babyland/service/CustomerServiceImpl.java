package lk.babyland.babyland.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.babyland.babyland.dto.CreateCustomerDto;
import lk.babyland.babyland.entity.Customer;
import lk.babyland.babyland.repo.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public Iterable<Customer> allCustomers() {
        return customerRepo.findAll();
    }

    @Override
    public Optional<Customer> getCustomerByUsername(String usernameCustomer) {
        return customerRepo.findByUsernameCustomer(usernameCustomer);
    }

    @Override
    public Optional<Customer> saveCustomer(CreateCustomerDto customer) {
        
        Optional<Customer> foundCustomer = this.customerRepo.findByUsernameCustomer(customer.getUsernameCustomer());
        
        if(foundCustomer.isPresent()) {
            System.out.println("Username is not available");
            return Optional.empty();

        }
        else{
            Customer newCustomer = new Customer();
            newCustomer.setUsernameCustomer(customer.getUsernameCustomer());
            newCustomer.setEmailCustomer(customer.getEmailCustomer());
            newCustomer.setPasswordCustomer (customer.getPasswordCustomer());
            newCustomer.setRoleCustomer(1);

            return Optional.of(customerRepo.save(newCustomer));
        }
    }
    
}
