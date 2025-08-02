package com.test.test.Controllers;


import com.test.test.Entities.Etat_Parapheur;
import com.test.test.Services.EtatParapheurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/etat")
public class EtatParapheurController {

    @Autowired
    private final EtatParapheurService etatParapheurService;

    public EtatParapheurController(EtatParapheurService etatParapheurService) {
        this.etatParapheurService = etatParapheurService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> createEtat(@RequestBody Etat_Parapheur etatParapheur){
        try{
            etatParapheurService.createEtat(etatParapheur);
            return ResponseEntity.ok("Etat created Successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateEtat(@RequestBody Etat_Parapheur etatParapheur){
        try{
            etatParapheurService.updateEtat(etatParapheur);
            return ResponseEntity.ok("Etat Updated Successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteEtat(@RequestParam Long etat_id){
        try{
            etatParapheurService.deleteEtat(etat_id);
            return ResponseEntity.ok("Etat with the id : "+ etat_id + " deleted");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
    }
}
