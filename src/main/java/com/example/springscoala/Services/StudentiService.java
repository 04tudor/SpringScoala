package com.example.springscoala.Services;


import com.example.springscoala.DTO.Mapper.StudentMapper;
import com.example.springscoala.DTO.Records.StudentiDTO;
import com.example.springscoala.Entity.Studenti;
import com.example.springscoala.Repositoryes.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentiService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    @Autowired
    public StudentiService(StudentRepository studentRepository,StudentMapper studentMapper){
        this.studentRepository=studentRepository;
        this.studentMapper=studentMapper;
    }
    public List<StudentiDTO> getAllStudents() {
        List<Studenti>studentiList= studentRepository.findAll();

        return studentiList .stream()
                .map(studentMapper)
                .collect(Collectors.toList());
    }

    public StudentiDTO getStudentById(int id) {
        return studentRepository.findById(id)
                .map(studentMapper)
                .orElseThrow();

    }

    public void createStudent(Studenti entity) {
        Studenti studenti=new Studenti(
                entity.getNume(),
                entity.getPrenume(),
                entity.getGrupaID()
        );
        studentRepository.save(studenti);

    }
    public void updateStudent(Studenti studenti){
        Optional<Studenti> optionalStudenti =studentRepository.findById(studenti.getId());

        optionalStudenti.map(studenti1 -> {
            studenti1.setNume(studenti.getNume());
            studenti1.setGrupaID(studenti.getGrupaID());
            studenti1.setPrenume(studenti.getPrenume());

            studentRepository.save(studenti1);
            return ResponseEntity.ok("Student cu id [" + studenti.getId() + "] updated successfully");
        }).orElseGet(() ->
                ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Student cu id [" + studenti.getId() + "] not found"));
    }

    public ResponseEntity<String> deleteStudent (int id) {
        Optional<Studenti> studenti = studentRepository.findById(id);
        if (studenti.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Student cu id [" + id + "] not found");
        }
        studentRepository.delete(studenti.get());
        return ResponseEntity.ok("Student with cod [" + id + "] deleted successfully");    }


}
