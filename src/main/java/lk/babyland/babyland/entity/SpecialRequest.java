package lk.babyland.babyland.entity;
import lombok.*;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter

public class SpecialRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String specialFullName;
    
    private String specialAddress;
    
    private String specialPhoneMobile;
    
    private String specialNote;
    
    private String specialContractTime;
    
}
