package lk.babyland.babyland.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import lk.babyland.babyland.dto.CreateParentDto;
import lk.babyland.babyland.entity.Parent;
import lk.babyland.babyland.service.ParentService;

import java.util.Optional;

@CrossOrigin
@Controller
@RequestMapping("/api/v1/parent")

public class ParentController {
    @Autowired
    private ParentService parentService;

    @PostMapping("")
    public ResponseEntity<Iterable<Parent>> getAllParents() {

        return new ResponseEntity<>(parentService.allParents(), HttpStatus.ACCEPTED);
    }

    @PostMapping("save")
    public ResponseEntity<Optional<Parent>> saveParent(@RequestBody CreateParentDto parentInfo) {

        Optional<Parent> savedParent = this.parentService.saveParent(parentInfo);

        if(savedParent.isPresent()) {
            return new ResponseEntity<>(this.parentService.saveParent(parentInfo), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(this.parentService.saveParent(parentInfo), HttpStatus.BAD_REQUEST);
    }

}
