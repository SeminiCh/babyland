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
    private String nannyLanguages;
    private String nannyWorkingHours;
    private String nannyQualification;
    private String nannyQualificationFile;
    private String nannyImage;
    private String nannyVegetaian;
    private String nannyPetLover;
    private String availability;
    private String nannyDifferentlyAbledCare;
    @ManyToOne(fetch = FetchType.EAGER)
    private Agent agent;



    
}
