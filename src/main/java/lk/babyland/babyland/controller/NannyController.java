package lk.babyland.babyland.controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import lk.babyland.babyland.dto.CreateNannyDto;
import lk.babyland.babyland.dto.UpdateNannyStatus;
import lk.babyland.babyland.entity.Nanny;
import lk.babyland.babyland.repo.NannyRepo;
import lk.babyland.babyland.service.NannyService;

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

    @PutMapping("update/{nannyNic}")
    public ResponseEntity<Nanny> updateNanny(@PathVariable("nannyNic") String nannyNic, @RequestBody Nanny nanny) {
        return new ResponseEntity<Nanny>(nannyService.updateNanny(nanny, nannyNic), HttpStatus.OK);
    }

    @PutMapping("update/status")
    public ResponseEntity<Nanny> updateNannyStatus(@RequestBody UpdateNannyStatus updateNannyStatus) {
        return new ResponseEntity<Nanny>(nannyService.updateNannyStatus(updateNannyStatus), HttpStatus.OK);
    }

    @GetMapping("noOfNannies")
    public int countNannies() {
        long count = nannyRepo.count();
        return (int) (count);
    }

    
    
}
