package lk.babyland.babyland.entity;
import lombok.*;

import javax.persistence.*;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter

public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String usernameAdmin;
    private String emailAdmin;
    private String passwordAdmin;
    private int roleAdmin;
    
    
}
