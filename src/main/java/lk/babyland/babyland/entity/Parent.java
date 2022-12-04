package lk.babyland.babyland.entity;
import lombok.*;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter

public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String parentFullName;
    private String parentRelationshipToBaby;
    private String parentOccupation;
    private String parentOccupationFather;
    private String parentAddress;
    private String parentCity;
    private String parentPhoneMoile;
    private String parentNic;
    private String parentBabbiesCount;
    private String parentBabyAge;
    private String parentNicCopy;
    private String parentImage;
    @Column(name = "parentImg", columnDefinition = "longtext")
    private String parentImg;
    @Column(name = "parentNCopy", columnDefinition = "longtext")
    private String parentNCopy;
    private String parentBabySpecialCare;

    @ManyToOne(fetch = FetchType.EAGER)
    private Nanny nanny;
    @ManyToOne(fetch = FetchType.EAGER)
    private Customer customer;
}
