package com.test.test.Controllers;

import com.test.test.Entities.Parapheur;
import com.test.test.Entities.Parapheur_Document;
import com.test.test.Services.ParapheurDocumentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/parapheurDoc")
public class ParapheurDocumentController {

    private final ParapheurDocumentService parapheurDocumentService;

    public ParapheurDocumentController(ParapheurDocumentService parapheurDocumentService) {
        this.parapheurDocumentService = parapheurDocumentService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> createParapheur(@RequestBody Parapheur_Document parapheurDocument){
        try{
            parapheurDocumentService.createParapheur(parapheurDocument);
            return ResponseEntity.ok("Parapheur Document Created Successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getParapheur(@RequestParam Long doc_id){
        try{
            Optional<Parapheur_Document> parapheurDoc = parapheurDocumentService.getParapheur(doc_id);
            return ResponseEntity.ok(parapheurDoc);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteParapheur(@RequestParam Long doc_id){
        try{
            parapheurDocumentService.deleteParapheur(doc_id);
            return ResponseEntity.ok("Parapheur with the id "+ doc_id + "Deleted");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateParapheur(@RequestBody Parapheur_Document parapheurDocument){
        try{
            parapheurDocumentService.updateParapheur(parapheurDocument);
            return ResponseEntity.ok("Parapheur updated Successfully");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
    }
}
