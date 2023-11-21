package com.example.springscoala.DTO.Mapper;


import com.example.springscoala.DTO.Records.GrupeDTO;
import com.example.springscoala.Entity.Grupe;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class GrupeMapper implements Function<Grupe, GrupeDTO> {
    @Override
    public GrupeDTO apply(Grupe entity) {
        return new GrupeDTO(
                entity.getId(),
                entity.getNumeGrupa()
        );
    }
}