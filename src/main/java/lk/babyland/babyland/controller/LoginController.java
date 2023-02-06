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

import lk.babyland.babyland.dto.CreateAgentLoginDto;
import lk.babyland.babyland.dto.CreateLoginDto;
import lk.babyland.babyland.entity.Agent;
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
        Optional <Customer> foundCustomer = this.loginService.login(loginInfo.getUsernameCustomer(), loginInfo.getPasswordCustomer());

        if(foundCustomer.isPresent()){
            return new ResponseEntity<>(foundCustomer, HttpStatus.OK);
        }

        else{
            return new ResponseEntity<>(foundCustomer,HttpStatus.UNAUTHORIZED);
        }
        
        
    }

    @PostMapping("/agentlogin")
    public ResponseEntity<Optional<Agent>> loginAgent(@RequestBody CreateAgentLoginDto loginInfo) {
        Optional <Agent> foundAgent = this.loginService.loginAgent(loginInfo.getAgentCompanyName(), loginInfo.getAgentPassword());

        if(foundAgent.isPresent()){
            return new ResponseEntity<>(foundAgent, HttpStatus.OK);
        }

        else{
            return new ResponseEntity<>(foundAgent,HttpStatus.UNAUTHORIZED);
        }
        
        
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

