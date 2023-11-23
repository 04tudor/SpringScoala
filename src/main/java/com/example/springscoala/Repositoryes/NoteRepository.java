package com.example.springscoala.Repositoryes;

import com.example.springscoala.Entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {

    @Modifying
    @Transactional
    @Query( value="INSERT INTO MediiSemestriale (id, MedieSemestriala, OreAbsentateNemotivate) " +
            "SELECT n.id, AVG(n.NotaSemestru) AS MedieSemestriala, SUM(n.AbsenteNemotivate) AS OreAbsentateNemotivate " +
            "FROM Note n " +
            "INNER JOIN (" +
            "    SELECT id " +
            "    FROM Note " +
            "    GROUP BY id " +
            "    HAVING AVG(NotaSemestru) > 5" +
            ") subquery " +
            "ON n.id = subquery.id " +
            "GROUP BY n.id",nativeQuery = true)
    void insertMediiSemestriale() ;

    @Modifying
    @Transactional
    @Query(value = "DELETE  FROM MediiSemestriale",nativeQuery = true)
    void clearTableMediiSemestriale();

    @Modifying
    @Transactional
    @Query( value="INSERT INTO Medii " +
        "SELECT * FROM MediiSemestriale " +
        "WHERE MedieSemestriala > 8.5 AND OreAbsentateNemotivate < 40",nativeQuery = true)
    void insertMediiAdmise();

    @Modifying
    @Transactional
    @Query(value = "DELETE  FROM Medii",nativeQuery = true)
    void clearTableMedii();


    @Query(value = "SELECT * FROM Medii", nativeQuery = true)
    List<Object[]> mediiAdmise();

    @Query(value = "SELECT * FROM mediisemestriale", nativeQuery = true)
    List<Object[]> mediiSemestriale();

}
