package com.example.springscoala.Services;


import com.example.springscoala.DTO.Mapper.GrupeMapper;
import com.example.springscoala.DTO.Records.GrupeDTO;
import com.example.springscoala.DTO.Records.StudentiDTO;
import com.example.springscoala.Entity.Grupe;
import com.example.springscoala.Entity.Studenti;
import com.example.springscoala.Repositoryes.GrupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GrupeService  {
    private GrupeRepository grupeRepository;
    private final GrupeMapper grupeMapper;
    @Autowired
    public GrupeService(GrupeRepository studentRepository, GrupeMapper studentMapper){
        this.grupeRepository=studentRepository;
        this.grupeMapper=studentMapper;
    }
    public List<GrupeDTO> getAllGrupe() {
        List<Grupe>grupeList= grupeRepository.findAll();

        return grupeList .stream()
                .map(grupeMapper)
                .collect(Collectors.toList());
    }

    public GrupeDTO getGrupeById(int id) {
        return grupeRepository.findById(id)
                .map(grupeMapper)
                .orElseThrow();

    }

    public void createGrupe(Grupe entity) {
        Grupe grupe=new Grupe(
                entity.getNumeGrupa()

        );
        grupeRepository.save(grupe);

    }
    public void updateGrupe(Grupe grupe){
        Optional<Grupe> optionalGrupe =grupeRepository.findById(grupe.getId());

        optionalGrupe.map(grupe1 -> {
            grupe1.setNumeGrupa(grupe.getNumeGrupa());

            grupeRepository.save(grupe1);
            return ResponseEntity.ok("Grupa cu id [" + grupe.getId() + "] updated successfully");
        }).orElseGet(() ->
                ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Grupa cu id [" + grupe.getId() + "] not found"));
    }

    public ResponseEntity<String> deleteGrupe(int id) {
        Optional<Grupe> optionalGrupe =grupeRepository.findById(id);
        if (optionalGrupe.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Grupa cu id [" + id + "] not found");
        }
        grupeRepository.delete(optionalGrupe.get());
        return ResponseEntity.ok("Student with cod [" + id + "] deleted successfully");    }
    public List<String> averageGroup() {
        List<Object[]> results = grupeRepository.averageGroup();

        return results.stream()
                .map(row -> {
                    String groupName = (String) row[0];
                    Double averageNotaSemestriala = (Double) row[1];
                    return "Grupa: " + groupName + ", Medie Nota Semestriala: " + averageNotaSemestriala;
                })
                .collect(Collectors.toList());
    }

    public List<String> sumaOreAbsentate() {
        List<Object[]> results = grupeRepository.sumOreAbsentate();
        return results.stream()
                .map(row -> {
                    String groupName = (String) row[0];
                    Long totalUnexcusedAbsences = ((Number) row[1]).longValue();
                    return "Grupa: " + groupName + ", Total Absente Nemotivate: " + totalUnexcusedAbsences;
                })
                .collect(Collectors.toList());
    }
}
