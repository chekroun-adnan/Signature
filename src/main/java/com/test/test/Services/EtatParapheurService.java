package com.test.test.Services;


import com.test.test.Entities.Etat_Parapheur;
import com.test.test.Repository.EtatParapheurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EtatParapheurService {

    @Autowired
    private final EtatParapheurRepository etatParapheurRepository;


    public EtatParapheurService(EtatParapheurRepository etatParapheurRepository) {
        this.etatParapheurRepository = etatParapheurRepository;
    }

    public String createEtat(Etat_Parapheur etatParapheur){
        Etat_Parapheur etat = etatParapheurRepository.save(etatParapheur);
        return "Etat Created";
    }

    public void updateEtat(Etat_Parapheur etatParapheur){
        if (etatParapheur.getEtat_id() != null){
            Optional<Etat_Parapheur> etat = etatParapheurRepository.findById(etatParapheur.getEtat_id());
            if (etat.isPresent()){
                Etat_Parapheur existingEtat = etat.get();
                existingEtat.setDescription(etatParapheur.getDescription());
                existingEtat.setLibelle(etatParapheur.getLibelle());
                existingEtat.setCouleur(etatParapheur.getCouleur());
                etatParapheurRepository.save(existingEtat);
            }
        }
    }

    public void deleteEtat(Long Etat_id){
         Etat_Parapheur etatParapheur = etatParapheurRepository.findById(Etat_id)
                 .orElseThrow(()-> new RuntimeException("Etat Not Found with the Id " + Etat_id));
         etatParapheurRepository.delete(etatParapheur);
    }

}
