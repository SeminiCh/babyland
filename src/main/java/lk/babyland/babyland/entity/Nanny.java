package lk.babyland.babyland.entity;
import lombok.*;

import javax.persistence.*;



@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter

public class Nanny {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @Column(name = "nannyImg", columnDefinition = "longtext")
    private String nannyImg;
    @Column(name = "nannyQulFile", columnDefinition = "longtext")
    private String nannyQulFile;
    private String nannyDifferentlyAbledCare;
    @ManyToOne(fetch = FetchType.EAGER)
    private Agent agent;



    
}
