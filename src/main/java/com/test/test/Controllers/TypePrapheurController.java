package com.test.test.Controllers;

import com.test.test.Entities.Type_Parapheur;
import com.test.test.Services.TypeParapheurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/type")
public class TypePrapheurController {

    private final TypeParapheurService typeParapheurService;

    public TypePrapheurController(TypeParapheurService typeParapheurService) {
        this.typeParapheurService = typeParapheurService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> createType (@RequestBody Type_Parapheur typeParapheur){
        try{
            typeParapheurService.createType(typeParapheur);
            return ResponseEntity.ok("Type Created Successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getType(@RequestParam Long type_id){
        try{
            Optional<Type_Parapheur> typeParapheur =typeParapheurService.getType(type_id);
            return ResponseEntity.ok(typeParapheur);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteType(@RequestParam Long type_id){
        try{
            typeParapheurService.deleteType(type_id);
            return ResponseEntity.ok("Type deleted successfully");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateType(@RequestBody Type_Parapheur typeParapheur){
        try{
            typeParapheurService.updateType(typeParapheur);
            return ResponseEntity.ok("Type Updated Successfully");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
    }
}
