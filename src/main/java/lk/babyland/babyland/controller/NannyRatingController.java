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

import lk.babyland.babyland.dto.CreateNannyRating;
import lk.babyland.babyland.entity.NannyRating;
import lk.babyland.babyland.service.NannyRatingService;


@CrossOrigin
@Controller
@RequestMapping("/api/v1/nannyRating")
public class NannyRatingController {
    
    @Autowired
    private NannyRatingService nannyRatingService;

    @PostMapping("save")
    public ResponseEntity<Optional<NannyRating>> saveNannyRating(@RequestBody CreateNannyRating nannyRatingInfo) {

        Optional<NannyRating> savednannyRating = this.nannyRatingService.saveNannyRating(nannyRatingInfo);

        if(savednannyRating.isPresent()) {
            return new ResponseEntity<>(this.nannyRatingService.saveNannyRating(nannyRatingInfo), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(this.nannyRatingService.saveNannyRating(nannyRatingInfo), HttpStatus.BAD_REQUEST);
    }

    @PostMapping("view")
    public ResponseEntity<Iterable<NannyRating>> getAllNannyRating(){
        return new ResponseEntity<> (nannyRatingService.allNannyRating(), HttpStatus.ACCEPTED);
    }

}
