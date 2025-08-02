package com.test.test.Controllers;


import com.test.test.Entities.Parafeur_Document_Etat;
import com.test.test.Services.ParafeurDocumentEtatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/parapheurEtat")
public class ParafeurDocumentEtatController {

    private final ParafeurDocumentEtatService parafeurDocumentEtatService;

    public ParafeurDocumentEtatController(ParafeurDocumentEtatService parafeurDocumentEtatService) {
        this.parafeurDocumentEtatService = parafeurDocumentEtatService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> createParapheurEtat(@RequestBody Parafeur_Document_Etat parafeurDocumentEtat){
        try{
            parafeurDocumentEtatService.createParapheurEtat(parafeurDocumentEtat);
            return ResponseEntity.ok("Parapheur Etat created Successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getParapheurEtat(@RequestParam Long paraDoc_id){
        try{
            Optional<Parafeur_Document_Etat> existingEtat = parafeurDocumentEtatService.getParapheurEtat(paraDoc_id);
            return ResponseEntity.ok(existingEtat);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteParapheurEtat(@RequestParam Long paraDoc_id){
        try{
            parafeurDocumentEtatService.deleteParapheurEtat(paraDoc_id);
            return ResponseEntity.ok("Etat deleted Successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateParapheurEtat(@RequestBody Parafeur_Document_Etat parafeurDocumentEtat){
        try{
            parafeurDocumentEtatService.updateParapheurEtat(parafeurDocumentEtat);
            return ResponseEntity.ok("Etat updated Successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
    }
}
