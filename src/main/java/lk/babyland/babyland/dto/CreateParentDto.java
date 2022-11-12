package lk.babyland.babyland.dto;
import lombok.*;



@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter

public class CreateParentDto {
    private String parentFullName;
    private String parentRelationshipToBaby;
    private String parentAddress;
    private String parentPhoneMoile;
    private String parentNic;
    private String parentBabyAge;
    private String parentNicCopy;

    private String nannyNic;
}
