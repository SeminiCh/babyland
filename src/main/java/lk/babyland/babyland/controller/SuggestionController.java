package lk.babyland.babyland.controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import lk.babyland.babyland.dto.CreateSuggestionDto;
import lk.babyland.babyland.entity.Suggestions;
import lk.babyland.babyland.service.SuggessionService;


@CrossOrigin
@Controller
@RequestMapping("/api/v1/suggestion")
public class SuggestionController {
    @Autowired
    private SuggessionService suggestionService;

    @PostMapping("save")
    public ResponseEntity<Optional<Suggestions>> saveSuggestion(@RequestBody CreateSuggestionDto suggestionInfo) {

        Optional<Suggestions> savedSuggestion = this.suggestionService.saveSuggestion(suggestionInfo);

        if(savedSuggestion.isPresent()) {
            return new ResponseEntity<>(this.suggestionService.saveSuggestion(suggestionInfo) , HttpStatus.CREATED);
        }
        return new ResponseEntity<>(this.suggestionService.saveSuggestion(suggestionInfo) , HttpStatus.BAD_REQUEST);
    }

    @PostMapping("")
    public ResponseEntity<Iterable<Suggestions>> getAllSuggestins() {

        return new ResponseEntity<>(suggestionService.allSuggestionss(), HttpStatus.ACCEPTED);
    }
}
