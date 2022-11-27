package lk.babyland.babyland.entity;
import lombok.*;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Table (name = "AgentPhoto")
@Data 

public class AgentPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String apName;
    private String filePath;


    
}
