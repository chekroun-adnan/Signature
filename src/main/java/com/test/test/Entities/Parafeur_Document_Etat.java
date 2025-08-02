package com.test.test.Entities;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Parafeur_Document_Etat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paraDoc_id;
    private String libelle;
    private String description;
    @ManyToOne
    @JoinColumn(name = "document_id")
    private Document document;
    @OneToMany(mappedBy = "parafeurDocumentEtat", cascade = CascadeType.ALL)
    private List<Parapheur_Document> parapheurDocuments;

    public Parafeur_Document_Etat() {
    }

    public Parafeur_Document_Etat(Long paraDoc_id, String libelle, String description, Document document, List<Parapheur_Document> parapheurDocuments) {
        this.paraDoc_id = paraDoc_id;
        this.libelle = libelle;
        this.description = description;
        this.document = document;
        this.parapheurDocuments = parapheurDocuments;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Long getParaDoc_id() {
        return paraDoc_id;
    }

    public void setParaDoc_id(Long paraDoc_id) {
        this.paraDoc_id = paraDoc_id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Parapheur_Document> getParapheurDocuments() {
        return parapheurDocuments;
    }

    public void setParapheurDocuments(List<Parapheur_Document> parapheurDocuments) {
        this.parapheurDocuments = parapheurDocuments;
    }
}
