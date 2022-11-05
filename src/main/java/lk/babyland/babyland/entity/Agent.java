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
    private String agentLicenceFile;

}
