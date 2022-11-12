package lk.babyland.babyland.service;

import lk.babyland.babyland.entity.Nanny;
import lk.babyland.babyland.dto.CreateNannyDto;
import java.util.Optional;


public interface NannyService {
    Iterable<Nanny> allNannies();

    Optional<Nanny> getNannyByNic(final String nannyNic);

    Optional<Nanny> saveNanny(final CreateNannyDto nanny);
    
}
