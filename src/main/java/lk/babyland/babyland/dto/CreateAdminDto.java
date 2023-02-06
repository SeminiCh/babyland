package lk.babyland.babyland.dto;

import lombok.*;



@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter

public class CreateAdminDto {
    private String usernameAdmin;
    private String emailAdmin;
    private String passwordAdmin;
    private int roleAdmin;
    
}
