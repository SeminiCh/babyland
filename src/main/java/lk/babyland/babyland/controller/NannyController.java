package lk.babyland.babyland.controller;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import lk.babyland.babyland.dto.CreateNannyDto;
import lk.babyland.babyland.dto.UpdateNannyDto;
import lk.babyland.babyland.entity.Nanny;
import lk.babyland.babyland.repo.NannyRepo;
import lk.babyland.babyland.service.NannyService;

import java.util.Optional;

@CrossOrigin
@Controller
@RequestMapping("/api/v1/nanny")


public class NannyController {

    @Autowired
    private NannyService nannyService;

    @Autowired
    private NannyRepo nannyRepo;


    @PostMapping("")
    public ResponseEntity<Iterable<Nanny>> getAllNannies() {

        return new ResponseEntity<>(nannyService.allNannies(), HttpStatus.ACCEPTED);
    }

    @GetMapping ("{nannyNic}")
    public ResponseEntity<Optional<Nanny>> getNannyByNic(@PathVariable String nannyNic) {

        return new ResponseEntity<>(nannyService.getNannyByNic(nannyNic), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("delete/{nannyNic}")
    public ResponseEntity<Optional<Nanny>> removeNannyByNannyNic(@PathVariable String nannyNic) {
        Optional<Nanny> deletedNanny = nannyService.removeNannyByNannyNIC(nannyNic);

        if(deletedNanny.isEmpty()) {
            return new ResponseEntity<>(deletedNanny, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(deletedNanny, HttpStatus.ACCEPTED);
    }

    @GetMapping ("Yes")
    public ResponseEntity<Optional<Nanny>> getNannyByAvailability(@PathVariable String availability) {

        return new ResponseEntity<>(nannyService.getNannyByAvailability(availability), HttpStatus.ACCEPTED);
    }


    @PostMapping("save")
    public ResponseEntity<Optional<Nanny>> saveNanny(@RequestBody CreateNannyDto nannyInfo) {

        Optional<Nanny> savedNanny = this.nannyService.saveNanny(nannyInfo);

        if(savedNanny.isPresent()) {
            return new ResponseEntity<>(this.nannyService.saveNanny(nannyInfo), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(this.nannyService.saveNanny(nannyInfo), HttpStatus.BAD_REQUEST);
    }

    @PutMapping("")
    public ResponseEntity<Nanny> updateNanny(@RequestBody UpdateNannyDto nannyInfo) {
        return new ResponseEntity<>(this.nannyService.updateNannyById(nannyInfo), HttpStatus.CREATED);
    }

    @GetMapping("noOfNannies")
    public int getNannies() {
        return (int) nannyRepo.count();
    }

    
    
}
