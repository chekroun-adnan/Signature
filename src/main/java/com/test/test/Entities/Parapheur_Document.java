package com.test.test.Entities;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Parapheur_Document {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long doc_id;
    private LocalDateTime dateEtat;
    @ManyToOne
    @JoinColumn(name = "etat_id")
    private Parafeur_Document_Etat parafeurDocumentEtat;
    @ManyToOne
    @JoinColumn(name = "parapheur_id")
    private Parapheur parapheur;

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
