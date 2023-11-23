package com.example.springscoala.Controllers;
import com.example.springscoala.DTO.Records.StudentiDTO;
import com.example.springscoala.Entity.Studenti;
import com.example.springscoala.Services.StudentiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studenti")
@CrossOrigin
public class StudentiController {

    private final StudentiService studentiService;
    @Autowired
    public StudentiController(StudentiService studentiService){
        this.studentiService=studentiService;
    }

    @GetMapping("/get")
    public List<StudentiDTO> getAllStudents() {
        return studentiService.getAllStudents();

    }

    @GetMapping("/find/{id}")
    public StudentiDTO getStudentById(@PathVariable Integer id) {
      return studentiService.getStudentById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createStudent(@RequestBody Studenti student) {
        studentiService.createStudent(student);
        return  ResponseEntity.accepted().body("Studentul a fost Creat");
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateStudent( @RequestBody Studenti student) {
        studentiService.updateStudent(student);
        return  ResponseEntity.accepted().body("Studentul a fost Actualizat");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer id) {
        studentiService.deleteStudent(id);
        return  ResponseEntity.accepted().body("Studentul a fost Sters");
    }
    @GetMapping("/deletedStudents")
    public List<StudentiDTO> deleteStudentTable() {
        return studentiService.deletedStudents();
    }
    @GetMapping("/restantieri")
    public List<StudentiDTO> restantieri() {
        return studentiService.restantieri();
    }
    @GetMapping("/descrescator")
    public List<StudentiDTO> studentiDescrescatorMedie() {
        return studentiService.StudentiDescrescatorMedie();
    }
}
