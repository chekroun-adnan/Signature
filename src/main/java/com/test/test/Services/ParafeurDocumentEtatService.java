package com.test.test.Services;

import com.test.test.Entities.Parafeur_Document_Etat;
import com.test.test.Repository.ParafeurDocumentEtatRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParafeurDocumentEtatService {

    private final ParafeurDocumentEtatRepository parafeurDocumentEtatRepository;

    public ParafeurDocumentEtatService(ParafeurDocumentEtatRepository parafeurDocumentEtatRepository) {
        this.parafeurDocumentEtatRepository = parafeurDocumentEtatRepository;
    }


    public Parafeur_Document_Etat createParapheurEtat(Parafeur_Document_Etat parafeurDocumentEtat){
        return parafeurDocumentEtatRepository.save(parafeurDocumentEtat);
    }

    public Optional<Parafeur_Document_Etat> getParapheurEtat(Long paraDoc_id){
        return parafeurDocumentEtatRepository.findById(paraDoc_id);
    }

    public void deleteParapheurEtat(Long paraDoc_id){
        Parafeur_Document_Etat existingEtat = parafeurDocumentEtatRepository.findById(paraDoc_id)
                .orElseThrow(()->new RuntimeException("Etat not found with the Id " + paraDoc_id));
        parafeurDocumentEtatRepository.delete(existingEtat);
    }

    public void updateParapheurEtat (Parafeur_Document_Etat parafeurDocumentEtat){
        if (parafeurDocumentEtat.getParaDoc_id() != null){
            Optional<Parafeur_Document_Etat> etat = parafeurDocumentEtatRepository.findById(parafeurDocumentEtat.getParaDoc_id());
            if (etat.isPresent()){
                Parafeur_Document_Etat existingEtat = etat.get();
                existingEtat.setDocument(parafeurDocumentEtat.getDocument());
                existingEtat.setDescription(parafeurDocumentEtat.getDescription());
                existingEtat.setParapheurDocuments(parafeurDocumentEtat.getParapheurDocuments());
                existingEtat.setLibelle(parafeurDocumentEtat.getLibelle());
                parafeurDocumentEtatRepository.save(existingEtat);
            }
        }
    }
}
