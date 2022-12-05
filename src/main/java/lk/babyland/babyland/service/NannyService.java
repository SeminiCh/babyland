package lk.babyland.babyland.service;

import lk.babyland.babyland.entity.Nanny;
import lk.babyland.babyland.dto.CreateNannyDto;
import lk.babyland.babyland.dto.DeleteNannyDto;
import lk.babyland.babyland.dto.UpdateNannyDto;

import java.util.Optional;


public interface NannyService {
    Iterable<Nanny> allNannies();

    Optional<Nanny> getNannyByNic(final String nannyNic);

    Optional<Nanny> getNannyByAvailability(final String availability);

    Optional<Nanny> saveNanny(final CreateNannyDto nanny);

    Nanny updateNannyById(final UpdateNannyDto updatedNanny);

    Boolean removeNannyByNannyNIC(final DeleteNannyDto nannyDto);
    
}
