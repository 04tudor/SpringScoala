package com.example.springscoala.Controllers;

import com.example.springscoala.Services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/note")
public class NoteController {

    private NoteService noteService;
    @Autowired
    public NoteController(NoteService noteService){
        this.noteService=noteService;
    }

}
