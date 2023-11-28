package com.example.springscoala.Controllers;


import com.example.springscoala.DTO.Records.GrupeDTO;
import com.example.springscoala.DTO.Records.StudentiDTO;
import com.example.springscoala.Entity.Grupe;
import com.example.springscoala.Entity.Studenti;
import com.example.springscoala.Services.GrupeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grupe")
@CrossOrigin
public class GrupeController {
    private GrupeService grupeService;
    @Autowired
public GrupeController(GrupeService grupeService){
        this.grupeService=grupeService;
    }

    @GetMapping("/get")
    public List<GrupeDTO> getAllGrupe() {
        return grupeService.getAllGrupe();

    }

    @GetMapping("/find/{id}")
    public GrupeDTO getGrupeById(@PathVariable Integer id) {
        return grupeService.getGrupeById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createGrupe(@RequestBody Grupe grupe) {
        grupeService.createGrupe(grupe);
        return  ResponseEntity.accepted().body("Grupa a fost Creata");
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateGrupe( @RequestBody Grupe grupe) {
        grupeService.updateGrupe(grupe);
        return  ResponseEntity.accepted().body("Grupa a fost Actualizata");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteGrupe(@PathVariable Integer id) {
        grupeService.deleteGrupe(id);
        return  ResponseEntity.accepted().body("Grupa a fost Stearsa");
    }

    @GetMapping("/mediaGrupa")
    public List<String> averageGroup() {
        return grupeService.averageGroup();
    }

    @GetMapping("/sumaOreAbsentate")
    public List<String> sumaOreAbsentate() {
        return grupeService.sumaOreAbsentate();
    }
}
