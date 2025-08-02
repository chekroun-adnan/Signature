package com.test.test.Services;

import com.test.test.Entities.Parapheur_Document;
import com.test.test.Repository.ParapheurDocumentRepository;
import com.test.test.Repository.ParapheurRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParapheurDocumentService {

    private final ParapheurDocumentRepository parapheurDocumentRepository;

    public ParapheurDocumentService(ParapheurDocumentRepository parapheurDocumentRepository) {
        this.parapheurDocumentRepository = parapheurDocumentRepository;
    }

    public Parapheur_Document createParapheur(Parapheur_Document parapheurDocument){
        return parapheurDocumentRepository.save(parapheurDocument);
    }

    public Optional<Parapheur_Document> getParapheur(Long doc_id){
        return parapheurDocumentRepository.findById(doc_id);
    }

    public void deleteParapheur(Long doc_id){
        Parapheur_Document existingParapheur = parapheurDocumentRepository.findById(doc_id)
                .orElseThrow(()-> new RuntimeException("Parapheur not found"));
        parapheurDocumentRepository.delete(existingParapheur);
    }

    public Parapheur_Document updateParapheur(Parapheur_Document parapheurDocument){
        if (parapheurDocument.getDoc_id() != null){
            Optional<Parapheur_Document> parapheur = parapheurDocumentRepository.findById(parapheurDocument.getDoc_id());
            if (parapheur.isPresent()){
                Parapheur_Document existingPara = parapheur.get();
                existingPara.setDateEtat(parapheurDocument.getDateEtat());
                existingPara.setParafeurDocumentEtat(parapheurDocument.getParafeurDocumentEtat());
                parapheurDocumentRepository.save(existingPara);
            }
        }
    }
}
