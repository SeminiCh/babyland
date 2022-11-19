package lk.babyland.babyland.repo;

import lk.babyland.babyland.entity.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository

public interface SuggestionRepo extends CrudRepository<Suggestions, Long> {
    Optional<Suggestions> findById (final Long id);
    
}
