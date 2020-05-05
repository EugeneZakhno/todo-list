package io.github.eugenezakhno.todolist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class NoteController {

    private NoteService service;

    @Autowired
    public void setNoteService(NoteService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String list(Model model) {
        return "index";
    }
}