package lk.babyland.babyland.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import lk.babyland.babyland.dto.CreateLoginDto;
import lk.babyland.babyland.entity.Customer;
import lk.babyland.babyland.service.LoginService;

@CrossOrigin
@Controller
@RequestMapping("/api/v1/login")
public class LoginController {

    @Autowired
    private LoginService loginService;


    @PostMapping("/customerlogin")
    public ResponseEntity<Optional<Customer>> loginCustomer(@RequestBody CreateLoginDto loginInfo) {
        Optional <Customer> isCustomer = this.loginService.login(loginInfo.getUsernameCustomer(), loginInfo.getPasswordCustomer());

        return new ResponseEntity<>(isCustomer, HttpStatus.OK);
        
    }
    // public String login(@ModelAttribute("customer") Customer customer){
    //     Customer oauthCustomer = loginService.login(customer.getUsernameCustomer(), customer.getPasswordCustomer());

    //     System.out.print(oauthCustomer);
    //     if(Objects.nonNull(oauthCustomer)){
    //         return "redirect:/";
    //     }
    //     else{
    //         return "redirect:/login";
    //     }
    // }

    
}

