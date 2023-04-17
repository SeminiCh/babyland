package lk.babyland.babyland.dto;
import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter

public class CreateSpecialDto {
    private String specialFullName;
    
    private String specialAddress;
    
    private String specialPhoneMobile;
    
    private String specialNote;
    
    private String specialContractTime;
}
