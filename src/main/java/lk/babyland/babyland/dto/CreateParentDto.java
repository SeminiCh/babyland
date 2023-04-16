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
    private String parentOccupation;
    private String parentOccupationFather;
    private String parentAddress;
    private String parentCity;
    private String parentPhoneMoile;
    private String parentNic;
    private String parentBabbiesCount;
    private String parentImage;
    private String parentImg;
    private String parentNCopy;
    private String parentBabySpecialCare;
    private String parentBabyAge;
    private String parentNicCopy;
    private String parentMonth;
    private String parentYear;
    private String parentTime;

    private String nannyNic;
    private String usernameCustomer;
}
