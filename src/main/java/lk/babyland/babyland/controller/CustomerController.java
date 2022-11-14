package lk.babyland.babyland.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import lk.babyland.babyland.dto.CreateCustomerDto;
import lk.babyland.babyland.entity.Customer;
import lk.babyland.babyland.service.CustomerService;

import java.util.Optional;

@CrossOrigin
@Controller
@RequestMapping("/api/v1/customer")

public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("")
    public ResponseEntity<Iterable<Customer>> getAllCustomers() {

        return new ResponseEntity<>(customerService.allCustomers(), HttpStatus.ACCEPTED);
    }

    @PostMapping("save")
    public ResponseEntity<Optional<Customer>> saveCustomer(@RequestBody CreateCustomerDto customerInfo) {

        Optional<Customer> savedCustomer = this.customerService.saveCustomer(customerInfo);

        if(savedCustomer.isPresent()) {
            return new ResponseEntity<>(this.customerService.saveCustomer(customerInfo), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(this.customerService.saveCustomer(customerInfo), HttpStatus.BAD_REQUEST);
    }
}
