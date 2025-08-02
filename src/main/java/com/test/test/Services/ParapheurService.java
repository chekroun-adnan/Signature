package com.test.test.Services;

import com.test.test.Entities.Parapheur;
import com.test.test.Repository.ParapheurRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParapheurService {

    private final ParapheurRepository parapheurRepository;


    public ParapheurService(ParapheurRepository parapheurRepository) {
        this.parapheurRepository = parapheurRepository;
    }

    public Parapheur createParapheur(Parapheur parapheur){
        return parapheurRepository.save(parapheur);
    }

    public void updateParapheur(Parapheur parapheur){
        if(parapheur.getPara_id() != null){
            Optional<Parapheur> paraph = parapheurRepository.findById(parapheur.getPara_id());
            if(paraph.isPresent()){
                Parapheur existingParapheur = paraph.get();
                existingParapheur.setEtatParapheur(parapheur.getEtatParapheur());
                existingParapheur.setTypeParapheur(parapheur.getTypeParapheur());
                existingParapheur.setDestinations(parapheur.getDestinations());
                existingParapheur.setDocuments(parapheur.getDocuments());
                existingParapheur.setDateCreation(parapheur.getDateCreation());
                parapheurRepository.save(existingParapheur);
            }
        }
    }

    public Optional<Parapheur> getParapheur(Long para_id){
        return parapheurRepository.findById(para_id);
    }

    public void deleteParapheur (Long para_id){
        Parapheur existingParapheur = parapheurRepository.findById(para_id)
                .orElseThrow(()-> new RuntimeException("Parapheur Not Found"));
        parapheurRepository.delete(existingParapheur);
    }
}
