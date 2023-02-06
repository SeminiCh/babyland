package lk.babyland.babyland.dto;

import lombok.*;



@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter

public class CreateCustomerDto {
    private String usernameCustomer;
    private String emailCustomer;
    private String passwordCustomer;
    private int roleCustomer;
    
}
