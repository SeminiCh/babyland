package lk.babyland.babyland.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import lk.babyland.babyland.dto.CreateAgentDto;
import lk.babyland.babyland.entity.Agent;
import lk.babyland.babyland.service.AgentService;
import java.util.Optional;

@CrossOrigin
@Controller
@RequestMapping("/api/v1/agent")

public class AgentController {

    @Autowired
    private AgentService agentService;

    @PostMapping("")
    public ResponseEntity<Iterable<Agent>> getAllAgents(){
        return new ResponseEntity<>(agentService.allAgents(), HttpStatus.ACCEPTED);
    }

    @PostMapping("save")
    public ResponseEntity<Optional<Agent>> saveAgent(@RequestBody CreateAgentDto agentInfo) {

        Optional<Agent> savedAgent = this.agentService.saveAgent(agentInfo);

        if(savedAgent.isPresent()) {
            return new ResponseEntity<>(this.agentService.saveAgent(agentInfo), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(this.agentService.saveAgent(agentInfo), HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("delete/{agentCompanyName}")
    public ResponseEntity<Optional<Agent>> removeAgentByAgentCompanyName(@PathVariable String agentCompanyName) {
        Optional<Agent> deletedAgent = agentService.removeAgentByAgentCompanyName(agentCompanyName);

        if(deletedAgent.isEmpty()) {
            return new ResponseEntity<>(deletedAgent, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(deletedAgent, HttpStatus.ACCEPTED);
    }
    
}
