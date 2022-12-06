package lk.babyland.babyland.service;

import lk.babyland.babyland.entity.Nanny;
import lk.babyland.babyland.repo.NannyRepo;
import lk.babyland.babyland.entity.Agent;
import lk.babyland.babyland.dto.CreateNannyDto;
import lk.babyland.babyland.dto.DeleteNannyDto;
import lk.babyland.babyland.dto.UpdateNannyDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;


@Service
public class NannyServiceImpl implements NannyService {

    @Autowired
    private NannyRepo nannyRepo;
    @Autowired
    private AgentService agentService;
    
    @Override
    public Iterable<Nanny> allNannies() { 
        return nannyRepo.findAll();
    }

    @Override
    public Optional<Nanny> getNannyByNic(String nannyNic) {
        return nannyRepo.findByNannyNic(nannyNic);
    }

    @Override
    public Optional<Nanny> getNannyByAvailability(String availability) {
        return nannyRepo.findByAvailability("Yes");
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
        newNanny.setNannyLanguage1(nanny.getNannyLanguage1());
        newNanny.setNannyLanguage2(nanny.getNannyLanguage2());
        newNanny.setNannyLanguage3(nanny.getNannyLanguage3());
        newNanny.setNannyEthniity(nanny.getNannyEthnicity());
        newNanny.setNannyPreparingChildMeal(nanny.getNannyPreparingChildMeal());
        newNanny.setNannyQualification(nanny.getNannyQualification());
        newNanny.setNannyWorkingHours(nanny.getNannyWorkingHours());
        newNanny.setNannyQualificationFile(nanny.getNannyQualificationFile());
        newNanny.setNannyImg(nanny.getNannyImg());
        newNanny.setNannyQulFile(nanny.getNannyQulFile());
        newNanny.setNannyVegetaian(nanny.getNannyVegetaian());
        newNanny.setNannyPetLover(nanny.getNannyPetLover());
        newNanny.setAvailability(nanny.getAvailability());
        newNanny.setNannyPrefferedDistrict1(nanny.getNannyPrefferedDistrict1());
        newNanny.setNannyPrefferedDistrict2(nanny.getNannyPrefferedDistrict2());
        newNanny.setNannyDifferentlyAbledCare(nanny.getNannyDifferentlyAbledCare());
        newNanny.setAgent(foundAgent.get());
        
        return Optional.of(nannyRepo.save(newNanny));

    }

    @Override
    public Nanny updateNannyById(UpdateNannyDto nanny) {
        Optional<Nanny> foundNanny = this.nannyRepo.findByNannyNic(nanny.getNannyNic());

        if(foundNanny.isEmpty()) {
            return new Nanny();
        }

        Optional<Agent> foundAgent = this.agentService.getAgentByCompanyName(nanny.getAgentCompanyName());

        if(foundAgent.isEmpty()) {
            return new Nanny();
        }

        Nanny newNanny = new Nanny();
        newNanny.setId(nanny.getId());
        newNanny.setNannyFullName(nanny.getNannyFullName());
        newNanny.setNannyAge(nanny.getNannyAge());
        newNanny.setNannyHeight(nanny.getNannyHeight());
        newNanny.setNannyWeight(nanny.getNannyWeight());
        newNanny.setNannyNic(nanny.getNannyNic());
        newNanny.setNannyReligion(nanny.getNannyReligion());
        newNanny.setNannyNationality(nanny.getNannyNationality());
        newNanny.setNannyLeavePreferences(nanny.getNannyLeavePreferences());
        newNanny.setNannyLanguage1(nanny.getNannyLanguage1());
        newNanny.setNannyLanguage2(nanny.getNannyLanguage2());
        newNanny.setNannyLanguage3(nanny.getNannyLanguage3());
        newNanny.setNannyEthniity(nanny.getNannyEthniity());
        newNanny.setNannyPreparingChildMeal(nanny.getNannyPreparingChildMeal());
        newNanny.setNannyQualification(nanny.getNannyQualification());
        newNanny.setNannyWorkingHours(nanny.getNannyWorkingHours());
        newNanny.setNannyQualificationFile(nanny.getNannyQualificationFile());
        newNanny.setNannyImg(nanny.getNannyImg());
        newNanny.setNannyQulFile(nanny.getNannyQulFile());
        newNanny.setNannyVegetaian(nanny.getNannyVegetaian());
        newNanny.setNannyPetLover(nanny.getNannyPetLover());
        newNanny.setAvailability(nanny.getAvailability());
        newNanny.setNannyPrefferedDistrict1(nanny.getNannyPrefferedDistrict1());
        newNanny.setNannyPrefferedDistrict2(nanny.getNannyPrefferedDistrict2());
        newNanny.setNannyDifferentlyAbledCare(nanny.getNannyDifferentlyAbledCare());
        newNanny.setAgent(foundAgent.get());

        System.out.println("hh");
        return this.nannyRepo.save(newNanny);
    }


    @Override
    public Boolean removeNannyByNannyNIC(DeleteNannyDto nannyDto) {
        Optional<Nanny> foundNanny = this.nannyRepo.findByNannyNic(nannyDto.getNannyNic());

        if(foundNanny.isEmpty()) {
            return false;
        }

        try {
            this.nannyRepo.delete(foundNanny.get());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;

    }

    

    
    
    
}
