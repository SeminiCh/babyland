package lk.babyland.babyland.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.babyland.babyland.dto.CreateSpecialDto;
import lk.babyland.babyland.entity.SpecialRequest;
import lk.babyland.babyland.repo.SpecialRepo;

@Service
public class SpecialServiceImpl implements SpecialService{
    @Autowired
    private SpecialRepo specialRepo;

    @Override
    public Iterable<SpecialRequest> allSpecialRequests(){
        return specialRepo.findAll();
    }

    @Override
    public Optional<SpecialRequest> saveRequest(CreateSpecialDto specialRequest) {

        SpecialRequest newSpecialRequest = new SpecialRequest();
        newSpecialRequest.setSpecialFullName(specialRequest.getSpecialFullName());
        newSpecialRequest.setSpecialAddress(specialRequest.getSpecialAddress());
        newSpecialRequest.setSpecialContractTime(specialRequest.getSpecialContractTime());
        newSpecialRequest.setSpecialNote(specialRequest.getSpecialPhoneMobile());
        newSpecialRequest.setSpecialNote(specialRequest.getSpecialNote());
        
        return Optional.of(specialRepo.save(newSpecialRequest));
        

        
        
    }

    
}
