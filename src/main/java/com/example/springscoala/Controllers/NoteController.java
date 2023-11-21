package com.example.springscoala.Controllers;

import com.example.springscoala.DTO.Records.NoteDTO;
import com.example.springscoala.DTO.Records.StudentiDTO;
import com.example.springscoala.Entity.Note;
import com.example.springscoala.Entity.Studenti;
import com.example.springscoala.Services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/note")
public class NoteController {

    private NoteService noteService;
    @Autowired
    public NoteController(NoteService noteService){
        this.noteService=noteService;
    }

    @GetMapping("/get")
    public List<NoteDTO> getAllNote() {
        return noteService.getAllNotes();

    }

    @GetMapping("/find/{id}")
    public NoteDTO getNotetById(@PathVariable Integer id) {
        return noteService.getNoteById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createNote(@RequestBody Note note) {
        noteService.createNote(note);
        return  ResponseEntity.accepted().body("Nota a fost Creata");
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateNote( @RequestBody Note note) {
        noteService.updateNote(note);
        return  ResponseEntity.accepted().body("Nota a fost Actualizat");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteNote(@PathVariable Integer id) {
        noteService.deleteNote(id);
        return  ResponseEntity.accepted().body("Nota a fost Stearsa");
    }

}
