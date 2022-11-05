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
    private String parentAddress;
    private String parentPhoneMoile;
    private String parentNic;
    private String parentBabyAge;
    private String parentNicCopy;
}
