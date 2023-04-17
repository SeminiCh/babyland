package lk.babyland.babyland.service;

import lk.babyland.babyland.dto.CreateSpecialDto;
import lk.babyland.babyland.entity.SpecialRequest;
import java.util.Optional;

public interface SpecialService {
    Iterable<SpecialRequest> allSpecialRequests();
    Optional<SpecialRequest> saveRequest(final CreateSpecialDto specialRequest);
}
