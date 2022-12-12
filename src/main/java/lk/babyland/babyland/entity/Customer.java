package lk.babyland.babyland.entity;
import lombok.*;

import javax.persistence.*;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String usernameCustomer;
    private String emailCustomer;
    private String passwordCustomer;
    
    
}
