package lk.babyland.babyland.service;

import lk.babyland.babyland.dto.CreateParentDto;
import lk.babyland.babyland.entity.Parent;
import java.util.Optional;

public interface ParentService {
    Iterable<Parent> allParents();

    Optional<Parent> getParentByNic(final String parentNic);

    Optional<Parent> saveParent(final CreateParentDto parent);
    
}
