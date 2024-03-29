package lk.babyland.babyland.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.babyland.babyland.dto.CreateAgentDto;
import lk.babyland.babyland.entity.Agent;
import lk.babyland.babyland.repo.AgentRepo;

@Service
public class AgentServiceImpl implements AgentService {

    @Autowired
    private AgentRepo agentRepo;

    @Override
    public Iterable<Agent> allAgents() {
        return agentRepo.findAll();
    }

    @Override
    public Optional<Agent> getAgentByCompanyName(String AgentCompanyName) {
        return agentRepo.findByAgentCompanyName(AgentCompanyName);
    }

    @Override
    public Optional<Agent> saveAgent(CreateAgentDto agent) {
        
        Optional<Agent> foundAgent = this.agentRepo.findByAgentCompanyName(agent.getAgentCompanyName());
        
        if(foundAgent.isPresent()) {
            System.out.println("Agent is Added");
            return Optional.empty();

            
        }
        Agent newAgent = new Agent();
            newAgent.setAgentCompanyName(agent.getAgentCompanyName());
            newAgent.setAgentPassword (agent.getAgentPassword());
            newAgent.setAgentEmployeeName(agent.getAgentEmployeeName());
            newAgent.setAgentCompanyPhone(agent.getAgentCompanyPhone());
            newAgent.setAgentPersonPhone(agent.getAgentPersonPhone());
            newAgent.setAgentPersonEmail(agent.getAgentPersonEmail());
            newAgent.setAgentPersonDesignation(agent.getAgentPersonDesignation());
            newAgent.setAgentLiFile(agent.getAgentLiFile());
            newAgent.setAgentOfficerImg(agent.getAgentOfficerImg());
            newAgent.setAgentCompanyAddress(agent.getAgentCompanyAddress());
            newAgent.setAgentPersonNic(agent.getAgentPersonNic());
            newAgent.setAgentRole(2);
            
            return Optional.of(agentRepo.save(newAgent));
    }

    @Override
    public Optional<Agent> removeAgentByAgentCompanyName(String agentCompanyName) {
        Optional<Agent> foundAgent = this.getAgentByCompanyName(agentCompanyName);
        if(foundAgent.isEmpty()) {
            return Optional.empty();
        }
        agentRepo.delete(foundAgent.get());
        return foundAgent;
    }
    
}
