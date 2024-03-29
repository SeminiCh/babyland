package lk.babyland.babyland.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.babyland.babyland.repo.ParentRepo;
import lk.babyland.babyland.dto.CreateParentDto;
import lk.babyland.babyland.entity.Customer;
import lk.babyland.babyland.entity.Nanny;
import lk.babyland.babyland.entity.Parent;


@Service
public class ParentServiceImpl implements ParentService {
    
    @Autowired
    private ParentRepo parentRepo;

    @Autowired
    private NannyService nannyService;

    @Autowired
    private CustomerService customerService;
    
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

        Optional<Customer> foundCustomer = this.customerService.getCustomerByUsername(parent.getUsernameCustomer());

        if(foundCustomer.isEmpty()) {
            System.out.println("Not Found Customer");
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
        newParent.setParentOccupation(parent.getParentOccupation());
        newParent.setParentCity(parent.getParentCity());
        newParent.setParentBabbiesCount(parent.getParentBabbiesCount());
        newParent.setParentImage(parent.getParentImage());
        newParent.setParentBabySpecialCare(parent.getParentBabySpecialCare());
        newParent.setParentBabyAge(parent.getParentBabyAge());
        newParent.setParentNic(parent.getParentNic());
        newParent.setParentImg(parent.getParentImg());
        newParent.setParentNCopy(parent.getParentNCopy());
        newParent.setParentPhoneMoile(parent.getParentPhoneMoile());
        newParent.setParentOccupationFather(parent.getParentOccupationFather());
        newParent.setParentRelationshipToBaby(parent.getParentRelationshipToBaby());
        newParent.setParentNicCopy(parent.getParentNicCopy());
        newParent.setParentMonth(parent.getParentMonth());
        newParent.setParentYear(parent.getParentYear());
        newParent.setParentTime(parent.getParentTime());
        newParent.setParentStatus(parent.getParentStatus());

        newParent.setNanny(foundNanny.get());
        newParent.setCustomer(foundCustomer.get());
        
        return Optional.of(parentRepo.save(newParent));

    }
}
