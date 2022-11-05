package lk.babyland.babyland.service;

import lk.babyland.babyland.entity.Agent;
import lk.babyland.babyland.dto.CreateAgentDto;
import java.util.Optional;

public interface AgentService {
    Iterable<Agent> allAgents();

    Optional<Agent> getAgentByCompanyName(final String AgentCompanyName);

    Optional<Agent> saveAgent(final CreateAgentDto agent);
    
}
