package lk.babyland.babyland.service;

import lk.babyland.babyland.dto.CreateNannyRating;
import lk.babyland.babyland.entity.NannyRating;
import java.util.Optional;

public interface NannyRatingService {
    Iterable<NannyRating> allNannyRating();

    Optional<NannyRating> saveNannyRating(final CreateNannyRating nannyRating);
    
}
