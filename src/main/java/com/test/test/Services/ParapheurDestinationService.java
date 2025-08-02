package com.test.test.Services;

import com.test.test.Entities.Parapheur;
import com.test.test.Entities.Parapheur_Destination;
import com.test.test.Repository.ParapheurDestinationRepository;
import com.test.test.Repository.ParapheurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParapheurDestinationService {

    @Autowired
    private ParapheurDestinationRepository parapheurDestinationRepository;

    @Autowired
    private ParapheurRepository parapheurRepository;

    public Parapheur_Destination createDestination(Long parapheurId, boolean sent) {
        Parapheur parapheur = parapheurRepository.findById(parapheurId)
                .orElseThrow(() -> new RuntimeException("Parapheur not found"));

        Parapheur_Destination destination = new Parapheur_Destination();
        destination.setParapheur(parapheur);
        destination.setSent(sent);

        return parapheurDestinationRepository.save(destination);
    }

    public List<Parapheur_Destination> getDestinationsBySentStatus(boolean sent) {
        return parapheurDestinationRepository.findBySent(sent);
    }

    public Parapheur_Destination updateSentStatus(Long desId, boolean sent) {
        Parapheur_Destination destination = parapheurDestinationRepository.findById(desId)
                .orElseThrow(() -> new RuntimeException("Destination not found"));
        destination.setSent(sent);
        return parapheurDestinationRepository.save(destination);
    }
}

