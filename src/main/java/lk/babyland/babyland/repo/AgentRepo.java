package lk.babyland.babyland.repo;

import lk.babyland.babyland.entity.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AgentRepo extends CrudRepository<Agent, Long>{
    Optional<Agent> findByAgentCompanyName(final String agentCompanyName);
    
}
