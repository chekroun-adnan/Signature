package com.test.test.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Etat_Parapheur {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long etat_id;
    private String libelle;
    private String description;
    private String couleur;

    public Etat_Parapheur() {
    }

    public Long getEtat_id() {
        return etat_id;
    }

    public void setEtat_id(Long etat_id) {
        this.etat_id = etat_id;
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

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
}
