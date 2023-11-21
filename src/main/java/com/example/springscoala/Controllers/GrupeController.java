package com.example.springscoala.Controllers;


import com.example.springscoala.Services.GrupeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/grupe")
public class GrupeController {
    private GrupeService grupeService;
    @Autowired
public GrupeController(GrupeService grupeService){
        this.grupeService=grupeService;
    }

}
