package lk.babyland.babyland.repo;

import lk.babyland.babyland.entity.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface NannyRatingRepo extends CrudRepository<NannyRating, Long> {
    Optional<NannyRating> findById (final Long id);
    
}
