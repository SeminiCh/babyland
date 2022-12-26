package lk.babyland.babyland.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.babyland.babyland.dto.CreateNannyRating;
import lk.babyland.babyland.entity.NannyRating;
import lk.babyland.babyland.repo.NannyRatingRepo;

@Service
public class NannyRatingServiceImpl implements NannyRatingService {

    @Autowired
    private NannyRatingRepo nannyRatingRepo;

    @Override
    public Iterable<NannyRating> allNannyRating() {
        return nannyRatingRepo.findAll();
    }

    @Override
    public Optional<NannyRating> saveNannyRating(CreateNannyRating nannyRating) {
        Optional<NannyRating> foundNannyRating = this.nannyRatingRepo.findById(nannyRating.getId());
        
        if(foundNannyRating.isPresent()) {
            System.out.println("Username is not available");
            return Optional.empty();

        }
        else{
            NannyRating newNannyRating = new NannyRating();
            newNannyRating.setPuntualityRating(nannyRating.getPuntualityRating());
            newNannyRating.setKindnessRating(nannyRating.getKindnessRating());
            newNannyRating.setCommunicationRating(nannyRating.getCommunicationRating());
            newNannyRating.setRatingValue(nannyRating.getRatingValue());
            newNannyRating.setRatingComment(nannyRating.getRatingComment());

            return Optional.of(nannyRatingRepo.save(newNannyRating));
        }
    }
    
}
