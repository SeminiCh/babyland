package lk.babyland.babyland.dto;
import lombok.*;



@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter

public class CreateAgentLoginDto {
    private String agentCompanyName;
    private String agentPassword;
}
