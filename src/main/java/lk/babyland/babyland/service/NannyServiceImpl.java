package lk.babyland.babyland.service;

import lk.babyland.babyland.entity.Nanny;
import lk.babyland.babyland.repo.NannyRepo;
import lk.babyland.babyland.entity.Agent;
import lk.babyland.babyland.dto.CreateNannyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;


@Service
public class NannyServiceImpl implements NannyService {

    @Autowired
    private NannyRepo nannyRepo;
    private AgentService agentService;
    
    @Override
    public Iterable<Nanny> allNannies() {
        
        return nannyRepo.findAll();
    }

    @Override
    public Optional<Nanny> getNannyById(Long id) {
        
        return nannyRepo.findById(id);

    }

    @Override
    public Optional<Nanny> saveNanny(CreateNannyDto nanny) {

        Optional<Agent> foundAgent = this.agentService.getAgentByCompanyName(nanny.getAgentCompanyName());

        if(foundAgent.isEmpty()) {
            System.out.println("Not Found Agent");
            return Optional.empty();
        }
    
        
        Optional<Nanny> foundNanny = this.nannyRepo.findByNannyNic(nanny.getNannyNic());
        
        if(foundNanny.isPresent()) {
            System.out.println("Nanny already Added");
            return Optional.empty();
        }

        Nanny newNanny = new Nanny();
        newNanny.setNannyFullName(nanny.getNannyFullName());
        newNanny.setNannyAge(nanny.getNannyAge());
        newNanny.setNannyHeight(nanny.getNannyHeight());
        newNanny.setNannyWeight(nanny.getNannyWeight());
        newNanny.setNannyNic(nanny.getNannyNic());
        newNanny.setNannyReligion(nanny.getNannyReligion());
        newNanny.setNannyNationality(nanny.getNannyNationality());
        newNanny.setNannyLeavePreferences(nanny.getNannyLeavePreferences());
        newNanny.setNannyLanguages(nanny.getNannyLanguages());
        newNanny.setNannyQualification(nanny.getNannyQualification());
        newNanny.setNannyWorkingHours(nanny.getNannyWorkingHours());
        newNanny.setNannyQualificationFile(nanny.getNannyQualificationFile());
        newNanny.setNannyImage(nanny.getNannyImage());
        newNanny.setNannyVegetaian(nanny.getNannyVegetaian());
        newNanny.setNannyPetLover(nanny.getNannyPetLover());
        newNanny.setNannyDifferentlyAbledCare(nanny.getNannyDifferentlyAbledCare());
        newNanny.setAgent(foundAgent.get());
        
        return Optional.of(nannyRepo.save(newNanny));

    }
    
    
}
