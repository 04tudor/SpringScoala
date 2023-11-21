package com.example.springscoala.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "note")
public class Note {
    @Column(name = "id")
    @Id
    private int id;
    @Column(name = "idStudent")
    private int codStudent;
    @Column(name = "notaSemestru")
    private double notaSemestru;
    @Column(name = "absenteNemotivate")
    private int absenteNemotivate;


    public Note() {
    }

    public Note( int codStudent, double notaSemestru, int absenteNemotivate) {
        this.codStudent = codStudent;
        this.notaSemestru = notaSemestru;
        this.absenteNemotivate = absenteNemotivate;

    }

    public int getId() {
        return id;
    }

    public void setId(int notaID) {
        this.id = notaID;
    }

    public int getCodStudent() {
        return codStudent;
    }

    public void setCodStudent(int codStudent) {
        this.codStudent = codStudent;
    }

    public double getNotaSemestru() {
        return notaSemestru;
    }

    public void setNotaSemestru(double notaSemestru) {
        this.notaSemestru = notaSemestru;
    }

    public int getAbsenteNemotivate() {
        return absenteNemotivate;
    }

    public void setAbsenteNemotivate(int absenteNemotivate) {
        this.absenteNemotivate = absenteNemotivate;
    }



    @Override
    public String toString() {
        return "Note{" +
                "NotaID=" + id +
                ", CodStudent='" + codStudent + '\'' +
                ", NotaSemestru=" + notaSemestru +
                ", AbsenteNemotivate=" + absenteNemotivate +
                '}';
    }


}
