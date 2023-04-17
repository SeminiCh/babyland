package lk.babyland.babyland.controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import lk.babyland.babyland.dto.CreateSpecialDto;
import lk.babyland.babyland.entity.SpecialRequest;
import lk.babyland.babyland.service.SpecialService;

@CrossOrigin
@Controller
@RequestMapping("/api/v1/specialreq")
public class SpecialRequestController {

    @Autowired
    private SpecialService specialService;

    @PostMapping(" ")
    public ResponseEntity<Iterable<SpecialRequest>> getAllSpecialRequests(){
        return new ResponseEntity<> (specialService.allSpecialRequests(), HttpStatus.ACCEPTED);

    }

    @PostMapping("save")
    public ResponseEntity<Optional<SpecialRequest>> saveRequest(@RequestBody CreateSpecialDto specialInfo) {

        Optional<SpecialRequest> savedRequest = this.specialService.saveRequest(specialInfo);

        if(savedRequest.isPresent()) {
            return new ResponseEntity<>(this.specialService.saveRequest(specialInfo), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(this.specialService.saveRequest(specialInfo), HttpStatus.BAD_REQUEST);
    }
    
}
