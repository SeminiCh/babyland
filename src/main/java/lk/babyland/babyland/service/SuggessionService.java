package lk.babyland.babyland.service;

import java.util.Optional;

import lk.babyland.babyland.dto.CreateSuggestionDto;
import lk.babyland.babyland.entity.Suggestions;

public interface SuggessionService {
    Iterable<Suggestions> allSuggestionss();

    Optional<Suggestions> saveSuggestion(final CreateSuggestionDto suggestions);
    
}
