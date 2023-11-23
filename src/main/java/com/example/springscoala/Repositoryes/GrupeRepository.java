package com.example.springscoala.Repositoryes;

import com.example.springscoala.Entity.Grupe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GrupeRepository extends JpaRepository<Grupe, Integer> {
    @Query(value = "SELECT G.numeGrupa, AVG(N.notaSemestru) AS AverageNotaSemestriala " +
            "FROM Note N " +
            "JOIN Studenti S ON N.id = S.id " +
            "JOIN Grupe G ON S.grupaID = G.id " +
            "GROUP BY G.id, G.numeGrupa")
    List<Object[]> averageGroup();

    @Query(value = "SELECT G.numeGrupa, SUM(N.absenteNemotivate) AS SumOreAbsentate " +
            "FROM Note N " +
            "JOIN Studenti S ON N.id = S.id " +
            "JOIN Grupe G ON S.grupaID = G.id " +
            "GROUP BY G.id, G.numeGrupa")
    List<Object[]> sumOreAbsentate();
}
