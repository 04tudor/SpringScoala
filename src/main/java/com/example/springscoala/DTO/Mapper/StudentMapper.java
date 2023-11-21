package com.example.springscoala.DTO.Mapper;


import com.example.springscoala.DTO.Records.StudentiDTO;
import com.example.springscoala.Entity.Studenti;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class StudentMapper implements Function<Studenti, StudentiDTO> {
    @Override
    public StudentiDTO apply(Studenti studenti) {
        return new StudentiDTO(
                studenti.getId(),
                studenti.getNume(),
                studenti.getPrenume(),
                studenti.getGrupaID()

        );
    }
}
