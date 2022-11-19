package lk.babyland.babyland.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.babyland.babyland.repo.ParentRepo;
import lk.babyland.babyland.dto.CreateParentDto;
import lk.babyland.babyland.entity.Nanny;
import lk.babyland.babyland.entity.Parent;


@Service
public class ParentServiceImpl implements ParentService {
    
    @Autowired
    private ParentRepo parentRepo;

    @Autowired
    private NannyService nannyService;
    
    @Override
    public Iterable<Parent> allParents() {
        return parentRepo.findAll();
    }

    @Override
    public Optional<Parent> getParentByNic(String parentNic) {
        return parentRepo.findByParentNic(parentNic);
    }
    
    @Override
    public Optional<Parent> saveParent(CreateParentDto parent) {

        Optional<Nanny> foundNanny = this.nannyService.getNannyByNic(parent.getNannyNic());

        if(foundNanny.isEmpty()) {
            System.out.println("Not Found Nanny");
            return Optional.empty();
        }
    
        
        Optional<Parent> foundParent = this.parentRepo.findByParentNic(parent.getParentNic());
        
        if(foundParent.isPresent()) {
            System.out.println("Parent already Added");
            return Optional.empty();
        }

        Parent newParent = new Parent();
        newParent.setParentFullName(parent.getParentFullName());
        newParent.setParentAddress(parent.getParentAddress());
        newParent.setParentBabyAge(parent.getParentBabyAge());
        newParent.setParentNic(parent.getParentNic());
        newParent.setParentPhoneMoile(parent.getParentPhoneMoile());
        newParent.setParentRelationshipToBaby(parent.getParentRelationshipToBaby());
        newParent.setParentNicCopy(parent.getParentNicCopy());

        newParent.setNanny(foundNanny.get());
        
        return Optional.of(parentRepo.save(newParent));

    }
}
