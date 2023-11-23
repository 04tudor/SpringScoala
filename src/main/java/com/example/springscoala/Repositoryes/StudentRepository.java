package com.example.springscoala.Repositoryes;

import com.example.springscoala.Entity.Studenti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Studenti, Integer> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO studentsdeleted (id, nume, prenume, GrupaID) VALUES (:id, :nume, :prenume, :grupaID)", nativeQuery = true)
    void insertTableDeleted(int id, String nume, String prenume, int grupaID);

    @Query(value = "SELECT * FROM studentsdeleted", nativeQuery = true)
    List<Studenti> deletedStudents();


    @Query("SELECT DISTINCT s " +
        "FROM Studenti s " +
        "INNER JOIN Note n ON s.id = n.id " +
        "WHERE n.notaSemestru < 5.00 " +
        "ORDER BY s.nume ASC")
    List<Studenti> studentiRestantieri();



    @Query(value = "SELECT DISTINCT s.id as id, s.nume as nume, s.prenume as prenume, s.grupaID as grupaID " +
            "FROM Studenti s " +
            "INNER JOIN mediisemestriale m ON s.id = m.id " +
            "ORDER BY m.MedieSemestriala DESC", nativeQuery = true)
    List<Studenti> studentiMedieDescrescator();
}
