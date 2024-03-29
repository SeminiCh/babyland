package lk.babyland.babyland.service;

import lk.babyland.babyland.entity.Nanny;
import lk.babyland.babyland.dto.CreateNannyDto;
import lk.babyland.babyland.dto.UpdateNannyDto;
import lk.babyland.babyland.dto.UpdateNannyStatus;

import java.util.Optional;


public interface NannyService {
    Iterable<Nanny> allNannies();

    Optional<Nanny> getNannyByNic(final String nannyNic);

    Optional<Nanny> getNannyByAvailability(final String availability);

    Optional<Nanny> saveNanny(final CreateNannyDto nanny);

    Nanny updateNannyById(final UpdateNannyDto updatedNanny);

    Optional<Nanny> removeNannyByNannyNIC(final String nannyNic);

    Nanny updateNanny( Nanny nanny, String nannyNic);
    Nanny updateNannyStatus(UpdateNannyStatus updateNannyStatus);
    Nanny updateCompleteNanny( Nanny nanny, String nannyNic);
    
}
