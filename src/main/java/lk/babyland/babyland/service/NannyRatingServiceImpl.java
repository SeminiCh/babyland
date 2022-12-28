package lk.babyland.babyland.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.babyland.babyland.dto.CreateNannyRating;
import lk.babyland.babyland.entity.Customer;
import lk.babyland.babyland.entity.Nanny;
import lk.babyland.babyland.entity.NannyRating;
import lk.babyland.babyland.repo.NannyRatingRepo;

@Service
public class NannyRatingServiceImpl implements NannyRatingService {

    @Autowired
    private NannyRatingRepo nannyRatingRepo;

    @Autowired
    private NannyService nannyService;

    @Autowired
    private CustomerService customerService;

    @Override
    public Iterable<NannyRating> allNannyRating() {
        return nannyRatingRepo.findAll();
    }

    @Override
    public Optional<NannyRating> saveNannyRating(CreateNannyRating nannyRating) {
        Optional<Nanny> foundNanny = this.nannyService.getNannyByNic(nannyRating.getNannyNic());

        if(foundNanny.isEmpty()) {
            System.out.println("Not Found Nannyt");
            return Optional.empty();
        }

        Optional<Customer> foundCustomer = this.customerService.getCustomerByUsername(nannyRating.getUsernameCustomer());

        if(foundCustomer.isEmpty()) {
            System.out.println("Not Found Customer");
            return Optional.empty();
        }

        NannyRating newNannyRating = new NannyRating();
            newNannyRating.setPuntualityRating(nannyRating.getPuntualityRating());
            newNannyRating.setKindnessRating(nannyRating.getKindnessRating());
            newNannyRating.setCommunicationRating(nannyRating.getCommunicationRating());
            newNannyRating.setRatingValue(nannyRating.getRatingValue());
            newNannyRating.setRatingComment(nannyRating.getRatingComment());
            newNannyRating.setNanny(foundNanny.get());
            newNannyRating.setCustomer(foundCustomer.get());

            return Optional.of(nannyRatingRepo.save(newNannyRating));
    }
    
}
