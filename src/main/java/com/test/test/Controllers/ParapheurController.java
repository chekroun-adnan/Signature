package com.test.test.Controllers;

import com.test.test.Entities.Parapheur;
import com.test.test.Services.ParapheurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/parapheur")
public class ParapheurController {

    private final ParapheurService parapheurService;

    public ParapheurController(ParapheurService parapheurService) {
        this.parapheurService = parapheurService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> createParapheur(@RequestBody Parapheur parapheur){
        try{
            parapheurService.createParapheur(parapheur);
            return ResponseEntity.ok("Parapheur Created Successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getParapheur(@RequestParam Long para_id){
        try{
            Optional<Parapheur> parapheur = parapheurService.getParapheur(para_id);
            return ResponseEntity.ok(parapheur);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteParapheur(@RequestParam Long para_id){
        try{
            parapheurService.deleteParapheur(para_id);
            return ResponseEntity.ok("Parapheur with the id "+ para_id + "Deleted");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateParapheur(@RequestBody Parapheur parapheur){
        try{
            parapheurService.updateParapheur(parapheur);
            return ResponseEntity.ok("Parapheur updated Successfully");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
    }
}
