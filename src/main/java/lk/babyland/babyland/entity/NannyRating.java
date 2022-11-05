package lk.babyland.babyland.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class NannyRating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int ratingValue;

    private String ratingComment;

    @ManyToOne(fetch = FetchType.EAGER)
    private Nanny nannyNic;

    
}
