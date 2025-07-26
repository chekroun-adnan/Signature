package com.test.test.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Parapheur {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long para_id;
    private LocalDateTime dateCreation;
    private List<Parapheur_Document> documents;
    private List<Parapheur_Destination> destinations;
    private Type_Parapheur typeParapheur;
    private Etat_Parapheur etatParapheur;

    public Parapheur() {
    }

    public Parapheur(Long para_id, LocalDateTime dateCreation, List<Document> document, List<Parapheur_Document> documents, List<Parapheur_Destination> destinations, Type_Parapheur typeParapheur, Etat_Parapheur etatParapheur) {
        this.para_id = para_id;
        this.dateCreation = dateCreation;
        this.documents = documents;
        this.destinations = destinations;
        this.typeParapheur = typeParapheur;
        this.etatParapheur = etatParapheur;
    }

    public Long getPara_id() {
        return para_id;
    }

    public void setPara_id(Long para_id) {
        this.para_id = para_id;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public List<Parapheur_Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Parapheur_Document> documents) {
        this.documents = documents;
    }

    public List<Parapheur_Destination> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<Parapheur_Destination> destinations) {
        this.destinations = destinations;
    }

    public Type_Parapheur getTypeParapheur() {
        return typeParapheur;
    }

    public void setTypeParapheur(Type_Parapheur typeParapheur) {
        this.typeParapheur = typeParapheur;
    }

    public Etat_Parapheur getEtatParapheur() {
        return etatParapheur;
    }

    public void setEtatParapheur(Etat_Parapheur etatParapheur) {
        this.etatParapheur = etatParapheur;
    }
}
