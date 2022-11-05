package lk.babyland.babyland.dto;


import lombok.*;



@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter

public class CreateAgentDto {
    private String agentCompanyName;
    private String agentPassword;
    private String agentLicenceFile;
}
