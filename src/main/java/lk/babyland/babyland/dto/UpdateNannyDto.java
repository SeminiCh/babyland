package lk.babyland.babyland.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class UpdateNannyDto {
    private long id;
    private String nannyFullName;
    private String nannyNic;
    private int nannyAge;
    private String nannyReligion;
    private String nannyNationality;
    private int nannyWeight;
    private int nannyHeight;
    private String nannyLeavePreferences;
    private String nannyLanguage1;
    private String nannyLanguage2;
    private String nannyLanguage3;
    private String nannyWorkingHours;
    private String nannyPreparingChildMeal;
    private String nannyQualification;
    private String nannyQualificationFile;
    private String nannyImage;
    private String nannyVegetaian;
    private String nannyPetLover;
    private String availability;
    private String nannyEthniity;
    private String nannyPrefferedDistrict1;
    private String nannyPrefferedDistrict2;
    private String nannyImg;
    private String nannyQulFile;
    private String nannyDifferentlyAbledCare;
    public String agentCompanyName;

}
