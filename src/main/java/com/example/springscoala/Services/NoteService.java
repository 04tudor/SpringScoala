package com.example.springscoala.Services;

import com.example.springscoala.DTO.Mapper.NoteMapper;
import com.example.springscoala.DTO.Records.NoteDTO;
import com.example.springscoala.DTO.Records.StudentiDTO;
import com.example.springscoala.Entity.Note;
import com.example.springscoala.Entity.Studenti;
import com.example.springscoala.Repositoryes.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NoteService {
    private NoteRepository noteRepository;
    private final NoteMapper noteMapper;
    @Autowired
    public NoteService(NoteRepository noteRepository, NoteMapper noteMapper){
        this.noteRepository=noteRepository;
        this.noteMapper=noteMapper;
    }
    public List<NoteDTO> getAllNotes() {
        List<Note>notes= noteRepository.findAll();

        return notes .stream()
                .map(noteMapper)
                .collect(Collectors.toList());
    }

    public NoteDTO getNoteById(int id) {
        return noteRepository.findById(id)
                .map(noteMapper)
                .orElseThrow();

    }

    public void createNote(Note entity) {
        Note note=new Note(
                entity.getCodStudent(),
                entity.getNotaSemestru(),
                entity.getAbsenteNemotivate()
        );
        noteRepository.save(note);

    }
    public void updateNote(Note entity){
        Optional<Note> optionalNote =noteRepository.findById(entity.getId());

        optionalNote.map(note -> {
            note.setCodStudent(entity.getCodStudent());
            note.setNotaSemestru(entity.getNotaSemestru());
            note.setAbsenteNemotivate(entity.getAbsenteNemotivate());

            noteRepository.save(note);
            return ResponseEntity.ok("Note cu id [" + entity.getId() + "] updated successfully");
        }).orElseGet(() ->
                ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Note cu id [" + entity.getId() + "] not found"));
    }

    public ResponseEntity<String> deleteNote(int id) {
        Optional<Note> note = noteRepository.findById(id);
        if (note.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nota cu id [" + id + "] not found");
        }
        noteRepository.delete(note.get());
        return ResponseEntity.ok("Nota with cod [" + id + "] deleted successfully");    }

}
