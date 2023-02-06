package lk.babyland.babyland.entity;
import lombok.*;

import javax.persistence.*;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter

public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String agentCompanyName;
    private String agentPassword;
    @Column(name = "agentLiFile", columnDefinition = "longtext")
    private String agentLiFile;
    @Column(name = "agentOfficerImg", columnDefinition = "longtext")
    private String agentOfficerImg;
    private String agentLicenceFile;

    private String agentEmployeeName;
    private String agentCompanyPhone;
    private String agentPersonPhone;
    private String agentPersonEmail;
    private String agentPersonDesignation;
    private String agentPersonNic;
    private String agentCompanyAddress;
    private String agentPersonImage;
    private int agentRole;


}
