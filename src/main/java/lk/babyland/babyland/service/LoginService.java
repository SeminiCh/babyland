package lk.babyland.babyland.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.babyland.babyland.entity.Customer;
import lk.babyland.babyland.repo.CustomerRepo;

@Service
public class LoginService {
    @Autowired
    private CustomerRepo loginRepo;

    public Optional<Customer> login(String usernameCustomer, String PasswordCustomer){
        Optional<Customer> customer = loginRepo.findByUsernameCustomerAndPasswordCustomer(usernameCustomer, PasswordCustomer);
        return customer;
    }
}
