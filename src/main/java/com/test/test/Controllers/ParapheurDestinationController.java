package com.test.test.Controllers;

import com.test.test.Entities.Parapheur_Destination;
import com.test.test.Services.ParapheurDestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/destinations")
public class ParapheurDestinationController {

    @Autowired
    private ParapheurDestinationService destinationService;

    @PostMapping("/add")
    public ResponseEntity<Parapheur_Destination> createDestination(
            @RequestParam Long parapheurId,
            @RequestParam boolean sent) {
        Parapheur_Destination destination = destinationService.createDestination(parapheurId, sent);
        return new ResponseEntity<>(destination, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Parapheur_Destination>> getBySent(@RequestParam boolean sent) {
        List<Parapheur_Destination> list = destinationService.getDestinationsBySentStatus(sent);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Parapheur_Destination> updateSent(
            @PathVariable Long id,
            @RequestParam boolean sent) {
        Parapheur_Destination updated = destinationService.updateSentStatus(id, sent);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
}

