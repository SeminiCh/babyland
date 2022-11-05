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
    private String nannyFullName;
    private int nannyAge;
    private String nannyReligion;
    private String nannyNationality;
    private int nannyWeight;
    private int nannyHeight;
    private String nannyLeavePreferences;
    private String nannyLanguages;
    private String nannyExperience;
    private String nannyWorkingHours;
    private String nannyQualification;
    private String nannyQualificationFile;
    private String nannyImage;
    private String nannyVegetaian;
    private String nannyVegetarian;
    private String nannyPetLover;
    private String nannyDifferentlyAbledCare;
    
}
