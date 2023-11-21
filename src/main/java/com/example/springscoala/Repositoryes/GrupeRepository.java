package com.example.springscoala.Repositoryes;

import com.example.springscoala.Entity.Grupe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupeRepository extends JpaRepository<Grupe, Integer> {

}
