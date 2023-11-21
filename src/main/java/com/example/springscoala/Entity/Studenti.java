package com.example.springscoala.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name= "studenti")
public class Studenti {

    @Column(name = "id")
    @Id
    private int id;
    @Column(name = "Nume")
    private String nume;

    @Column(name = "Prenume")
    private String prenume;

    @Column(name = "GrupaID")
    private int grupaID;

    public Studenti() {
    }

    public Studenti(String nume, String prenume, int grupaID) {
        this.nume = nume;
        this.prenume = prenume;
        this.grupaID = grupaID;
    }



    public int getId() {
        return id;
    }

    public void setId(int codStudent) {
        this.id = codStudent;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public int getGrupaID() {
        return grupaID;
    }

    public void setGrupaID(int grupaID) {
        this.grupaID = grupaID;
    }

    @Override
    public String toString() {
        return "Studenti{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", grupaID=" + grupaID +
                '}';
    }
}
