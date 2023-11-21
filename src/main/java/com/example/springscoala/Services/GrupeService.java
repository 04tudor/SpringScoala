package com.example.springscoala.Services;


import com.example.springscoala.DTO.Mapper.GrupeMapper;
import com.example.springscoala.Repositoryes.GrupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrupeService  {
    private GrupeRepository grupeRepository;
    private final GrupeMapper grupeMapper;
    @Autowired
    public GrupeService(GrupeRepository studentRepository, GrupeMapper studentMapper){
        this.grupeRepository=studentRepository;
        this.grupeMapper=studentMapper;
    }

}
