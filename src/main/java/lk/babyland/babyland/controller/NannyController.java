package lk.babyland.babyland.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import lk.babyland.babyland.dto.CreateNannyDto;
import lk.babyland.babyland.entity.Nanny;
import lk.babyland.babyland.service.NannyService;

import java.util.Optional;

@CrossOrigin
@Controller
@RequestMapping("/api/v1/nanny")


public class NannyController {

    @Autowired
    private NannyService nannyService;

    @PostMapping("")
    public ResponseEntity<Iterable<Nanny>> getAllNannies() {

        return new ResponseEntity<>(nannyService.allNannies(), HttpStatus.ACCEPTED);
    }

    


    @PostMapping("save")
    public ResponseEntity<Optional<Nanny>> saveNanny(@RequestBody CreateNannyDto nannyInfo) {

        Optional<Nanny> savedNanny = this.nannyService.saveNanny(nannyInfo);

        if(savedNanny.isPresent()) {
            return new ResponseEntity<>(this.nannyService.saveNanny(nannyInfo), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(this.nannyService.saveNanny(nannyInfo), HttpStatus.BAD_REQUEST);
    }
    
}
