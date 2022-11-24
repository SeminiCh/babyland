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
    private String agentEmployeeName;
    private String agentCompanyPhone;
    private String agentPersonPhone;
    private String agentPersonEmail;
    private String agentPersonDesignation;
    private String agentPersonNic;
    private String agentPersonImage;
}
