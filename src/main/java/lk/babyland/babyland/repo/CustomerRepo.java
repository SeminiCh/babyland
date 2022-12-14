package lk.babyland.babyland.repo;

import lk.babyland.babyland.entity.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository

public interface CustomerRepo extends CrudRepository <Customer, Long> {
    Optional<Customer> findByUsernameCustomer (final String usernameCustomer);
    Optional <Customer> findByUsernameCustomerAndPasswordCustomer(String usernameCustomer, String passwordCustomer);
    
}
