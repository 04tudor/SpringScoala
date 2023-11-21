package com.example.springscoala.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "grupe")
public class Grupe implements Entityy {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "numeGrupa")
    private String numeGrupa;

    public Grupe() {
    }

    public Grupe( String numeGrupa) {
        this.numeGrupa = numeGrupa;
    }


    public int getId() {
        return id;
    }

    public void setId(int grupaID) {
        this.id = grupaID;
    }

    public String getNumeGrupa() {
        return numeGrupa;
    }

    public void setNumeGrupa(String numeGrupa) {
        this.numeGrupa = numeGrupa;
    }

    @Override
    public String toString() {
        return "Grupe{" +
                "GrupaID=" + id +
                ", NumeGrupa='" + numeGrupa + '\'' +
                '}';
    }


}
