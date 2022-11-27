package lk.babyland.babyland.service;
import java.util.Optional;

import lk.babyland.babyland.dto.CreateAgentPhotoDto;
import lk.babyland.babyland.entity.AgentPhoto;

public interface AgentPhotoService {
    Optional<AgentPhoto> saveAgentPhoto (final CreateAgentPhotoDto agentPhoto);
    
}
