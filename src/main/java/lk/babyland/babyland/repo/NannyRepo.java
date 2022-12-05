package lk.babyland.babyland.repo;

import lk.babyland.babyland.entity.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository

public interface NannyRepo extends CrudRepository <Nanny, Long> {
    Optional<Nanny> findByNannyNic(final String nannyNic);

    Optional<Nanny> findByAvailability(String availability);
    
}
