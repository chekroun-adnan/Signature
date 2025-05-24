package com.test.test.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Parapheur_Document {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long doc_id;
    private LocalDateTime dateEtat;
    private Parafeur_Document_Etat parafeurDocumentEtat;

    public Parapheur_Document() {
    }

    public Parapheur_Document(Long doc_id, LocalDateTime dateEtat, Parafeur_Document_Etat parafeurDocumentEtat) {
        this.doc_id = doc_id;
        this.dateEtat = dateEtat;
        this.parafeurDocumentEtat = parafeurDocumentEtat;
    }

    public Long getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(Long doc_id) {
        this.doc_id = doc_id;
    }

    public LocalDateTime getDateEtat() {
        return dateEtat;
    }

    public void setDateEtat(LocalDateTime dateEtat) {
        this.dateEtat = dateEtat;
    }

    public Parafeur_Document_Etat getParafeurDocumentEtat() {
        return parafeurDocumentEtat;
    }

    public void setParafeurDocumentEtat(Parafeur_Document_Etat parafeurDocumentEtat) {
        this.parafeurDocumentEtat = parafeurDocumentEtat;
    }
}
