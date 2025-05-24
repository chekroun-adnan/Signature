package com.test.test.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Type_Parapheur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long type_id;
    private String libelle;
    private String description;

    public Type_Parapheur() {
    }

    public Type_Parapheur(Long type_id, String libelle, String description) {
        this.type_id = type_id;
        this.libelle = libelle;
        this.description = description;
    }

    public Long getType_id() {
        return type_id;
    }

    public void setType_id(Long type_id) {
        this.type_id = type_id;
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
}
