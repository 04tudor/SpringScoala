package com.example.springscoala.DTO.Mapper;


import com.example.springscoala.DTO.Records.NoteDTO;
import com.example.springscoala.Entity.Note;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class NoteMapper implements Function<Note, NoteDTO> {
    @Override
    public NoteDTO apply(Note entity) {
        return new NoteDTO(
                entity.getId(),
                entity.getCodStudent(),
                entity.getNotaSemestru(),
                entity.getAbsenteNemotivate()
        );
    }
}
