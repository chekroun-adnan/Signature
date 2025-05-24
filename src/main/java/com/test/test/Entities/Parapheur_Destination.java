package com.test.test.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Parapheur_Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long des_id;
    private boolean sent;


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
}
