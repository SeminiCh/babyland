package lk.babyland.babyland.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;


import lk.babyland.babyland.dto.CreateCustomerDto;
import lk.babyland.babyland.dto.GetPasswordDto;
import lk.babyland.babyland.dto.GetUsernameDto;
import lk.babyland.babyland.entity.Customer;
import lk.babyland.babyland.service.CustomerService;
import lk.babyland.babyland.repo.CustomerRepo;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/api/v1/customer")

public class CustomerController {

    @Autowired
    private CustomerRepo customerRepo;

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

    @GetMapping( "getAllUsernames")
    public List<GetUsernameDto> findUserNames(){
        List<GetUsernameDto> userNameList = new ArrayList<>();
        try {
            List<Customer> userList = (List<Customer>) customerRepo.findAll();
            for (Customer customer: userList) {
                userNameList.add(new GetUsernameDto(customer.getUsernameCustomer()));
            }
        }catch (Exception e){
            System.out.println("Exception in find Usernames in User Controller");
        }
        return userNameList;
    }

    
    @GetMapping( value = "/getAllUserPasswords" , produces = APPLICATION_JSON_VALUE)
    public List<GetPasswordDto> findUserPasswords(){
        List<GetPasswordDto> userPasswordList = new ArrayList<>();
        try {
            List<Customer> userList = (List<Customer>) customerRepo.findAll();
            for (Customer customer: userList) {
                userPasswordList.add(new GetPasswordDto(customer.getPasswordCustomer()));
            }
        }catch (Exception e){
            System.out.println("Exception in find Passwords in User Controller");
        }
        return userPasswordList;
    }

}
