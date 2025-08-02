package com.test.test.Entities;


import jakarta.persistence.*;

@Entity
public class Parapheur_Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long des_id;
    private boolean sent;
    @ManyToOne
    @JoinColumn(name = "parapheur_id")
    private Parapheur parapheur;

    public Parapheur_Destination() {

    }


    private boolean isSent(){
        return sent;
    }

    public void setSent(boolean sent){
        this.sent = sent;
    }

    public Parapheur_Destination(Long des_id, boolean sent) {
        this.des_id = des_id;
        this.sent = sent;
    }

    public Long getDes_id() {
        return des_id;
    }

    public void setDes_id(Long des_id) {
        this.des_id = des_id;
    }

    public Parapheur getParapheur() {
        return parapheur;
    }

    public void setParapheur(Parapheur parapheur) {
        this.parapheur = parapheur;
    }
}
