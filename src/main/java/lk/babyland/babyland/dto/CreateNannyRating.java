package lk.babyland.babyland.dto;

import lombok.*;



@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter

public class CreateNannyRating {
    private int ratingValue;
    private int puntualityRating;
    private int communicationRating;
    private int kindnessRating;


    private String ratingComment;

    private String nannyNic;
    
    private String usernameCustomer;
}
