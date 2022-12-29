package lk.babyland.babyland.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.babyland.babyland.dto.CreateSuggestionDto;
import lk.babyland.babyland.entity.Suggestions;
import lk.babyland.babyland.repo.SuggestionRepo;

@Service
public class SuggestionsServiceImpl implements SuggessionService{

    @Autowired
    private SuggestionRepo suggestionRepo;

    @Override
    public Iterable<Suggestions> allSuggestionss() {
        return suggestionRepo.findAll();
    }

    @Override
    public Optional<Suggestions> saveSuggestion(CreateSuggestionDto suggestions) {

        Suggestions newSuggestion = new Suggestions();
        newSuggestion.setSuggestionComment(suggestions.getSugessionComment());

        return Optional.of(suggestionRepo.save(newSuggestion));
        
    }
    
}
